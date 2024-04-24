package chiselbook

import chisel3._
import chiseltest._
import chiseltest.formal._
import org.scalatest.flatspec.AnyFlatSpec

class ReadyValidBufferFormalSpec extends AnyFlatSpec with Formal with ChiselScalatestTester {
  behavior of "ReadyValidBuffer"
  it should "pass" in {
    verify(new ReadyValidBuffer(), Seq(BoundedCheck(210), Z3EngineAnnotation))
  }
}