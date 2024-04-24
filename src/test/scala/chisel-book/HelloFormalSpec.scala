package chiselbook

import chisel3._
import chiseltest._
import chiseltest.formal._
import org.scalatest.flatspec.AnyFlatSpec

class HelloFormalSpec extends AnyFlatSpec with Formal with ChiselScalatestTester {
  behavior of "Hello"
  it should "pass" in {
    verify(new Hello(), Seq(BoundedCheck(200), Z3EngineAnnotation))
  }
}