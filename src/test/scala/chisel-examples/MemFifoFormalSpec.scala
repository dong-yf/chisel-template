package chiselexamples

import chisel3._
import chiseltest._
import chiseltest.formal._
import org.scalatest.flatspec.AnyFlatSpec

class MemFifoFormalSpec extends AnyFlatSpec with Formal with ChiselScalatestTester {
  behavior of "MemFifo"
  it should "pass" in {
    verify(new MemFifo(UInt(8.W),16), Seq(BoundedCheck(100), Z3EngineAnnotation))
  }
}
