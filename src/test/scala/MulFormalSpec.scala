package example.rocketchip

import chisel3._
import chiseltest._
import chiseltest.formal._
import org.scalatest.flatspec.AnyFlatSpec

class MulFormalSpec extends AnyFlatSpec with Formal with ChiselScalatestTester {
    behavior of "Multiplier"
    it should "pass" in {
        verify(new Mul(8), Seq(BoundedCheck(20), Z3EngineAnnotation))
    }
}

object emitMulFIRRTL extends App {
    (new chisel3.stage.ChiselStage()).emitFirrtl(
        new Mul(8),
        Array("--target-dir", "generated")
    )
}