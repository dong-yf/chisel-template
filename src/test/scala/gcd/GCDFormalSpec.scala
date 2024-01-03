package gcd

import chisel3._
import chiseltest._
import chiseltest.formal._
import org.scalatest.flatspec.AnyFlatSpec

class GCDFormalSpec extends AnyFlatSpec with formal with ChiselScalatestTester {
    behaviour of "GCD"
    it should pass in {
        verify(new GCD(), Seq(BoundedCheck(20)), BtormcEngineAnnotation)
    }
}

