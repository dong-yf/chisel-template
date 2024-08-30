package mini

import chisel3._
import chiseltest._
import chiseltest.formal._
import org.scalatest.flatspec.AnyFlatSpec


class RISCVMiNiFormalSpec extends AnyFlatSpec with Formal with ChiselScalatestTester {
    behavior of "RISCVMiNi"
    it should "pass" in {
        val config = MiniConfig()
        verify(new Tile(
            coreParams = config.core,
            nastiParams = config.nasti,
            cacheParams = config.cache
        ), Seq(BoundedCheck(8), Z3EngineAnnotation))
    }
}