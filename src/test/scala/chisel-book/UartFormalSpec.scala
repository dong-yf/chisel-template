package chiselbook

import chisel3._
import chiseltest._
import chiseltest.formal._
import org.scalatest.flatspec.AnyFlatSpec

class TxFormalSpec extends AnyFlatSpec with Formal with ChiselScalatestTester {
  behavior of "Uart"
  it should "pass" in {
    verify(new Tx(200, 2), Seq(BoundedCheck(210), Z3EngineAnnotation))
  }
}

class RxFormalSpec extends AnyFlatSpec with Formal with ChiselScalatestTester {
  behavior of "Uart"
  it should "pass" in {
    verify(new Rx(200, 2), Seq(BoundedCheck(210), Z3EngineAnnotation))
  }
}

class BufferFormalSpec extends AnyFlatSpec with Formal with ChiselScalatestTester {
  behavior of "Uart"
  it should "pass" in {
    verify(new Buffer(), Seq(BoundedCheck(200), Z3EngineAnnotation))
  }
}