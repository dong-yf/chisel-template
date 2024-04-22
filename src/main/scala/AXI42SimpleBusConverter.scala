package bus

import bus.axi4._
import bus.simplebus._

import chisel3._
import chisel3.util._

class AXI42SimpleBusConverter() extends Module {
  val idBits = 18
  val io = IO(new Bundle {
    val in = Flipped(new AXI4(idBits = idBits))
    val out = new SimpleBusUC()
  })

  val (axi, mem) = (io.in, io.out)
  val (ar, aw, w, r, b) = (axi.ar.bits, axi.aw.bits, axi.w.bits, axi.r.bits, axi.b.bits)
  val (req, resp) = (mem.req.bits, mem.resp.bits)

  // Default value

  val inflight_id_reg = RegInit(0.U)
  val axi_na :: axi_read :: axi_write :: Nil = Enum(3)
  val inflight_type = RegInit(axi_na)
  private def setState(axi_type: UInt, id: UInt) = {
    inflight_id_reg := id
    inflight_type := axi_type;
  }
  private def resetState() = {
    inflight_type := axi_na
    inflight_id_reg := 0.U
  }
  private def isState(state: UInt) = {
    inflight_type === state
  }
  private def isInflight() = {
    !isState(axi_na)
  }

  // Default
  val default_mem = 0.U.asTypeOf(new SimpleBusUC)
  val default_axi = 0.U.asTypeOf(new AXI4)
  req := default_mem.req.bits
  r := default_axi.r.bits
  b := default_axi.b.bits

  // Read Path
  when (!isInflight() && axi.ar.valid) {
    mem.req.valid := true.B
    req.addr := ar.addr
    req.cmd := Mux(ar.len === 0.U, SimpleBusCmd.read, SimpleBusCmd.readBurst)
    // TODO: consider ar.burst
    req.size := ar.size
    req.user.foreach(_ := ar.user)
    req.wmask := 0.U
    req.wdata := 0.U

    when (mem.req.fire) {
      setState(axi_read, ar.id)
    }
  }

  when (isState(axi_read) && mem.resp.valid) {
    axi.r.valid := true.B
    r.data := resp.rdata
    r.id := inflight_id_reg
    // TODO: r.resp handling
    r.resp := AXI4Parameters.RESP_OKAY
    r.last := resp.isReadLast
    resp.user.foreach(r.user := _)

    when (axi.r.fire && resp.isReadLast) {
      resetState()
    }
  }

  // Write Path
  val aw_reg = Reg(new AXI4BundleA(idBits))
  val bresp_en = RegInit(false.B)

  when (!isInflight() && axi.aw.valid && !axi.ar.valid) {
    aw_reg := aw

    when (axi.aw.fire) {
      setState(axi_write, aw.id)
    }
  }

  when (isState(axi_write) && axi.w.fire) {
    mem.req.valid := true.B
    req.cmd := Mux(aw_reg.len === 0.U, SimpleBusCmd.write,
      Mux(w.last, SimpleBusCmd.writeLast, SimpleBusCmd.writeBurst))
    req.addr := aw_reg.addr
    req.size := aw_reg.size
    req.wmask := w.strb
    req.wdata := w.data
    req.user.foreach(_ := aw.user)

    when (w.last) {
      bresp_en := true.B
    }
  }

  when (axi.b.fire) {
    bresp_en := false.B
    // resetState()
  }

  // Arbitration
  // Slave's ready maybe generated according to valid signal, so let valid signals go through.
  mem.req.valid := (!isInflight() && axi.ar.valid) || (isState(axi_write) && axi.w.valid)
  mem.resp.ready := !isInflight() || (isState(axi_read) && axi.r.ready) || (isState(axi_write) && axi.b.ready)
  axi.ar.ready := !isInflight() && mem.req.ready
  axi.r.valid := isState(axi_read) && mem.resp.valid
  // AW should be buffered so no ready is considered.
  axi.aw.ready := !isInflight() && !axi.ar.valid
  axi.w.ready  := isState(axi_write) && mem.req.ready
  axi.b.valid := bresp_en && mem.resp.valid
  axi.b.bits.resp := AXI4Parameters.RESP_OKAY

  // val errCounter = RegInit(0.U(8.W))
  // errorCounter := errorCounter + 1.U

  when (axi.ar.fire) { assert(mem.req.fire && !isInflight()); }
  when (axi.aw.fire) { assert(!isInflight()); }
  when (axi.w.fire) { assert(mem.req .fire && isState(axi_write)); }
  when (axi.b.fire) { assert(mem.resp.fire && isState(axi_write)); }
  when (axi.r.fire) { assert(mem.resp.fire && isState(axi_read)); }
}

