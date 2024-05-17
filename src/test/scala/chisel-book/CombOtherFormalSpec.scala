package chiselbook

import chisel3._
import chiseltest._
import chiseltest.formal._
import org.scalatest.flatspec.AnyFlatSpec

class CombOtherFormalSpec extends AnyFlatSpec with Formal with ChiselScalatestTester {
  behavior of "CombOther"
  it should "pass" in {
    verify(new CombOther(), Seq(BoundedCheck(200), Z3EngineAnnotation))
  }
}