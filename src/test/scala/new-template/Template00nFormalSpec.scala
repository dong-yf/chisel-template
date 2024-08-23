package newtemplate

import chisel3._
import chiseltest._
import chiseltest.formal._
import org.scalatest.flatspec.AnyFlatSpec

class Template00nFormalSpec extends AnyFlatSpec with Formal with ChiselScalatestTester {
  behavior of "Template00n"
it should "pass" in {
    verify(new Template00n(), Seq(BoundedCheck(200), Z3EngineAnnotation))
  }
}