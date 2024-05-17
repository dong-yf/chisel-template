package chiselexamples

import chisel3._
import chiseltest._
import chiseltest.formal._
import org.scalatest.flatspec.AnyFlatSpec

class DoubleBufferFifoFormalSpec extends AnyFlatSpec with Formal with ChiselScalatestTester {
  behavior of "DoubleBufferFifo"
  it should "pass" in {
    verify(new DoubleBufferFifo(4), Seq(BoundedCheck(200), Z3EngineAnnotation))
  }
}