package software

import chisel3._
import chiseltest._
import chiseltest.formal._
import org.scalatest.flatspec.AnyFlatSpec

class Trex02FormalSpec extends AnyFlatSpec with Formal with ChiselScalatestTester {
  behavior of "Trex02"
  it should "pass" in {
    verify(new Trex02(), Seq(BoundedCheck(100), Z3EngineAnnotation))
  }
}