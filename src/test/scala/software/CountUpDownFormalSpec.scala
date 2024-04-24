package software

import chisel3._
import chiseltest._
import chiseltest.formal._
import org.scalatest.flatspec.AnyFlatSpec

class CountUpDownFormalSpec extends AnyFlatSpec with Formal with ChiselScalatestTester {
  behavior of "CountUpDown"
  it should "pass" in {
    verify(new CountUpDown(), Seq(BoundedCheck(200), Z3EngineAnnotation))
  }
}