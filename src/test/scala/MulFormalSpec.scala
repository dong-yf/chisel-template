package example.rocketchip

import chisel3._
import chiseltest._
import chiseltest.formal._
import org.scalatest.flatspec.AnyFlatSpec

class MulFormalSpec extends AnyFlatSpec with Formal with ChiselScalatestTester {
    behavior of "Multiplier"
    it should "pass" in {
        verify(new Mul(32), Seq(BoundedCheck(40), Z3EngineAnnotation))
    }
}