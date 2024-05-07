package examples.heappriorityqueue.modules

import chisel3._
import chiseltest._
import chiseltest.formal._
import org.scalatest.flatspec.AnyFlatSpec
import examples.heappriorityqueue._
import chisel3.util.log2Ceil

class HeapifierFormalSpec extends AnyFlatSpec with Formal with ChiselScalatestTester {
  behavior of "Heapifier"
  it should "pass" in {
    val size = 33
    val order = 2
    implicit val parameters = PriorityQueueParameters(size, order, 4, 8, log2Ceil(size))
    verify(new Heapifier(), Seq(BoundedCheck(20), Z3EngineAnnotation))
  }
}

// generate firrtl
object emitFirrtl extends App {
  val size = 33
  val order = 2
  implicit val parameters = PriorityQueueParameters(size, order, 4, 8, log2Ceil(size))
  (new chisel3.stage.ChiselStage()).emitFirrtl(
    new Heapifier(),
    Array("--target-dir", "generated")
  )
}
