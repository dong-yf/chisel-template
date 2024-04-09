package chiselbook

import chisel3._
import chiseltest._
import chiseltest.formal._
import org.scalatest.flatspec.AnyFlatSpec

class BubbleFifoFormalSpec extends AnyFlatSpec with Formal with ChiselScalatestTester {
  behavior of "BubbleFifo"
  it should "pass" in {
    verify(new BubbleFifo(16, 100), Seq(BoundedCheck(120), Z3EngineAnnotation))
  }
}
