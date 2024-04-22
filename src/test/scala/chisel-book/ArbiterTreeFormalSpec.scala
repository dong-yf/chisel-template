package chiselbook

import chisel3._
import chiseltest._
import chiseltest.formal._
import org.scalatest.flatspec.AnyFlatSpec

class ArbiterTreeFormalSpec extends AnyFlatSpec with Formal with ChiselScalatestTester {
  behavior of "ArbiterTree"
  it should "pass" in {
    verify(new ArbiterSimpleTree(4, UInt(8.W)), Seq(BoundedCheck(200), Z3EngineAnnotation))
  }
}