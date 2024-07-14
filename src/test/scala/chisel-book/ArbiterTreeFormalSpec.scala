package chiselbook

import chisel3._
import chiseltest._
import chiseltest.formal._
import org.scalatest.flatspec.AnyFlatSpec

class ArbiterSimpleTreeFormalSpec extends AnyFlatSpec with Formal with ChiselScalatestTester {
  behavior of "ArbiterSimpleTree"
  it should "pass" in {
    verify(new ArbiterSimpleTree(8, UInt(16.W)), Seq(BoundedCheck(400), Z3EngineAnnotation))
  }
}

class ArbiterTreeFormalSpec extends AnyFlatSpec with Formal with ChiselScalatestTester {
  behavior of "ArbiterTree"
  it should "pass" in {
    verify(new ArbiterTree(8, UInt(8.W)), Seq(BoundedCheck(30), Z3EngineAnnotation))
  }
}