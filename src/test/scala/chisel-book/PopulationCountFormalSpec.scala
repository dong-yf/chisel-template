package chiselbook

import chisel3._
import chiseltest._
import chiseltest.formal._
import org.scalatest.flatspec.AnyFlatSpec

class PopulationCountFormalSpec extends AnyFlatSpec with Formal with ChiselScalatestTester {
  behavior of "PopulationCount"
  it should "pass" in {
    verify(new PopulationCount(), Seq(BoundedCheck(40), Z3EngineAnnotation))
  }
}