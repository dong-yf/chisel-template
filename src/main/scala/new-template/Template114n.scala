package newtemplate

import chisel3._
import chisel3.util._

class Template114n extends Module 
{
  val io = IO(new Bundle {
    val input0 = Input(Bool())
    val input1 = Input(Bool())
    val input2 = Input(Bool())
    val input3 = Input(Bool())
    val input4 = Input(Bool())
    val extra_input0 = Input(Bool())
    val extra_input1 = Input(Bool())
    val output0 = Output(UInt(8.W))
    val output1 = Output(UInt(8.W))
    val output2 = Output(UInt(8.W))
    val extra_output0 = Output(UInt(8.W))
    val extra_output1 = Output(UInt(8.W))
    val extra_output2 = Output(UInt(8.W))
  })

  val w = RegInit(1.U(8.W))
  val count = RegInit(200.U(32.W))
  val reg0 = RegInit(5.U(8.W))
  val reg1 = RegInit(0.U(8.W))
  val reg2 = RegInit(9.U(8.W))
  val extra_reg0 = RegInit(1.U(8.W))
  val extra_reg1 = RegInit(4.U(8.W))
  val extra_reg2 = RegInit(9.U(8.W))
   when(io.input0) {
     w := 4.U
     reg0 := reg0 - 6.U
     reg1 := 8.U
     reg2 := reg2 - 4.U
   }
   when(io.input1) {
     w := w + 9.U
     reg0 := reg0 - 10.U
     reg1 := 8.U
     reg2 := reg2 - 2.U
   }
   when(io.input2) {
     w := w + 3.U
     reg0 := reg0 - 10.U
     reg1 := reg1 + 8.U
     reg2 := reg2 - 3.U
   }
   when(io.input3) {
     w := w + 5.U
     reg0 := reg0 + 6.U
     reg1 := reg1 + 9.U
     reg2 := reg2 - 9.U
   }
   when(io.input4) {
     w := w + 10.U
     reg0 := 6.U
     reg1 := reg1 + 8.U
     reg2 := reg2 - 3.U
   }
   when(io.extra_input0) {
     extra_reg0 := extra_reg0 - 1.U
     extra_reg1 := extra_reg1 - 8.U
     extra_reg2 := extra_reg2 + 3.U
   }
   when(io.extra_input1) {
     extra_reg0 := extra_reg0 - 8.U
     extra_reg1 := extra_reg1 + 6.U
     extra_reg2 := extra_reg2 - 2.U
   }
  io.output0 := reg0
  io.output1 := reg1
  io.output2 := reg2
  io.extra_output0 := extra_reg0
  io.extra_output1 := extra_reg1
  io.extra_output2 := extra_reg2
  count := count - 1.U
  when (count === 0.U) {
    assert(w === reg1)
  }
}