package newtemplate

import chisel3._
import chisel3.util._

class Template85n extends Module 
{
  val io = IO(new Bundle {
    val input0 = Input(Bool())
    val input1 = Input(Bool())
    val input2 = Input(Bool())
    val input3 = Input(Bool())
    val input4 = Input(Bool())
    val output0 = Output(UInt(8.W))
    val output1 = Output(UInt(8.W))
    val output2 = Output(UInt(8.W))
    val output3 = Output(UInt(8.W))
    val output4 = Output(UInt(8.W))
  })

  val w = RegInit(10.U(8.W))
  val count = RegInit(200.U(32.W))
  val reg0 = RegInit(1.U(8.W))
  val reg1 = RegInit(10.U(8.W))
  val reg2 = RegInit(9.U(8.W))
  val reg3 = RegInit(4.U(8.W))
  val reg4 = RegInit(7.U(8.W))
   when(io.input0) {
     w := 8.U
     reg0 := reg0 + 7.U
     reg1 := reg1 - 8.U
     reg2 := reg2 - 7.U
     reg3 := reg3 - 4.U
     reg4 := 4.U
   }
   when(io.input1) {
     w := w + 2.U
     reg0 := reg0 - 9.U
     reg1 := reg1 - 7.U
     reg2 := reg2 - 8.U
     reg3 := reg3 - 7.U
     reg4 := 8.U
   }
   when(io.input2) {
     w := w + 6.U
     reg0 := reg0 + 4.U
     reg1 := reg1 + 8.U
     reg2 := reg2 - 7.U
     reg3 := reg3 + 3.U
     reg4 := reg4 - 4.U
   }
   when(io.input3) {
     w := 4.U
     reg0 := reg0 + 2.U
     reg1 := 9.U
     reg2 := 4.U
     reg3 := reg3 + 1.U
     reg4 := 8.U
   }
   when(io.input4) {
     w := w + 6.U
     reg0 := 10.U
     reg1 := 4.U
     reg2 := reg2 - 4.U
     reg3 := reg3 - 8.U
     reg4 := 6.U
   }
  io.output0 := reg0
  io.output1 := reg1
  io.output2 := reg2
  io.output3 := reg3
  io.output4 := reg4
  count := count - 1.U
  when (count === 0.U) {
    assert(w === reg3)
  }
}