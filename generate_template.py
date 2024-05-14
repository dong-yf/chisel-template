import random
import os

def generate_chisel_code(inputs, module_name):
    chisel_code = "package template\n"
    chisel_code += "\n"
    chisel_code += "import chisel3._\n"
    chisel_code += "import chisel3.util._\n"
    chisel_code += "\n"
    chisel_code += f"class {module_name} extends Module \n" + "{\n"
    chisel_code += "  val io = IO(new Bundle {\n"

    for input_name in inputs:
        chisel_code += f"    val {input_name} = Input(Bool())\n"

    chisel_code += f"    val out = Output(UInt(8.W))\n"
    chisel_code += "  })\n"

    chisel_code += "\n"
    chisel_code += init_registers(200)
    chisel_code += add_conditional_logic(inputs)
    chisel_code += "  io.out := w\n"
    chisel_code += "  count := count - 1.U\n"
    chisel_code += add_assertion()

    chisel_code += "}"

    return chisel_code

def init_registers(bound):
    # count = reginit(bound)
    return f"  val w = RegInit(0.U(8.W))\n  val count = RegInit({bound}.U(32.W))\n"

def add_conditional_logic(inputs):
    conditional_logic = ""
    conditional_logic += add_when(inputs)
    return conditional_logic
    
def add_when(inputs):
    when_code = ""
    for idx, input_name in enumerate(inputs):
        when_code += f"   when(io.{input_name}) {{\n"
        r = random.randint(1, 30)
        # if idx == len(inputs) - 1:
        #     when_code += f"     w := {r}.U\n"
        # else:
        #     when_code += f"     w := w + {r}.U\n"
        when_code += add_statement()
        when_code += f"   }}\n"
    return when_code

def add_statement():
    r1 = random.randint(0, 2)
    r2 = random.randint(1, 10)
    if r1 == 0:
        return f"     w := w + {r2}.U\n"
    elif r1 == 1:
        return f"     w := w - {r2}.U\n"
    else:
        return f"     w := {r2}.U\n"

def add_assertion():
    r = random.randint(1, 10)
    assertion = ""
    assertion += "  when (count === 0.U) {\n"
    assertion += f"    assert(w === {r}.U)\n"
    assertion += "  }\n"
    return assertion

def generate_inputs(n):
    inputs = []
    for i in range(n):
        inputs.append(f"input{i}")
    return inputs

def generate_test(module_name, bound):
    test_code = f"package template\n"
    test_code += "\n"
    test_code += "import chisel3._\n"
    test_code += "import chiseltest._\n"
    test_code += "import chiseltest.formal._\n"
    test_code += "import org.scalatest.flatspec.AnyFlatSpec\n"
    test_code += "\n"
    test_code += f"class {module_name}FormalSpec extends AnyFlatSpec with Formal with ChiselScalatestTester " + "{\n"
    test_code += f"  behavior of \"{module_name}\"\n"
    test_code += "it should \"pass\" in {\n"
    test_code += f"    verify(new {module_name}(), Seq(BoundedCheck({bound}), Z3EngineAnnotation))\n"
    test_code += "  }\n"
    test_code += "}"
    
    return test_code


if __name__ == "__main__":
    inputs = generate_inputs(8)
    bound = 200

    for i in range(20, 30):
        module_name = f"Template{i:02}"
        chisel_code = generate_chisel_code(inputs, module_name)
        with open(f"src/main/scala/template/{module_name}.scala", "w") as f:
            f.write(chisel_code)
        # print(chisel_code)

        test_code = generate_test(module_name, bound)
        with open(f"src/test/scala/template/{module_name}FormalSpec.scala", "w") as f:
            f.write(test_code)
        
    dir = "src/test/scala/template/"
    files = os.listdir(dir)
    for file in files:
        # only test files that haven't been tested
        smtname = f"{bound}-{file[:-6]}.smt2"
        # if not in test-examples
        if smtname in os.listdir("test-examples"):
            continue
        print(file)
        if file.endswith("FormalSpec.scala"):
            print("Running test")
            os.system(f"sbt 'testOnly template.{file[:-6]}'")
            print("Done")
            # rename t.smt2 to bound-{file[:-6]}.smt2
            os.system(f"mv t.smt2 test-examples/{bound}-{file[:-6]}.smt2")



# chisel_code = generate_chisel_code(inputs)
# # write chisel code to file
# with open("src/main/scala/template/MyModule.scala", "w") as f:
#     f.write(chisel_code)

# print(chisel_code)