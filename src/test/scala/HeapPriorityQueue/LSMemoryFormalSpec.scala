package examples.heappriorityqueue.modules

import chisel3._
import chiseltest._
import chiseltest.formal._
import org.scalatest.flatspec.AnyFlatSpec
import examples.heappriorityqueue._
import chisel3.util.log2Ceil

class MemoryFormalSpec extends AnyFlatSpec with Formal with ChiselScalatestTester {
  behavior of "LinearSearchMem"
  it should "pass" in {
    val size = 11
    val order = 2
    implicit val parameters = PriorityQueueParameters(size, order, 4, 8, log2Ceil(size))
    verify(new linearSearchMem(8), Seq(BoundedCheck(30), Z3EngineAnnotation))
  }
}
