package newtemplate

import chisel3._
import chiseltest._
import chiseltest.formal._
import org.scalatest.flatspec.AnyFlatSpec

class Template157nFormalSpec extends AnyFlatSpec with Formal with ChiselScalatestTester {
  behavior of "Template157n"
it should "pass" in {
    verify(new Template157n(), Seq(BoundedCheck(200), Z3EngineAnnotation))
  }
}