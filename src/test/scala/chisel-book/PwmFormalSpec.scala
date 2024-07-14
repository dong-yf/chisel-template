package chiselbook

import chisel3._
import chiseltest._
import chiseltest.formal._
import org.scalatest.flatspec.AnyFlatSpec

class PwmFormalSpec extends AnyFlatSpec with Formal with ChiselScalatestTester {
  behavior of "Pwm"
  it should "pass" in {
    verify(new Pwm(), Seq(BoundedCheck(200), Z3EngineAnnotation))
  }
}