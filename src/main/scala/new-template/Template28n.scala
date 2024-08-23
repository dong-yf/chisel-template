package newtemplate

import chisel3._
import chisel3.util._

class Template28n extends Module 
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
  })

  val w = RegInit(9.U(8.W))
  val count = RegInit(200.U(32.W))
  val reg0 = RegInit(2.U(8.W))
  val reg1 = RegInit(5.U(8.W))
  val reg2 = RegInit(8.U(8.W))
   when(io.input0) {
     w := w - 2.U
     reg0 := reg0 + 5.U
     reg1 := reg1 - 3.U
     reg2 := 2.U
   }
   when(io.input1) {
     w := 9.U
     reg0 := 6.U
     reg1 := reg1 - 7.U
     reg2 := reg2 - 1.U
   }
   when(io.input2) {
     w := w - 2.U
     reg0 := reg0 - 7.U
     reg1 := reg1 + 6.U
     reg2 := 7.U
   }
   when(io.input3) {
     w := w + 2.U
     reg0 := 5.U
     reg1 := reg1 + 9.U
     reg2 := reg2 + 4.U
   }
   when(io.input4) {
     w := w + 2.U
     reg0 := reg0 - 4.U
     reg1 := reg1 + 9.U
     reg2 := reg2 - 1.U
   }
  io.output0 := reg0
  io.output1 := reg1
  io.output2 := reg2
  count := count - 1.U
  when (count === 0.U) {
    assert(w === reg2)
  }
}