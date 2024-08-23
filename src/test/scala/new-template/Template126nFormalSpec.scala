package newtemplate

import chisel3._
import chiseltest._
import chiseltest.formal._
import org.scalatest.flatspec.AnyFlatSpec

class Template126nFormalSpec extends AnyFlatSpec with Formal with ChiselScalatestTester {
  behavior of "Template126n"
it should "pass" in {
    verify(new Template126n(), Seq(BoundedCheck(200), Z3EngineAnnotation))
  }
}