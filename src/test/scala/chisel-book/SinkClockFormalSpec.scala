package chiselbook

import chisel3._
import chiseltest._
import chiseltest.formal._
import org.scalatest.flatspec.AnyFlatSpec

class SinkClockFormalSpec extends AnyFlatSpec with Formal with ChiselScalatestTester {
  behavior of "SinkClock"
  it should "pass" in {
    verify(new SinkClock(), Seq(BoundedCheck(100), Z3EngineAnnotation))
  }
}