package chiselbook

import chisel3._
import chiseltest._
import chiseltest.formal._
import org.scalatest.flatspec.AnyFlatSpec

class ShiftRegisterFormalSpec extends AnyFlatSpec with Formal with ChiselScalatestTester {
  behavior of "ShiftRegister"
  it should "pass" in {
    verify(new ShiftRegister(), Seq(BoundedCheck(200), Z3EngineAnnotation))
  }
}