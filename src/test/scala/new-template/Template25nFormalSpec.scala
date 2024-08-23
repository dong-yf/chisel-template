package newtemplate

import chisel3._
import chiseltest._
import chiseltest.formal._
import org.scalatest.flatspec.AnyFlatSpec

class Template25nFormalSpec extends AnyFlatSpec with Formal with ChiselScalatestTester {
  behavior of "Template25n"
it should "pass" in {
    verify(new Template25n(), Seq(BoundedCheck(200), Z3EngineAnnotation))
  }
}