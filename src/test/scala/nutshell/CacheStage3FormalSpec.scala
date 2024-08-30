package nutcore

import chisel3._
import chiseltest._
import chiseltest.formal._
import org.scalatest.flatspec.AnyFlatSpec

class CacheStage3FormalSpec extends AnyFlatSpec with Formal with ChiselScalatestTester {
  behavior of "CacheStage3"
  it should "pass" in {
    implicit val cacheConfig: CacheConfig = new CacheConfig()
    verify(new CacheStage3(), Seq(BoundedCheck(100), Z3EngineAnnotation))
  }
}