package chiselbook

import chisel3._
import chiseltest._
import chiseltest.formal._
import org.scalatest.flatspec.AnyFlatSpec

class FlasherFormalSpec extends AnyFlatSpec with Formal with ChiselScalatestTester {
  behavior of "Flasher"
  it should "pass" in {
    verify(new Flasher(), Seq(BoundedCheck(110), Z3EngineAnnotation))
  }
}

class Flasher2FormalSpec extends AnyFlatSpec with Formal with ChiselScalatestTester {
  behavior of "Flasher2"
  it should "pass" in {
    verify(new Flasher2(), Seq(BoundedCheck(90), Z3EngineAnnotation))
  }
}