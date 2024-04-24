package software

import chisel3._
import chisel3.util._

// int main(void) {
//   unsigned int x = 0;
//   unsigned int y = __VERIFIER_nondet_uint();
//   while (x < 99) {
//     if (y % 2 == 0) {
//       x++;
//     } else {
//       x += 2;
//     }
//   }
//   __VERIFIER_assert((x % 2) == (y % 2));
// }

class Diamond extends Module {
    val io = IO(new Bundle {
        val y = Input(UInt(32.W))
    })
    val x = RegInit(0.U(32.W))
    val count = RegInit(100.U(32.W))

    when (x < 99.U) {
        when (io.y % 2.U === 0.U) {
            x := x + 1.U
        }.otherwise {
            x := x + 2.U
        }
        count := count - 1.U
    }

    when(count === 0.U) {
        assert((x % 2.U) === (io.y % 2.U))
    }
    
}