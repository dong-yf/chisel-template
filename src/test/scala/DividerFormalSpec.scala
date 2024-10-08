package example.xiangshan

import chisel3._
import chiseltest._
import chiseltest.formal._
import org.scalatest.flatspec.AnyFlatSpec

class DividerFormalSpec extends AnyFlatSpec with Formal with ChiselScalatestTester {
    behavior of "Divider"
    it should "pass" in {
        verify(new Divider(), Seq(BoundedCheck(12), Z3EngineAnnotation))
    }
}
