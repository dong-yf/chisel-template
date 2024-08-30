package nutcore

import chisel3._
import chiseltest._
import chiseltest.formal._
import org.scalatest.flatspec.AnyFlatSpec

class CacheFormalSpec extends AnyFlatSpec with Formal with ChiselScalatestTester {
  behavior of "CacheStage3"
  it should "pass" in {
    implicit val cacheConfig: CacheConfig = new CacheConfig()
    verify(new Cache(), Seq(BoundedCheck(20), Z3EngineAnnotation))
  }
}