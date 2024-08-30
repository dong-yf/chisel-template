package ns.bus

import chisel3._
import chiseltest._
import chiseltest.formal._
import org.scalatest.flatspec.AnyFlatSpec

class AXI4FormalSpec extends AnyFlatSpec with Formal with ChiselScalatestTester {
  behavior of "AXI4"
  it should "pass" in {
    verify(new AXI42SimpleBusConverter(), Seq(BoundedCheck(120), Z3EngineAnnotation))
  }
}
