package chiselexamples

import chisel3._
import chiseltest._
import chiseltest.formal._
import org.scalatest.flatspec.AnyFlatSpec

class KnightRiderFormalSpec extends AnyFlatSpec with Formal with ChiselScalatestTester {
  behavior of "KnightRider"
  it should "pass" in {
    verify(new KnightRider(false.B, 12), Seq(BoundedCheck(50), Z3EngineAnnotation))
  }
}