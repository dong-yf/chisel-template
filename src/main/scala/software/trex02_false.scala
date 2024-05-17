package software

import chisel3._
import chisel3.util._

// int __VERIFIER_nondet_int();
// int x;
// void foo() {
//   x--;
// }
// int main() {
//   x=__VERIFIER_nondet_int();
//   while (x > 0) {
//     _Bool c = __VERIFIER_nondet_bool();
//     if(c) foo();
//     else foo();
//   }
//   __VERIFIER_assert(x==0);
// }

class Trex02 extends Module {
    val io = IO(new Bundle {
        val x = Input(UInt(32.W))
        val c = Input(Bool())
    })
    val regX = RegInit(io.x)
    val d1 = 1.U
    val d2 = 1.U
    val count = RegInit(100.U(32.W))

    when (regX > 0.U) {
        when (io.c) {
            regX := regX - d1
        }.otherwise {
            regX := regX - d2
        }
        count := count - 1.U
    }

    when(count === 0.U) {
        assert(regX === 0.U)
    }
    
}