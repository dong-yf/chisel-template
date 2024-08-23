package newtemplate

import chisel3._
import chiseltest._
import chiseltest.formal._
import org.scalatest.flatspec.AnyFlatSpec

class Template112nFormalSpec extends AnyFlatSpec with Formal with ChiselScalatestTester {
  behavior of "Template112n"
it should "pass" in {
    verify(new Template112n(), Seq(BoundedCheck(200), Z3EngineAnnotation))
  }
}