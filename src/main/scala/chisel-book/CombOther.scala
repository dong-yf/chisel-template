package chiselbook

import chisel3._
import chisel3.util._

class CombOther extends Module {
  val io = IO(new Bundle {
    val cond = Input(Bool())
    val out = Output(UInt(4.W))
  })

  val cond = io.cond
  //- start comb_otherwise
  val w = RegInit(0.U(4.W))

  when (cond) {
    w := w + 1.U
  } .otherwise {
    w := w + 2.U
  }
  //- end
  io.out := w

  // assertion begin
  val count = RegInit(200.U(32.W))
  count := count - 1.U
  when(count === 0.U) {
    assert(w === 2.U)
  }
}