package newtemplate

import chisel3._
import chiseltest._
import chiseltest.formal._
import org.scalatest.flatspec.AnyFlatSpec

class Template56nFormalSpec extends AnyFlatSpec with Formal with ChiselScalatestTester {
  behavior of "Template56n"
it should "pass" in {
    verify(new Template56n(), Seq(BoundedCheck(200), Z3EngineAnnotation))
  }
}