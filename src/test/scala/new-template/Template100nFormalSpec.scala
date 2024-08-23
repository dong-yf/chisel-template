package newtemplate

import chisel3._
import chiseltest._
import chiseltest.formal._
import org.scalatest.flatspec.AnyFlatSpec

class Template100nFormalSpec extends AnyFlatSpec with Formal with ChiselScalatestTester {
  behavior of "Template100n"
it should "pass" in {
    verify(new Template100n(), Seq(BoundedCheck(200), Z3EngineAnnotation))
  }
}