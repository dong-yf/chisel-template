package example.rocketchip

import chisel3._
import chiseltest._
import chiseltest.formal._
import org.scalatest.flatspec.AnyFlatSpec

class DivFormalSpec extends AnyFlatSpec with Formal with ChiselScalatestTester {
    behavior of "Divider"
    it should "pass" in {
        verify(new Div(16), Seq(BoundedCheck(20), Z3EngineAnnotation))
    }
}