package chiselbook

//- start simple_fsm
import chisel3._
import chisel3.util._

class SimpleFsm extends Module {
  val io = IO(new Bundle{
    val badEvent = Input(Bool())
    val clear = Input(Bool())
    val ringBell = Output(Bool())
  })

  // The three states
  object State extends ChiselEnum {
    val green, orange, red = Value
  }
  import State._
  // The state register
  val stateReg = RegInit(green)

  // Next state logic
  switch (stateReg) {
    is (green) {
      when(io.badEvent) {
        stateReg := orange
      }
    }
    is (orange) {
      when(io.badEvent) {
        stateReg := red
      } .elsewhen(io.clear) {
        stateReg := green
      }
    }
    is (red) {
      when (io.clear) {
        stateReg := green
      }
    }
  }
  // Output logic
  io.ringBell := stateReg === red
  
  // assertion begin
  val count = RegInit(0.U(32.W))
  count := count + 1.U
  when (count === 100.U) {
    assert(io.ringBell)
  }
}
//- end

class SimpleFsmCopy extends Module {
  //- start simple_fsm_io
  val io = IO(new Bundle{
    val badEvent = Input(Bool())
    val clear = Input(Bool())
    val ringBell = Output(Bool())
  })
  //- end

  //- start simple_fsm_states
  object State extends ChiselEnum {
    val green, orange, red = Value
  }
  import State._
  //- end

  //- start simple_fsm_register
  val stateReg = RegInit(green)
  //- end

  //- start simple_fsm_next
  switch (stateReg) {
    is (green) {
      when(io.badEvent) {
        stateReg := orange
      }
    }
    is (orange) {
      when(io.badEvent) {
        stateReg := red
      } .elsewhen(io.clear) {
        stateReg := green
      }
    }
    is (red) {
      when (io.clear) {
        stateReg := green
      }
    }
  }
  //- end

  //- start simple_fsm_output
  io.ringBell := stateReg === red
  //- end
}
