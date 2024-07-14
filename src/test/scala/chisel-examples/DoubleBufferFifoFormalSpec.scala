package chiselexamples

import chisel3._
import chiseltest._
import chiseltest.formal._
import org.scalatest.flatspec.AnyFlatSpec

class DoubleBufferFifoFormalSpec extends AnyFlatSpec with Formal with ChiselScalatestTester {
  behavior of "DoubleBufferFifo"
  it should "pass" in {
    verify(new DoubleBufferFifo(UInt(8.W), 4), Seq(BoundedCheck(80), Z3EngineAnnotation))
  }
}