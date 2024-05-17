package chiselbook

import chisel3._
import chiseltest._
import chiseltest.formal._
import org.scalatest.flatspec.AnyFlatSpec

class ArbiterTreeFormalSpec extends AnyFlatSpec with Formal with ChiselScalatestTester {
  behavior of "ArbiterTree"
  it should "pass" in {
    verify(new ArbiterSimpleTree(8, UInt(16.W)), Seq(BoundedCheck(400), Z3EngineAnnotation))
  }
}