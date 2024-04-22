package software

import chisel3._
import chiseltest._
import chiseltest.formal._
import org.scalatest.flatspec.AnyFlatSpec

class DiamondFormalSpec extends AnyFlatSpec with Formal with ChiselScalatestTester {
  behavior of "Diamond"
  it should "pass" in {
    verify(new Diamond(), Seq(BoundedCheck(100), Z3EngineAnnotation))
  }
}