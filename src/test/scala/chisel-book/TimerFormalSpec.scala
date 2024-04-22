package chiselbook

import chisel3._
import chiseltest._
import chiseltest.formal._
import org.scalatest.flatspec.AnyFlatSpec

class TimerFormalSpec extends AnyFlatSpec with Formal with ChiselScalatestTester {
  behavior of "Timer"
  it should "pass" in {
    verify(new Timer(), Seq(BoundedCheck(200), Z3EngineAnnotation))
  }
}