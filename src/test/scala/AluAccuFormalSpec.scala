package leros

import chisel3._
import chiseltest._
import chiseltest.formal._
import org.scalatest.flatspec.AnyFlatSpec

class AluAccuFormalSpec extends AnyFlatSpec with Formal with ChiselScalatestTester {
  behavior of "AluAccu"
  it should "pass" in {
    verify(new AluAccu(32), Seq(BoundedCheck(10), Z3EngineAnnotation))
  }
}