package newtemplate

import chisel3._
import chisel3.util._

class Template30n extends Module 
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

  val w = RegInit(1.U(8.W))
  val count = RegInit(200.U(32.W))
  val reg0 = RegInit(4.U(8.W))
  val reg1 = RegInit(10.U(8.W))
  val reg2 = RegInit(10.U(8.W))
   when(io.input0) {
     w := w + 5.U
     reg0 := reg0 - 4.U
     reg1 := 3.U
     reg2 := 9.U
   }
   when(io.input1) {
     w := w + 6.U
     reg0 := reg0 + 2.U
     reg1 := reg1 - 1.U
     reg2 := reg2 - 3.U
   }
   when(io.input2) {
     w := w - 5.U
     reg0 := reg0 + 3.U
     reg1 := 8.U
     reg2 := 6.U
   }
   when(io.input3) {
     w := w - 7.U
     reg0 := reg0 + 7.U
     reg1 := reg1 + 3.U
     reg2 := reg2 - 9.U
   }
   when(io.input4) {
     w := w - 6.U
     reg0 := reg0 + 4.U
     reg1 := reg1 + 4.U
     reg2 := 3.U
   }
  io.output0 := reg0
  io.output1 := reg1
  io.output2 := reg2
  count := count - 1.U
  when (count === 0.U) {
    assert(w === reg0)
  }
}