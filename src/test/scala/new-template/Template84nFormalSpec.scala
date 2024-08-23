package newtemplate

import chisel3._
import chiseltest._
import chiseltest.formal._
import org.scalatest.flatspec.AnyFlatSpec

class Template84nFormalSpec extends AnyFlatSpec with Formal with ChiselScalatestTester {
  behavior of "Template84n"
it should "pass" in {
    verify(new Template84n(), Seq(BoundedCheck(200), Z3EngineAnnotation))
  }
}