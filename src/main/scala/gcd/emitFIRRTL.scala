package gcd

object emitFIRRTL extends App {
  (new chisel3.stage.ChiselStage()).emitFirrtl(
    new gcd.GCD(),
    Array("--target-dir", "generated")
  )
}