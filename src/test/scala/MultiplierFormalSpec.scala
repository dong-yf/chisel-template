package example.xiangshan

import chisel3._
import chiseltest._
import chiseltest.formal._
import org.scalatest.flatspec.AnyFlatSpec

class MultiplierFormalSpec extends AnyFlatSpec with Formal with ChiselScalatestTester {
  behavior of "Multiplier"
  it should "pass" in {
    verify(new ArrayMulDataModule(5), Seq(BoundedCheck(12), Z3EngineAnnotation))
  }
}
