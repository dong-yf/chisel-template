package newtemplate

import chisel3._
import chiseltest._
import chiseltest.formal._
import org.scalatest.flatspec.AnyFlatSpec

class Template67nFormalSpec extends AnyFlatSpec with Formal with ChiselScalatestTester {
  behavior of "Template67n"
it should "pass" in {
    verify(new Template67n(), Seq(BoundedCheck(200), Z3EngineAnnotation))
  }
}