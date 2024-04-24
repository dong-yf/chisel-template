package chiselbook

/*
 * This code is a minimal hardware described in Chisel.
 * 
 * Copyright: 2013, Technical University of Denmark, DTU Compute
 * Author: Martin Schoeberl (martin@jopdesign.com)
 * License: Simplified BSD License
 * 
 * Blinking LED: the FPGA version of Hello World
 */

//- start import
import chisel3._
//- end

/**
 * The blinking LED component.
 */

//- start hello
class Hello extends Module {
  val io = IO(new Bundle {
    val led = Output(UInt(1.W))
  })
  val CNT_MAX = (50 / 2 - 1).U
  
  val cntReg = RegInit(0.U(32.W))
  val blkReg = RegInit(0.U(1.W))

  val count = RegInit(0.U(32.W))

  cntReg := cntReg + 1.U
  when(cntReg === CNT_MAX) {
    cntReg := 0.U
    blkReg := ~blkReg
  }
  io.led := blkReg

  // assertion begin
  count := count + 1.U
  when (count === 200.U) {
    assert(io.led === 1.U)
  }
}
//- end
