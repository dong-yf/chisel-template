package chiselbook

import chisel3._
import chiseltest._
import chiseltest.formal._
import org.scalatest.flatspec.AnyFlatSpec

class CombElseWhenFormalSpec extends AnyFlatSpec with Formal with ChiselScalatestTester {
  behavior of "CombElseWhen"
  it should "pass" in {
    verify(new CombElseWhen(), Seq(BoundedCheck(210), Z3EngineAnnotation))
  }
}