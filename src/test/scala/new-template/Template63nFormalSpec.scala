package newtemplate

import chisel3._
import chiseltest._
import chiseltest.formal._
import org.scalatest.flatspec.AnyFlatSpec

class Template63nFormalSpec extends AnyFlatSpec with Formal with ChiselScalatestTester {
  behavior of "Template63n"
it should "pass" in {
    verify(new Template63n(), Seq(BoundedCheck(200), Z3EngineAnnotation))
  }
}