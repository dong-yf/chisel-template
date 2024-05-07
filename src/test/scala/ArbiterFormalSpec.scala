package examples

import chisel3._
import chiseltest._
import chiseltest.formal._
import org.scalatest.flatspec.AnyFlatSpec

class ArbiterFormalSpec extends AnyFlatSpec with Formal with ChiselScalatestTester {
  behavior of "Arbiter"
  it should "pass" in {
    verify(new Arbiter(7, UInt(2.W)), Seq(BoundedCheck(40), Z3EngineAnnotation))
  }
}