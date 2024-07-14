package chiselbook

import chisel3._
import chiseltest._
import chiseltest.formal._
import org.scalatest.flatspec.AnyFlatSpec

class RisingMooreFsmFormalSpec extends AnyFlatSpec with Formal with ChiselScalatestTester {
  behavior of "RisingMooreFsm"
  it should "pass" in {
    verify(new RisingMooreFsm(), Seq(BoundedCheck(300), Z3EngineAnnotation))
  }
}