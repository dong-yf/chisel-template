package newtemplate

import chisel3._
import chiseltest._
import chiseltest.formal._
import org.scalatest.flatspec.AnyFlatSpec

class Template99nFormalSpec extends AnyFlatSpec with Formal with ChiselScalatestTester {
  behavior of "Template99n"
it should "pass" in {
    verify(new Template99n(), Seq(BoundedCheck(200), Z3EngineAnnotation))
  }
}