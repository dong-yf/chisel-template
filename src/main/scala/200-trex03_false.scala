package software

import chisel3._
import chisel3.util._

//  while(x1>0 && x2>0 && x3>0)
//   {
//     if (c1) x1=x1-d1;
//     else if (c2) x2=x2-d2;
//     else x3=x3-d3;
//     c1=__VERIFIER_nondet_bool();
//     c2=__VERIFIER_nondet_bool();
//   }
//   __VERIFIER_assert(x1==0 && x2==0 && x3==0);

class Trex03 extends Module {
    val io = IO(new Bundle {
        val x1 = Input(UInt(32.W))
        val x2 = Input(UInt(32.W))
        val x3 = Input(UInt(32.W))
        val c1 = Input(Bool())
        val c2 = Input(Bool())
    })

    val regX1 = RegInit(io.x1)
    val regX2 = RegInit(io.x2)
    val regX3 = RegInit(io.x3)
    // val count = RegInit(200.U(32.W))

    when (regX1 > 0.U && regX2 > 0.U && regX3 > 0.U) {
        when (io.c1) {
            regX1 := regX1 - 1.U
        } .elsewhen (io.c2) {
            regX2 := regX2 - 1.U
        } .otherwise {
            regX3 := regX3 - 1.U
        }
        // count := count - 1.U
    }

    when (regX1 === 0.U || regX2 === 0.U || regX3 === 0.U) {
        assert(regX1 === 0.U && regX2 === 0.U && regX3 === 0.U)
    }
    
}
