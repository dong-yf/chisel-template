package newtemplate

import chisel3._
import chiseltest._
import chiseltest.formal._
import org.scalatest.flatspec.AnyFlatSpec

class Template22nFormalSpec extends AnyFlatSpec with Formal with ChiselScalatestTester {
  behavior of "Template22n"
it should "pass" in {
    verify(new Template22n(), Seq(BoundedCheck(200), Z3EngineAnnotation))
  }
}