package software

import chisel3._
import chisel3.util._

// int main()
// {
//   unsigned int n = __VERIFIER_nondet_uint();
//   unsigned int x=n, y=0;
//   while(x>0)
//   {
//     x--;
//     y++;
//   }
//   __VERIFIER_assert(y!=n);
// }

class CountUpDown extends Module {
    val io = IO(new Bundle {
        val n = Input(UInt(32.W))
    })
    val x = RegInit(io.n)
    val y = RegInit(0.U(32.W))
    val count = RegInit(200.U(32.W))

    when (x > 0.U) {
        x := x - 1.U
        y := y + 1.U
        count := count - 1.U
    }

    when(count === 0.U) {
        assert(y =/= io.n)
    }
    
}
