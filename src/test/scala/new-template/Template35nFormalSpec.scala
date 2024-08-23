package newtemplate

import chisel3._
import chiseltest._
import chiseltest.formal._
import org.scalatest.flatspec.AnyFlatSpec

class Template35nFormalSpec extends AnyFlatSpec with Formal with ChiselScalatestTester {
  behavior of "Template35n"
it should "pass" in {
    verify(new Template35n(), Seq(BoundedCheck(200), Z3EngineAnnotation))
  }
}