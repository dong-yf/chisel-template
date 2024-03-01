package testCHA.GCD

import org.scalatest.flatspec._
import org.scalatest.matchers.should._
import chiseltest._
import chiseltest.formal._
import chisel3._

class DecoupledGcdProp1(bitWidth: Int) extends DecoupledGcd(bitWidth){

  val a = !busy
  // equivalent to chaAssert(this,"busy |-> ##[1:15] nBusy")
  assert(past(a,15) | past(a,14) | past(a,13) | past(a,12) | past(a,11) | past(a,10) | past(a,9)
   | past(a,8) | past(a,7) | past(a,6) | past(a,5) | past(a,4) | past(a,3) | past(a,2) | past(a,1) | a)
}

class DecoupledGcdSpec extends AnyFlatSpec with ChiselScalatestTester with Formal {
  // println(new (chisel3.stage.ChiselStage).emitSystemVerilog(new DecoupledGcdProp1(4)))
  behavior of "DecoupledGcd"
  it should "pass" in {
    verify(new DecoupledGcdProp1(8), Seq(BoundedCheck(20), Z3EngineAnnotation))
  }
}