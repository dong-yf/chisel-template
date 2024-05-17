package bus.simplebus

import chisel3._
import chisel3.util._


class SimpleBusCrossbar1toN(addressSpace: List[(Long, Long)]) extends Module {
  val io = IO(new Bundle {
    val in = Flipped(new SimpleBusUC)
    val out = Vec(addressSpace.length, new SimpleBusUC)
  })

  val s_idle :: s_resp :: s_error :: Nil = Enum(3)
  val state = RegInit(s_idle)

  // select the output channel according to the address
  val addr = io.in.req.bits.addr
  val outMatchVec = VecInit(addressSpace.map(
    range => (addr >= range._1.U && addr < (range._1 + range._2).U)))
  val outSelVec = VecInit(PriorityEncoderOH(outMatchVec))
  val outSelRespVec = RegEnable(outSelVec,
                                VecInit(Seq.fill(outSelVec.length)(false.B)),
                                io.in.req.fire && state === s_idle)
  val reqInvalidAddr = io.in.req.valid && !outSelVec.asUInt.orR

  assert(!reqInvalidAddr, "address decode error, bad addr = 0x%x\n", addr)

  switch (state) {
    is (s_idle) {
      when (io.in.req.fire) { state := s_resp }
      when (reqInvalidAddr) { state := s_error }
    }
    is (s_resp) { when (io.in.resp.fire) { state := s_idle } }
    is (s_error) { when (io.in.resp.fire) { state := s_idle } }
  }

  // bind out.req channel
  io.in.req.ready := Mux1H(outSelVec, io.out.map(_.req.ready)) || reqInvalidAddr
  for (i <- 0 until io.out.length) {
    io.out(i).req.valid := outSelVec(i) && io.in.req.valid && state === s_idle
    io.out(i).req.bits := io.in.req.bits
  }

  // bind in.resp channel
  for (i <- 0 until io.out.length) {
    io.out(i).resp.ready := outSelRespVec(i) && io.in.resp.ready && state === s_resp
  }
  io.in.resp.valid := Mux1H(outSelRespVec, io.out.map(_.resp.valid)) || state === s_error
  io.in.resp.bits := Mux1H(outSelRespVec, io.out.map(_.resp.bits))
  // io.in.resp.bits.exc.get := state === s_error

  // assertion begin
  val count = RegInit(0.U(32.W))
  count := count + 1.U
  when (count === 100.U) {
    assert(io.in.resp.valid === true.B)
  }
}

class SimpleBusCrossbarNto1(n: Int, userBits:Int = 0) extends Module {
  val io = IO(new Bundle {
    val in = Flipped(Vec(n, new SimpleBusUC(userBits)))
    val out = new SimpleBusUC(userBits)
  })

  val s_idle :: s_readResp :: s_writeResp :: Nil = Enum(3)
  val state = RegInit(s_idle)

  val lockWriteFun = ((x: SimpleBusReqBundle) => x.isWrite() && x.isBurst())
  val inputArb = Module(new LockingArbiter(chiselTypeOf(io.in(0).req.bits), n, 8, Some(lockWriteFun)))
  (inputArb.io.in zip io.in.map(_.req)).map{ case (arb, in) => arb <> in }
  val thisReq = inputArb.io.out
  assert(!(thisReq.valid && !thisReq.bits.isRead() && !thisReq.bits.isWrite()))
  val inflightSrc = RegInit(0.U(log2Up(n).W))

  io.out.req.bits := thisReq.bits
  // bind correct valid and ready signals
  io.out.req.valid := thisReq.valid && (state === s_idle)
  thisReq.ready := io.out.req.ready && (state === s_idle)

  io.in.map(_.resp.bits := io.out.resp.bits)
  io.in.map(_.resp.valid := false.B)
  (io.in(inflightSrc).resp, io.out.resp) match { case (l, r) => {
    l.valid := r.valid
    r.ready := l.ready
  }}

  switch (state) {
    is (s_idle) {
      when (thisReq.fire) {
        inflightSrc := inputArb.io.chosen
        when (thisReq.bits.isRead()) { state := s_readResp }
        .elsewhen (thisReq.bits.isWriteLast() || thisReq.bits.isWriteSingle()) { state := s_writeResp }
      }
    }
    is (s_readResp) { when (io.out.resp.fire && io.out.resp.bits.isReadLast) { state := s_idle } }
    is (s_writeResp) { when (io.out.resp.fire) { state := s_idle } }
  }

  // assertion begin
  val count = RegInit(0.U(32.W))
  count := count + 1.U
  when (count === 40.U) {
    assert(io.out.resp.ready === true.B)
  }
}