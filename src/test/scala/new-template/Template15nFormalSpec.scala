package newtemplate

import chisel3._
import chiseltest._
import chiseltest.formal._
import org.scalatest.flatspec.AnyFlatSpec

class Template15nFormalSpec extends AnyFlatSpec with Formal with ChiselScalatestTester {
  behavior of "Template15n"
it should "pass" in {
    verify(new Template15n(), Seq(BoundedCheck(200), Z3EngineAnnotation))
  }
}