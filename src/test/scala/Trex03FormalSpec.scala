package software

import chisel3._
import chiseltest._
import chiseltest.formal._
import org.scalatest.flatspec.AnyFlatSpec

class Trex03FormalSpec extends AnyFlatSpec with Formal with ChiselScalatestTester {
  behavior of "Trex03"
  it should "pass" in {
    verify(new Trex03(), Seq(BoundedCheck(200), Z3EngineAnnotation))
  }
}
