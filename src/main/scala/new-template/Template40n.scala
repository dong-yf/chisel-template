package newtemplate

import chisel3._
import chisel3.util._

class Template40n extends Module 
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

  val w = RegInit(10.U(8.W))
  val count = RegInit(200.U(32.W))
  val reg0 = RegInit(3.U(8.W))
  val reg1 = RegInit(5.U(8.W))
  val reg2 = RegInit(9.U(8.W))
   when(io.input0) {
     w := 10.U
     reg0 := 9.U
     reg1 := reg1 - 3.U
     reg2 := reg2 - 10.U
   }
   when(io.input1) {
     w := w - 6.U
     reg0 := 4.U
     reg1 := reg1 + 1.U
     reg2 := 2.U
   }
   when(io.input2) {
     w := 5.U
     reg0 := 8.U
     reg1 := reg1 - 6.U
     reg2 := reg2 - 3.U
   }
   when(io.input3) {
     w := w - 8.U
     reg0 := 9.U
     reg1 := reg1 - 3.U
     reg2 := reg2 + 5.U
   }
   when(io.input4) {
     w := w + 7.U
     reg0 := reg0 - 1.U
     reg1 := reg1 + 6.U
     reg2 := reg2 + 7.U
   }
  io.output0 := reg0
  io.output1 := reg1
  io.output2 := reg2
  count := count - 1.U
  when (count === 0.U) {
    assert(w === reg1)
  }
}