package software

import chisel3._
import chiseltest._
import chiseltest.formal._
import org.scalatest.flatspec.AnyFlatSpec

class NestedFormalSpec extends AnyFlatSpec with Formal with ChiselScalatestTester {
  behavior of "Nested"
  it should "pass" in {
    verify(new Nested(), Seq(BoundedCheck(110), Z3EngineAnnotation))
  }
}