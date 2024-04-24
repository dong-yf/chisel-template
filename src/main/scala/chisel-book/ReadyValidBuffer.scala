package chiselbook

import chisel3._
import chisel3.util._

//- start ready_valid_buffer
class ReadyValidBuffer extends Module {
  val io = IO(new Bundle{
    val in = Flipped(new DecoupledIO(UInt(8.W)))
    val out = new DecoupledIO(UInt(8.W))
  })

  val dataReg = Reg(UInt(8.W))
  val emptyReg = RegInit(true.B)

  io.in.ready := emptyReg
  io.out.valid := !emptyReg
  io.out.bits := dataReg

  when (emptyReg & io.in.valid) {
    dataReg := io.in.bits
    emptyReg := false.B
  }

  when (!emptyReg & io.out.ready) {
    emptyReg := true.B
  }

  // assertion begin
  val count = RegInit(0.U(32.W))
  count := count + 1.U
  when (count === 200.U) {
    assert(emptyReg === false.B)
  }
}
//- end
