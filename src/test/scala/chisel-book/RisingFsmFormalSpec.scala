package chiselbook

import chisel3._
import chiseltest._
import chiseltest.formal._
import org.scalatest.flatspec.AnyFlatSpec

class RisingFsmFormalSpec extends AnyFlatSpec with Formal with ChiselScalatestTester {
  behavior of "RisingFsm"
  it should "pass" in {
    verify(new RisingFsm(), Seq(BoundedCheck(300), Z3EngineAnnotation))
  }
}