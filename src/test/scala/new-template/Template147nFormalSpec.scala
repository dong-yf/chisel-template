package newtemplate

import chisel3._
import chiseltest._
import chiseltest.formal._
import org.scalatest.flatspec.AnyFlatSpec

class Template147nFormalSpec extends AnyFlatSpec with Formal with ChiselScalatestTester {
  behavior of "Template147n"
it should "pass" in {
    verify(new Template147n(), Seq(BoundedCheck(200), Z3EngineAnnotation))
  }
}