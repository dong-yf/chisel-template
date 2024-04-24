package software

import chisel3._
import chiseltest._
import chiseltest.formal._
import org.scalatest.flatspec.AnyFlatSpec

class recHanoi03FormalSpec extends AnyFlatSpec with Formal with ChiselScalatestTester {
  behavior of "recHanoi03"
  it should "pass" in {
    verify(new recHanoi03(), Seq(BoundedCheck(11), Z3EngineAnnotation))
  }
}