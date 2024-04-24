package chiselbook

import chisel3._
import chisel3.util._

//- start popcnt_fsm
class PopCountFSM extends Module {
  val io = IO(new Bundle {
    val dinValid = Input(Bool())
    val dinReady = Output(Bool())
    val popCntValid = Output(Bool())
    val popCntReady = Input(Bool())
    val load = Output(Bool())
    val done = Input(Bool())
  })

  object State extends ChiselEnum {
    val idle, count, done = Value
  }
  import State._
  val stateReg = RegInit(idle)
  io.load := false.B
  io.dinReady := false.B
  io.popCntValid := false.B

  switch(stateReg) {
    is(idle) {
      io.dinReady := true.B
      when(io.dinValid) {
        io.load := true.B
        stateReg := count
      }
    }
    is(count) {
      when(io.done) {
        stateReg := done
      }
    }
    is(done) {
      io.popCntValid := true.B
      when(io.popCntReady) {
        stateReg := idle
      }
    } } }
//- end

//- start popcnt_data
class PopCountDataPath extends Module {
  val io = IO(new Bundle {
    val din = Input(UInt(64.W))
    val load = Input(Bool())
    val popCnt = Output(UInt(32.W))
    val done = Output(Bool())
  })

  val dataReg = RegInit(0.U(64.W))
  val popCntReg = RegInit(0.U(64.W))
  val counterReg= RegInit(0.U(32.W))

  dataReg := 0.U ## dataReg(63, 1)
  popCntReg := popCntReg + dataReg(0)

  val done = counterReg === 0.U
  when (!done) {
    counterReg := counterReg - 1.U
  }

  when(io.load) {
    dataReg := io.din
    popCntReg := 0.U
    counterReg := 32.U
  }

  // debug output
  // printf("%x %d\n", dataReg, popCntReg)

  io.popCnt := popCntReg
  io.done := done
}
//- end

//- start popcnt_main
class PopulationCount extends Module {
  val io = IO(new Bundle {
    val dinValid = Input(Bool())
    val dinReady = Output(Bool())
    val din = Input(UInt(64.W))
    val popCntValid = Output(Bool())
    val popCntReady = Input(Bool())
    val popCnt = Output(UInt(32.W))
  })


  val fsm = Module(new PopCountFSM)
  val data = Module(new PopCountDataPath)

  fsm.io.dinValid := io.dinValid
  io.dinReady := fsm.io.dinReady
  io.popCntValid := fsm.io.popCntValid
  fsm.io.popCntReady := io.popCntReady

  data.io.din := io.din
  io.popCnt := data.io.popCnt
  data.io.load := fsm.io.load
  fsm.io.done := data.io.done
   
  // assertion begin
  
  when(io.din === "hffffffffffffffff".U && io.dinValid) {
    when(io.popCntValid) {
      assert(io.popCnt === 30.U)
    }
  }
  // val count = RegInit(30.U(32.W))
  // count := count - 1.U
  // when(count === 0.U) {
  //   assert(io.popCnt === 3.U)
  // }
  
}
//- end
// TODO: bulk connections should do the work.
