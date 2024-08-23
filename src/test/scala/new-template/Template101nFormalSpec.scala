package newtemplate

import chisel3._
import chiseltest._
import chiseltest.formal._
import org.scalatest.flatspec.AnyFlatSpec

class Template101nFormalSpec extends AnyFlatSpec with Formal with ChiselScalatestTester {
  behavior of "Template101n"
it should "pass" in {
    verify(new Template101n(), Seq(BoundedCheck(200), Z3EngineAnnotation))
  }
}