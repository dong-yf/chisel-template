package software

import chisel3._
import chisel3.util._

// unsigned hanoi(int n) {
//     if (n == 1) {
// 		return 1;
// 	}
// 	return 2 * (hanoi(n-1)) + 1;
// }


// int main() {
//     int n = __VERIFIER_nondet_int();
//     if (n < 1) {
//     	return 0;
//     }
//     unsigned result = hanoi(n);
//     // result and the counter should be the same!
//     if (result+1>0 && result+1 == 1<<n) {
//         return 0;
//     } else {
//         ERROR: __VERIFIER_error();
//     }
// }

class recHanoi03 extends Module {
    val io = IO(new Bundle {
        val n = Input(UInt(16.W))
    })
    val regN = RegInit(io.n)
    val N = RegInit(io.n)
    val result = RegInit(1.U(32.W))
    val count = RegInit(10.U(32.W))

    
    when (regN < 1.U) {
        result := 0.U
    }.otherwise {
        when(io.n > 1.U) {
            result := 2.U * result + 1.U
            regN := regN - 1.U
        }
        count := count - 1.U
    }

    when (count === 0.U) {
        when (io.n === 10.U) {
            assert(result + 1.U > 0.U && result + 1.U === (1.U << N))
        }
    }
    // assert(result + 1.U > 0.U && result + 1.U === (1.U << N))
    
}