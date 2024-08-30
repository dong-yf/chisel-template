package nutcore

import chisel3._
import chiseltest._
import chiseltest.formal._
import org.scalatest.flatspec.AnyFlatSpec

class CacheStage2FormalSpec extends AnyFlatSpec with Formal with ChiselScalatestTester {
  behavior of "CacheStage1"
  it should "pass" in {
    implicit val cacheConfig: CacheConfig = new CacheConfig()
    verify(new CacheStage2(), Seq(BoundedCheck(50), Z3EngineAnnotation))
  }
}