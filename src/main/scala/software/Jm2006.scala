package software

import chisel3._
import chisel3.util._

// int main() {
//     int i, j;
//     i = __VERIFIER_nondet_int();
//     j = __VERIFIER_nondet_int();
//     if (!(i >= 0 && j >= 0)) return 0;
//     int x = i;
//     int y = j;
//     while(x != 0) {
//         x--;
//         y--;
//     }
//     if (i == j) {
//         __VERIFIER_assert(y == 0);
//     }
//     return 0;
// }

class Jm2006 extends Module {
    val io = IO(new Bundle {
        val i = Input(UInt(32.W))
        val j = Input(UInt(32.W))
    })
    val x = RegInit(io.i)
    val y = RegInit(io.j)
    val count = RegInit(200.U(32.W))

    when (x =/= 0.U) {
        x := x - 1.U
        y := y - 1.U
        count := count - 1.U
    }

    when(count === 0.U) {
        when (io.i === io.j) {
            assert(y === 1.U)
        }
    }
    
}