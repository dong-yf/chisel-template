package newtemplate

import chisel3._
import chiseltest._
import chiseltest.formal._
import org.scalatest.flatspec.AnyFlatSpec

class Template10nFormalSpec extends AnyFlatSpec with Formal with ChiselScalatestTester {
  behavior of "Template10n"
it should "pass" in {
    verify(new Template10n(), Seq(BoundedCheck(200), Z3EngineAnnotation))
  }
}