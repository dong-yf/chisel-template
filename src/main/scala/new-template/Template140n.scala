package newtemplate

import chisel3._
import chisel3.util._

class Template140n extends Module 
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

  val w = RegInit(2.U(8.W))
  val count = RegInit(200.U(32.W))
  val reg0 = RegInit(8.U(8.W))
  val reg1 = RegInit(4.U(8.W))
  val reg2 = RegInit(7.U(8.W))
  val extra_reg0 = RegInit(5.U(8.W))
  val extra_reg1 = RegInit(3.U(8.W))
  val extra_reg2 = RegInit(3.U(8.W))
   when(io.input0) {
     w := 7.U
     reg0 := reg0 - 7.U
     reg1 := 1.U
     reg2 := reg2 + 5.U
   }
   when(io.input1) {
     w := w - 4.U
     reg0 := reg0 + 1.U
     reg1 := reg1 - 3.U
     reg2 := 4.U
   }
   when(io.input2) {
     w := w + 10.U
     reg0 := reg0 - 9.U
     reg1 := reg1 - 6.U
     reg2 := reg2 + 6.U
   }
   when(io.input3) {
     w := 4.U
     reg0 := reg0 - 2.U
     reg1 := reg1 + 9.U
     reg2 := 10.U
   }
   when(io.input4) {
     w := w + 10.U
     reg0 := 9.U
     reg1 := reg1 - 3.U
     reg2 := reg2 - 9.U
   }
     extra_reg0 := extra_reg0 - 9.U
     extra_reg1 := extra_reg1 - 7.U
     extra_reg2 := extra_reg2 + 10.U
  io.output0 := reg0
  io.output1 := reg1
  io.output2 := reg2
  io.extra_output0 := extra_reg0
  io.extra_output1 := extra_reg1
  io.extra_output2 := extra_reg2
  count := count - 1.U
  when (count === 0.U) {
    assert(w === reg2)
  }
}