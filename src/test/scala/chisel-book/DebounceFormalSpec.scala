package chiselbook

import chisel3._
import chiseltest._
import chiseltest.formal._
import org.scalatest.flatspec.AnyFlatSpec

class DebounceFormalSpec extends AnyFlatSpec with Formal with ChiselScalatestTester {
  behavior of "Debounce"
  it should "pass" in {
    verify(new Debounce(), Seq(BoundedCheck(110), Z3EngineAnnotation))
  }
}