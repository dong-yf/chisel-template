package chiselbook

import chisel3._

class CombElseWhen extends Module {
  val io = IO(new Bundle {
    val cond = Input(Bool())
    val cond2 = Input(Bool())
    val out = Output(UInt(4.W))
  })

  val cond = io.cond
  val cond2 = io.cond2

  //- start comb_elsewhen
  val w = Wire(UInt())
  val count =  RegInit(200.U(32.W))

  when (cond) {
    w := 1.U
    count := count - 1.U
  } .elsewhen (cond2) {
    w := 2.U
    count := count - 1.U
  } .otherwise {
    w := 3.U
    count := count - 1.U
  }
  //- end
  io.out := w

  when(count === 0.U) {
    assert(w === 3.U)
  }

}