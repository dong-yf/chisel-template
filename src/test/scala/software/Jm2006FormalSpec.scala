package software

import chisel3._
import chiseltest._
import chiseltest.formal._
import org.scalatest.flatspec.AnyFlatSpec

class Jm2006FormalSpec extends AnyFlatSpec with Formal with ChiselScalatestTester {
  behavior of "Jm2006"
  it should "pass" in {
    verify(new Jm2006(), Seq(BoundedCheck(200), Z3EngineAnnotation))
  }
}