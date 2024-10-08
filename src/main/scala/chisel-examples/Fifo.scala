package chiselexamples

import chisel3._
import chisel3.util._

/**
  * FIFO IO with enqueue and dequeue ports using the ready/valid interface.
  */
class FifoIO[T <: Data](private val gen: T) extends Bundle {
  val enq = Flipped(new DecoupledIO(gen))
  val deq = new DecoupledIO(gen)
}

/**
  * Base class for all FIFOs.
  */
abstract class Fifo[T <: Data](gen: T, depth: Int) extends Module {
  val io = IO(new FifoIO(gen))

  assert(depth > 0, "Number of buffer elements needs to be larger than 0")
}
