package newtemplate

import chisel3._
import chiseltest._
import chiseltest.formal._
import org.scalatest.flatspec.AnyFlatSpec

class Template37nFormalSpec extends AnyFlatSpec with Formal with ChiselScalatestTester {
  behavior of "Template37n"
it should "pass" in {
    verify(new Template37n(), Seq(BoundedCheck(200), Z3EngineAnnotation))
  }
}