package example

import chisel3._
import chisel3.util._

class Example extends Module { 
    val io = IO(new Bundle { 
        val en = Input(Bool()) 
        val x = Input(UInt(8.W)) 
        val y = Input(UInt(8.W)) 
        val z = Input(UInt(8.W)) 
        val o = Output(Bool())
    })
    
    val u = RegInit(0.U(8.W))
    val v = RegInit(0.U(8.W))
    val w = RegInit(0.U(8.W))
    io.o := false.B 
    when(io.en)
    {
    when(io.x < io.y)
    {
    when (io.y < io.z)
    {
        io.o := true.B
        u := io.x
        v := io.y
        w := io.z
    }
    }
    }
    assert(!io.o || io.x + 2.U < io.z)
}

class Example3 extends Module { 
  val io = IO(new Bundle {
    val x = Input(UInt(8.W))
    val y = Input(UInt(8.W))
    val z = Input(UInt(8.W))
    val o = Output(Bool())
    val u = Output(UInt(8.W))
    val v = Output(UInt(8.W))
  })

  // Internal registers
  val u_reg = RegInit(0.U(8.W))
  val v_reg = RegInit(0.U(8.W))

  // Initialize output signals
  io.o := false.B
  u_reg := 0.U
  v_reg := 0.U

  // Update v_reg based on conditions
  when(io.x < io.y && io.y < io.z) {
    v_reg := io.y
  }

  // Update u_reg and o based on conditions
  when(io.x + 10.U < io.y || io.x + 9.U < io.y || io.x + 8.U < io.y || io.x + 7.U < io.y ||
       io.x + 6.U < io.y || io.x + 5.U < io.y || io.x + 4.U < io.y || io.x + 3.U < io.y ||
       io.x + 2.U < io.y || io.x + 1.U < io.y || io.x < io.y) {

    when(io.y + 10.U < io.z || io.y + 9.U < io.z || io.y + 8.U < io.z || io.y + 7.U < io.z ||
         io.y + 6.U < io.z || io.y + 5.U < io.z || io.y + 4.U < io.z || io.y + 3.U < io.z ||
         io.y + 2.U < io.z || io.y + 1.U < io.z || io.y < io.z) {
      
      io.o := true.B
      u_reg := io.x
    }
  }

  // Update outputs
  io.u := u_reg
  io.v := v_reg

  // Count for assertion
  val count = RegInit(0.U(8.W))
  count := count + 1.U

  // Assertion
  when(count === 50.U) {
    assert(!io.o || io.x + 2.U < io.z)
  }
}

class Example4 extends Module { 
  val io = IO(new Bundle {
    val x = Input(UInt(8.W)) 
    val y = Input(UInt(8.W)) 
    val z = Input(UInt(8.W)) 
    val o = Output(Bool())
    val u = Output(UInt(8.W))
    val v = Output(UInt(8.W))
  })

  io.o := false.B
  io.u := 0.U
  io.v := 0.U

  when(io.x < io.y && io.y < io.z) {
    io.v := io.y
  }

  val xLessY = (0 until 51).map(i => (io.x + i.U) < io.y).reduce(_ || _)
  val yLessZ = (0 until 51).map(i => (io.y + i.U) < io.z).reduce(_ || _)

  when(xLessY) {
    when(yLessZ) {
      io.o := true.B
      io.u := io.x
    }
  }

  assert(!io.o || io.x + 2.U < io.z)
}
class Example10 extends Module { 
	val io = IO(new Bundle {
		val x = Input(UInt(8.W)) 
		val y1 = Input(UInt(8.W)) 
		val y2 = Input(UInt(8.W)) 
		val y3 = Input(UInt(8.W)) 
		val y4 = Input(UInt(8.W)) 
		val y5 = Input(UInt(8.W)) 
		val y6 = Input(UInt(8.W)) 
		val y7 = Input(UInt(8.W)) 
		val y8 = Input(UInt(8.W)) 
		val y9 = Input(UInt(8.W)) 
		val y10 = Input(UInt(8.W)) 

		val en1 = Input(Bool())
		val en2 = Input(Bool())
		val z = Input(UInt(8.W)) 
		val u = Output(UInt(8.W))
		val v = Output(UInt(8.W))
	})
	val a = io.en1 && io.en2
	val res = Wire(UInt(8.W))

	io.u := 0.U
	io.v := 0.U
	res := 3.U
	
	when(io.en1)
	{
		io.v := io.y1
	}
	when(a)
	{
		io.v := io.y2
	}
	when(
	(!io.en1 && io.x+1.U < io.y10) || (!io.en1 && io.x+1.U < io.y9) || (!io.en1 && io.x+1.U < io.y8) || (!io.en1 && io.x+1.U < io.y7) || (!io.en1 && io.x+1.U < io.y6) || (!io.en1 && io.x+1.U < io.y5) || (!io.en1 && io.x+1.U < io.y4) || (!io.en1 && io.x+1.U < io.y3) || (!io.en1 && io.x+1.U < io.y2) || (io.en1 && io.x < io.y1) 
	)
	{
		when(
		(!io.en2 && io.y10+1.U < io.z) || (!io.en2 && io.y9+1.U < io.z) || (!io.en2 && io.y8+1.U < io.z) || (!io.en2 && io.y7+1.U < io.z) || (!io.en2 && io.y6+1.U < io.z) || (!io.en2 && io.y5+1.U < io.z) || (!io.en2 && io.y4+1.U < io.z) || (!io.en2 && io.y3+1.U < io.z) || (!io.en2 && io.y2+1.U < io.z) || (io.en2 && io.y1 < io.z) 
		)
		{
			io.u := io.x
			res := io.z - io.x
		}
	}
	assert(res > 2.U)
}

object emitFIRRTL extends App {
  (new chisel3.stage.ChiselStage()).emitFirrtl(
    new example.Example10(),
    Array("--target-dir", "generated")
  )
}