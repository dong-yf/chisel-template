package newtemplate

import chisel3._
import chiseltest._
import chiseltest.formal._
import org.scalatest.flatspec.AnyFlatSpec

class Template121nFormalSpec extends AnyFlatSpec with Formal with ChiselScalatestTester {
  behavior of "Template121n"
it should "pass" in {
    verify(new Template121n(), Seq(BoundedCheck(200), Z3EngineAnnotation))
  }
}