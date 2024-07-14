package chiselbook

import chisel3._
import chiseltest._
import chiseltest.formal._
import org.scalatest.flatspec.AnyFlatSpec

class SimpleFsmFormalSpec extends AnyFlatSpec with Formal with ChiselScalatestTester {
  behavior of "SimpleFsm"
  it should "pass" in {
    verify(new SimpleFsm(), Seq(BoundedCheck(100), Z3EngineAnnotation))
  }
}