package software

import chisel3._
import chisel3.util._

// int main() {
//     int n = __VERIFIER_nondet_int();
//     int m = __VERIFIER_nondet_int();
//     int k = 0;
//     int i,j;
//     if (!(10 <= n && n <= 10000)) return 0;
//     if (!(10 <= m && m <= 10000)) return 0;
//     for (i = 0; i < n; i++) {
//  for (j = 0; j < m; j++) {
//      k ++;
//  }
//     }
//     __VERIFIER_assert(k >= 100);
//     return 0;
// }

class Nested extends Module {
    val io = IO(new Bundle {
        val n = Input(UInt(32.W))
        val m = Input(UInt(32.W))
    })
    assume(io.n >= 10.U && io.n <= 10000.U)
    assume(io.m >= 10.U && io.m <= 10000.U)
    val k = RegInit(0.U(32.W))
    val i = RegInit(0.U(32.W))
    val j = RegInit(0.U(32.W))
    val count = RegInit(110.U(32.W))

    when (i < io.n) {
        when (j < io.m) {
            k := k + 1.U
            j := j + 1.U
        }.otherwise {
            i := i + 1.U
            j := 0.U
        }
        count := count - 1.U
    }

    when(count === 0.U) {
        assert(k >= 100.U)
    }
    
}
