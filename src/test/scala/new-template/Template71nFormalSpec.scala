package newtemplate

import chisel3._
import chiseltest._
import chiseltest.formal._
import org.scalatest.flatspec.AnyFlatSpec

class Template71nFormalSpec extends AnyFlatSpec with Formal with ChiselScalatestTester {
  behavior of "Template71n"
it should "pass" in {
    verify(new Template71n(), Seq(BoundedCheck(200), Z3EngineAnnotation))
  }
}