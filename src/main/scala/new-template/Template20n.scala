package newtemplate

import chisel3._
import chisel3.util._

class Template20n extends Module 
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

  val w = RegInit(3.U(8.W))
  val count = RegInit(200.U(32.W))
  val reg0 = RegInit(9.U(8.W))
  val reg1 = RegInit(4.U(8.W))
  val reg2 = RegInit(7.U(8.W))
   when(io.input0) {
     w := 6.U
     reg0 := reg0 - 3.U
     reg1 := reg1 - 2.U
     reg2 := reg2 + 2.U
   }
   when(io.input1) {
     w := w - 2.U
     reg0 := 10.U
     reg1 := reg1 + 3.U
     reg2 := reg2 - 10.U
   }
   when(io.input2) {
     w := w + 1.U
     reg0 := reg0 - 5.U
     reg1 := 8.U
     reg2 := reg2 + 8.U
   }
   when(io.input3) {
     w := w - 3.U
     reg0 := 6.U
     reg1 := reg1 + 2.U
     reg2 := 8.U
   }
   when(io.input4) {
     w := w + 3.U
     reg0 := reg0 - 5.U
     reg1 := 3.U
     reg2 := 6.U
   }
  io.output0 := reg0
  io.output1 := reg1
  io.output2 := reg2
  count := count - 1.U
  when (count === 0.U) {
    assert(w === reg2)
  }
}