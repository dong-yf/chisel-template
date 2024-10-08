package examples.heappriorityqueue.modules

import chisel3._
import chiseltest._
import chiseltest.formal._
import org.scalatest.flatspec.AnyFlatSpec
import examples.heappriorityqueue._
import chisel3.util.log2Ceil

class QueueControlFormalSpec extends AnyFlatSpec with Formal with ChiselScalatestTester {
  behavior of "QueueControl"
  it should "pass" in {
    val size = 11
    val order = 2
    implicit val parameters = PriorityQueueParameters(size, order, 4, 8, log2Ceil(size))
    verify(new QueueControl(), Seq(BoundedCheck(10), Z3EngineAnnotation))
  }
}