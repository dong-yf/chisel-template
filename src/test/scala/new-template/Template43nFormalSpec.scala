package newtemplate

import chisel3._
import chiseltest._
import chiseltest.formal._
import org.scalatest.flatspec.AnyFlatSpec

class Template43nFormalSpec extends AnyFlatSpec with Formal with ChiselScalatestTester {
  behavior of "Template43n"
it should "pass" in {
    verify(new Template43n(), Seq(BoundedCheck(200), Z3EngineAnnotation))
  }
}