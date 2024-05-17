package bus.simplebus

import chisel3._
import chiseltest._
import chiseltest.formal._
import org.scalatest.flatspec.AnyFlatSpec

class SimpleBusCrossBar1toNFormalSpec extends AnyFlatSpec with Formal with ChiselScalatestTester {
  behavior of "SimpleBusCrossBar"
  it should "pass" in {
    val devAddrSpace = List(
        (0x40600000L, 0x10L), // uart
        (0x50000000L, 0x400000L), // vmem
        (0x40001000L, 0x8L),  // vga ctrl
        (0x40000000L, 0x1000L),  // flash
        (0x40002000L, 0x1000L), // dummy sdcard
        (0x40004000L, 0x1000L), // meipGen
        (0x40003000L, 0x1000L)  // dma
    )
    verify(new SimpleBusCrossbar1toN(devAddrSpace), Seq(BoundedCheck(100), Z3EngineAnnotation))
  }
}

class SimpleBusCrossbarNto1FormalSpec extends AnyFlatSpec with Formal with ChiselScalatestTester {
  behavior of "SimpleBusCrossBar"
  it should "pass" in {
    verify(new SimpleBusCrossbarNto1(2), Seq(BoundedCheck(40), Z3EngineAnnotation))
  }
}
