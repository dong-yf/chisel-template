package example

import chisel3._
import chisel3.util._

// class Example extends Module { 
//  val x = Input(UInt<8>) 
//  val y = Input(UInt<8>) 
//  val z = Input(UInt<8>) 
//  val o = Output(Bool())
//  val u = Reg(UInt<8>)
//  val v = Reg(UInt<8>)
//  when(x < y && y < z)
//  {
//   v := y
//  }
//  o := false.B 
//  when(x+1 < y (*$| |$*) x < y)
//  {
//   when (y+1 < z (*$| |$*) y < z)
//   {
//    o := true.B
//    u := x
//   }
//  }
//  assert(!o || x + 2 < z)
// }

class Example2 extends Module { 
  val io = IO(new Bundle { 
    val x = Input(UInt(8.W)) 
    val y = Input(UInt(8.W)) 
    val z = Input(UInt(8.W)) 
    val o = Output(Bool())
  })
    
  val u = Reg(UInt(8.W))
  val v = Reg(UInt(8.W))
  
  when(io.x < io.y && io.y < io.z) {
    v := io.y
  }
  
  io.o := false.B 
  
  when(io.x + 1.U < io.y || io.x < io.y) {
    when(io.y + 1.U < io.z || io.y < io.z) {
      io.o := true.B
      u := io.x
    }
  }
  
  assert(!io.o || io.x + 2.U < io.z)
}





class Example107 extends Module { 
	val io = IO(new Bundle {
		val x = Input(UInt(8.W)) 
		val y1 = Input(UInt(8.W)) 
		val y2 = Input(UInt(8.W)) 
		val y3 = Input(UInt(8.W)) 
		val y4 = Input(UInt(8.W)) 
		val y5 = Input(UInt(8.W)) 
		val y6 = Input(UInt(8.W)) 
		val y7 = Input(UInt(8.W)) 
		val y8 = Input(UInt(8.W)) 
		val y9 = Input(UInt(8.W)) 
		val y10 = Input(UInt(8.W)) 
		val y11 = Input(UInt(8.W)) 
		val y12 = Input(UInt(8.W)) 
		val y13 = Input(UInt(8.W)) 
		val y14 = Input(UInt(8.W)) 
		val y15 = Input(UInt(8.W)) 
		val y16 = Input(UInt(8.W)) 
		val y17 = Input(UInt(8.W)) 
		val y18 = Input(UInt(8.W)) 
		val y19 = Input(UInt(8.W)) 
		val y20 = Input(UInt(8.W)) 
		val y21 = Input(UInt(8.W)) 
		val y22 = Input(UInt(8.W)) 
		val y23 = Input(UInt(8.W)) 
		val y24 = Input(UInt(8.W)) 
		val y25 = Input(UInt(8.W)) 
		val y26 = Input(UInt(8.W)) 
		val y27 = Input(UInt(8.W)) 
		val y28 = Input(UInt(8.W)) 
		val y29 = Input(UInt(8.W)) 
		val y30 = Input(UInt(8.W)) 
		val y31 = Input(UInt(8.W)) 
		val y32 = Input(UInt(8.W)) 
		val y33 = Input(UInt(8.W)) 
		val y34 = Input(UInt(8.W)) 
		val y35 = Input(UInt(8.W)) 
		val y36 = Input(UInt(8.W)) 
		val y37 = Input(UInt(8.W)) 
		val y38 = Input(UInt(8.W)) 
		val y39 = Input(UInt(8.W)) 
		val y40 = Input(UInt(8.W)) 
		val y41 = Input(UInt(8.W)) 
		val y42 = Input(UInt(8.W)) 
		val y43 = Input(UInt(8.W)) 
		val y44 = Input(UInt(8.W)) 
		val y45 = Input(UInt(8.W)) 
		val y46 = Input(UInt(8.W)) 
		val y47 = Input(UInt(8.W)) 
		val y48 = Input(UInt(8.W)) 
		val y49 = Input(UInt(8.W)) 
		val y50 = Input(UInt(8.W))

		val y51 = Input(UInt(8.W)) 
		val y52 = Input(UInt(8.W)) 
		val y53 = Input(UInt(8.W)) 
		val y54 = Input(UInt(8.W)) 
		val y55 = Input(UInt(8.W)) 
		val y56 = Input(UInt(8.W)) 
		val y57 = Input(UInt(8.W)) 
		val y58 = Input(UInt(8.W)) 
		val y59 = Input(UInt(8.W)) 
		val y60 = Input(UInt(8.W)) 
		val y61 = Input(UInt(8.W)) 
		val y62 = Input(UInt(8.W)) 
		val y63 = Input(UInt(8.W)) 
		val y64 = Input(UInt(8.W)) 
		val y65 = Input(UInt(8.W)) 
		val y66 = Input(UInt(8.W)) 
		val y67 = Input(UInt(8.W)) 
		val y68 = Input(UInt(8.W)) 
		val y69 = Input(UInt(8.W)) 
		val y70 = Input(UInt(8.W)) 
		val y71 = Input(UInt(8.W)) 
		val y72 = Input(UInt(8.W)) 
		val y73 = Input(UInt(8.W)) 
		val y74 = Input(UInt(8.W)) 
		val y75 = Input(UInt(8.W)) 
		val y76 = Input(UInt(8.W)) 
		val y77 = Input(UInt(8.W)) 
		val y78 = Input(UInt(8.W)) 
		val y79 = Input(UInt(8.W)) 
		val y80 = Input(UInt(8.W)) 
		val y81 = Input(UInt(8.W)) 
		val y82 = Input(UInt(8.W)) 
		val y83 = Input(UInt(8.W)) 
		val y84 = Input(UInt(8.W)) 
		val y85 = Input(UInt(8.W)) 
		val y86 = Input(UInt(8.W)) 
		val y87 = Input(UInt(8.W)) 
		val y88 = Input(UInt(8.W)) 
		val y89 = Input(UInt(8.W)) 
		val y90 = Input(UInt(8.W)) 
		val y91 = Input(UInt(8.W)) 
		val y92 = Input(UInt(8.W)) 
		val y93 = Input(UInt(8.W)) 
		val y94 = Input(UInt(8.W)) 
		val y95 = Input(UInt(8.W)) 
		val y96 = Input(UInt(8.W)) 
		val y97 = Input(UInt(8.W)) 
		val y98 = Input(UInt(8.W)) 
		val y99 = Input(UInt(8.W)) 
		val y100 = Input(UInt(8.W)) 

		val en1 = Input(Bool())
		val en2 = Input(Bool())
		val z = Input(UInt(8.W)) 
		val u = Output(UInt(8.W))
		val v = Output(UInt(8.W))
	})
	val a = io.en1 && io.en2
	val cnt = RegInit(0.U(8.W))
	val res = RegInit(0.U(8.W))


	io.u := 0.U
	io.v := 0.U
	
	when(a)
	{
		io.v := io.y1
	}
	when(cnt < 50.U)
	{
		when(
		io.x+1.U < io.y50 || io.x+1.U < io.y49 || io.x+1.U < io.y48 || io.x+1.U < io.y47 || io.x+1.U < io.y46 || io.x+1.U < io.y45 || io.x+1.U < io.y44 || io.x+1.U < io.y43 || io.x+1.U < io.y42 || io.x+1.U < io.y41 ||
		io.x+1.U < io.y40 || io.x+1.U < io.y39 || io.x+1.U < io.y38 || io.x+1.U < io.y37 || io.x+1.U < io.y36 || io.x+1.U < io.y35 || io.x+1.U < io.y34 || io.x+1.U < io.y33 || io.x+1.U < io.y32 || io.x+1.U < io.y31 ||
		io.x+1.U < io.y30 || io.x+1.U < io.y29 || io.x+1.U < io.y28 || io.x+1.U < io.y27 || io.x+1.U < io.y26 || io.x+1.U < io.y25 || io.x+1.U < io.y24 || io.x+1.U < io.y23 || io.x+1.U < io.y22 || io.x+1.U < io.y21 ||
		io.x+1.U < io.y20 || io.x+1.U < io.y19 || io.x+1.U < io.y18 || io.x+1.U < io.y17 || io.x+1.U < io.y16 || io.x+1.U < io.y15 || io.x+1.U < io.y14 || io.x+1.U < io.y13 || io.x+1.U < io.y12 || io.x+1.U < io.y11 ||
		io.x+1.U < io.y10 || io.x+1.U < io.y9 || io.x+1.U < io.y8 || io.x+1.U < io.y7 || io.x+1.U < io.y6 || io.x+1.U < io.y5 || io.x+1.U < io.y4 || io.x+1.U < io.y3 || io.x+1.U < io.y2 || (io.en1 && io.x < io.y1) ||
		io.x+1.U < io.y60 || io.x+1.U < io.y59 || io.x+1.U < io.y58 || io.x+1.U < io.y57 || io.x+1.U < io.y56 || io.x+1.U < io.y55 || io.x+1.U < io.y54 || io.x+1.U < io.y53 || io.x+1.U < io.y52 || io.x+1.U < io.y51 ||
		io.x+1.U < io.y70 || io.x+1.U < io.y69 || io.x+1.U < io.y68 || io.x+1.U < io.y67 || io.x+1.U < io.y66 || io.x+1.U < io.y65 || io.x+1.U < io.y64 || io.x+1.U < io.y63 || io.x+1.U < io.y62 || io.x+1.U < io.y61 ||
		io.x+1.U < io.y80 || io.x+1.U < io.y79 || io.x+1.U < io.y78 || io.x+1.U < io.y77 || io.x+1.U < io.y76 || io.x+1.U < io.y75 || io.x+1.U < io.y74 || io.x+1.U < io.y73 || io.x+1.U < io.y72 || io.x+1.U < io.y71 ||
		io.x+1.U < io.y90 || io.x+1.U < io.y89 || io.x+1.U < io.y88 || io.x+1.U < io.y87 || io.x+1.U < io.y86 || io.x+1.U < io.y85 || io.x+1.U < io.y84 || io.x+1.U < io.y83 || io.x+1.U < io.y82 || io.x+1.U < io.y81 ||
		io.x+1.U < io.y100 || io.x+1.U < io.y99 || io.x+1.U < io.y98 || io.x+1.U < io.y97 || io.x+1.U < io.y96 || io.x+1.U < io.y95 || io.x+1.U < io.y94 || io.x+1.U < io.y93 || io.x+1.U < io.y92 || io.x+1.U < io.y91
		)
		{
			when(
			io.y50+1.U < io.z || io.y49+1.U < io.z || io.y48+1.U < io.z || io.y47+1.U < io.z || io.y46+1.U < io.z || io.y45+1.U < io.z || io.y44+1.U < io.z || io.y43+1.U < io.z || io.y42+1.U < io.z || io.y41+1.U < io.z ||
			io.y40+1.U < io.z || io.y39+1.U < io.z || io.y38+1.U < io.z || io.y37+1.U < io.z || io.y36+1.U < io.z || io.y35+1.U < io.z || io.y34+1.U < io.z || io.y33+1.U < io.z || io.y32+1.U < io.z || io.y31+1.U < io.z ||
			io.y30+1.U < io.z || io.y29+1.U < io.z || io.y28+1.U < io.z || io.y27+1.U < io.z || io.y26+1.U < io.z || io.y25+1.U < io.z || io.y24+1.U < io.z || io.y23+1.U < io.z || io.y22+1.U < io.z || io.y21+1.U < io.z ||
			io.y20+1.U < io.z || io.y19+1.U < io.z || io.y18+1.U < io.z || io.y17+1.U < io.z || io.y16+1.U < io.z || io.y15+1.U < io.z || io.y14+1.U < io.z || io.y13+1.U < io.z || io.y12+1.U < io.z || io.y11+1.U < io.z ||
			io.y10+1.U < io.z || io.y9+1.U < io.z || io.y8+1.U < io.z || io.y7+1.U < io.z || io.y6+1.U < io.z || io.y5+1.U < io.z || io.y4+1.U < io.z || io.y3+1.U < io.z || io.y2+1.U < io.z || (io.en2 && io.y1 < io.z) ||
			io.y60+1.U < io.z || io.y59+1.U < io.z || io.y58+1.U < io.z || io.y57+1.U < io.z || io.y56+1.U < io.z || io.y55+1.U < io.z || io.y54+1.U < io.z || io.y53+1.U < io.z || io.y52+1.U < io.z || io.y51+1.U < io.z ||
			io.y70+1.U < io.z || io.y69+1.U < io.z || io.y68+1.U < io.z || io.y67+1.U < io.z || io.y66+1.U < io.z || io.y65+1.U < io.z || io.y64+1.U < io.z || io.y63+1.U < io.z || io.y62+1.U < io.z || io.y61+1.U < io.z ||
			io.y80+1.U < io.z || io.y79+1.U < io.z || io.y78+1.U < io.z || io.y77+1.U < io.z || io.y76+1.U < io.z || io.y75+1.U < io.z || io.y74+1.U < io.z || io.y73+1.U < io.z || io.y72+1.U < io.z || io.y71+1.U < io.z ||
			io.y90+1.U < io.z || io.y89+1.U < io.z || io.y88+1.U < io.z || io.y87+1.U < io.z || io.y86+1.U < io.z || io.y85+1.U < io.z || io.y84+1.U < io.z || io.y83+1.U < io.z || io.y82+1.U < io.z || io.y81+1.U < io.z ||
			io.y100+1.U < io.z || io.y99+1.U < io.z || io.y98+1.U < io.z || io.y97+1.U < io.z || io.y96+1.U < io.z || io.y95+1.U < io.z || io.y94+1.U < io.z || io.y93+1.U < io.z || io.y92+1.U < io.z || io.y91+1.U < io.z
			)
			{
			io.u := io.x
			res := res + io.z - io.x
			}
		}
		cnt := cnt + 1.U
	}
	assert(!cnt === 50.U || res > 100.U)
}

class Example108 extends Module { 
	val io = IO(new Bundle {
		val x = Input(UInt(8.W)) 
		val y1 = Input(UInt(8.W)) 
		val y2 = Input(UInt(8.W)) 
		val y3 = Input(UInt(8.W)) 
		val y4 = Input(UInt(8.W)) 
		val y5 = Input(UInt(8.W)) 
		val y6 = Input(UInt(8.W)) 
		val y7 = Input(UInt(8.W)) 
		val y8 = Input(UInt(8.W)) 
		val y9 = Input(UInt(8.W)) 
		val y10 = Input(UInt(8.W)) 
		val y11 = Input(UInt(8.W)) 
		val y12 = Input(UInt(8.W)) 
		val y13 = Input(UInt(8.W)) 
		val y14 = Input(UInt(8.W)) 
		val y15 = Input(UInt(8.W)) 
		val y16 = Input(UInt(8.W)) 
		val y17 = Input(UInt(8.W)) 
		val y18 = Input(UInt(8.W)) 
		val y19 = Input(UInt(8.W)) 
		val y20 = Input(UInt(8.W)) 
		val y21 = Input(UInt(8.W)) 
		val y22 = Input(UInt(8.W)) 
		val y23 = Input(UInt(8.W)) 
		val y24 = Input(UInt(8.W)) 
		val y25 = Input(UInt(8.W)) 
		val y26 = Input(UInt(8.W)) 
		val y27 = Input(UInt(8.W)) 
		val y28 = Input(UInt(8.W)) 
		val y29 = Input(UInt(8.W)) 
		val y30 = Input(UInt(8.W)) 
		val y31 = Input(UInt(8.W)) 
		val y32 = Input(UInt(8.W)) 
		val y33 = Input(UInt(8.W)) 
		val y34 = Input(UInt(8.W)) 
		val y35 = Input(UInt(8.W)) 
		val y36 = Input(UInt(8.W)) 
		val y37 = Input(UInt(8.W)) 
		val y38 = Input(UInt(8.W)) 
		val y39 = Input(UInt(8.W)) 
		val y40 = Input(UInt(8.W)) 
		val y41 = Input(UInt(8.W)) 
		val y42 = Input(UInt(8.W)) 
		val y43 = Input(UInt(8.W)) 
		val y44 = Input(UInt(8.W)) 
		val y45 = Input(UInt(8.W)) 
		val y46 = Input(UInt(8.W)) 
		val y47 = Input(UInt(8.W)) 
		val y48 = Input(UInt(8.W)) 
		val y49 = Input(UInt(8.W)) 
		val y50 = Input(UInt(8.W))

		val y51 = Input(UInt(8.W)) 
		val y52 = Input(UInt(8.W)) 
		val y53 = Input(UInt(8.W)) 
		val y54 = Input(UInt(8.W)) 
		val y55 = Input(UInt(8.W)) 
		val y56 = Input(UInt(8.W)) 
		val y57 = Input(UInt(8.W)) 
		val y58 = Input(UInt(8.W)) 
		val y59 = Input(UInt(8.W)) 
		val y60 = Input(UInt(8.W)) 
		val y61 = Input(UInt(8.W)) 
		val y62 = Input(UInt(8.W)) 
		val y63 = Input(UInt(8.W)) 
		val y64 = Input(UInt(8.W)) 
		val y65 = Input(UInt(8.W)) 
		val y66 = Input(UInt(8.W)) 
		val y67 = Input(UInt(8.W)) 
		val y68 = Input(UInt(8.W)) 
		val y69 = Input(UInt(8.W)) 
		val y70 = Input(UInt(8.W)) 
		val y71 = Input(UInt(8.W)) 
		val y72 = Input(UInt(8.W)) 
		val y73 = Input(UInt(8.W)) 
		val y74 = Input(UInt(8.W)) 
		val y75 = Input(UInt(8.W)) 
		val y76 = Input(UInt(8.W)) 
		val y77 = Input(UInt(8.W)) 
		val y78 = Input(UInt(8.W)) 
		val y79 = Input(UInt(8.W)) 
		val y80 = Input(UInt(8.W)) 
		val y81 = Input(UInt(8.W)) 
		val y82 = Input(UInt(8.W)) 
		val y83 = Input(UInt(8.W)) 
		val y84 = Input(UInt(8.W)) 
		val y85 = Input(UInt(8.W)) 
		val y86 = Input(UInt(8.W)) 
		val y87 = Input(UInt(8.W)) 
		val y88 = Input(UInt(8.W)) 
		val y89 = Input(UInt(8.W)) 
		val y90 = Input(UInt(8.W)) 
		val y91 = Input(UInt(8.W)) 
		val y92 = Input(UInt(8.W)) 
		val y93 = Input(UInt(8.W)) 
		val y94 = Input(UInt(8.W)) 
		val y95 = Input(UInt(8.W)) 
		val y96 = Input(UInt(8.W)) 
		val y97 = Input(UInt(8.W)) 
		val y98 = Input(UInt(8.W)) 
		val y99 = Input(UInt(8.W)) 
		val y100 = Input(UInt(8.W)) 

		val en1 = Input(Bool())
		val en2 = Input(Bool())
		val z = Input(UInt(8.W)) 
		val u = Output(UInt(8.W))
		val v = Output(UInt(8.W))
	})
	val a = !io.en1 && !io.en2
	val cnt = RegInit(0.U(8.W))
	val res = RegInit(0.U(8.W))


	io.u := 0.U
	io.v := 0.U
	
	when(a)
	{
		io.v := io.y1
	}
	when(cnt < 50.U)
	{
		when(
		io.x+1.U < io.y50 || io.x+1.U < io.y49 || io.x+1.U < io.y48 || io.x+1.U < io.y47 || io.x+1.U < io.y46 || io.x+1.U < io.y45 || io.x+1.U < io.y44 || io.x+1.U < io.y43 || io.x+1.U < io.y42 || io.x+1.U < io.y41 ||
		io.x+1.U < io.y40 || io.x+1.U < io.y39 || io.x+1.U < io.y38 || io.x+1.U < io.y37 || io.x+1.U < io.y36 || io.x+1.U < io.y35 || io.x+1.U < io.y34 || io.x+1.U < io.y33 || io.x+1.U < io.y32 || io.x+1.U < io.y31 ||
		io.x+1.U < io.y30 || io.x+1.U < io.y29 || io.x+1.U < io.y28 || io.x+1.U < io.y27 || io.x+1.U < io.y26 || io.x+1.U < io.y25 || io.x+1.U < io.y24 || io.x+1.U < io.y23 || io.x+1.U < io.y22 || io.x+1.U < io.y21 ||
		io.x+1.U < io.y20 || io.x+1.U < io.y19 || io.x+1.U < io.y18 || io.x+1.U < io.y17 || io.x+1.U < io.y16 || io.x+1.U < io.y15 || io.x+1.U < io.y14 || io.x+1.U < io.y13 || io.x+1.U < io.y12 || io.x+1.U < io.y11 ||
		io.x+1.U < io.y10 || io.x+1.U < io.y9 || io.x+1.U < io.y8 || io.x+1.U < io.y7 || io.x+1.U < io.y6 || io.x+1.U < io.y5 || io.x+1.U < io.y4 || io.x+1.U < io.y3 || io.x+1.U < io.y2 || (!io.en1 && io.x < io.y1) ||
		io.x+1.U < io.y60 || io.x+1.U < io.y59 || io.x+1.U < io.y58 || io.x+1.U < io.y57 || io.x+1.U < io.y56 || io.x+1.U < io.y55 || io.x+1.U < io.y54 || io.x+1.U < io.y53 || io.x+1.U < io.y52 || io.x+1.U < io.y51 ||
		io.x+1.U < io.y70 || io.x+1.U < io.y69 || io.x+1.U < io.y68 || io.x+1.U < io.y67 || io.x+1.U < io.y66 || io.x+1.U < io.y65 || io.x+1.U < io.y64 || io.x+1.U < io.y63 || io.x+1.U < io.y62 || io.x+1.U < io.y61 ||
		io.x+1.U < io.y80 || io.x+1.U < io.y79 || io.x+1.U < io.y78 || io.x+1.U < io.y77 || io.x+1.U < io.y76 || io.x+1.U < io.y75 || io.x+1.U < io.y74 || io.x+1.U < io.y73 || io.x+1.U < io.y72 || io.x+1.U < io.y71 ||
		io.x+1.U < io.y90 || io.x+1.U < io.y89 || io.x+1.U < io.y88 || io.x+1.U < io.y87 || io.x+1.U < io.y86 || io.x+1.U < io.y85 || io.x+1.U < io.y84 || io.x+1.U < io.y83 || io.x+1.U < io.y82 || io.x+1.U < io.y81 ||
		io.x+1.U < io.y100 || io.x+1.U < io.y99 || io.x+1.U < io.y98 || io.x+1.U < io.y97 || io.x+1.U < io.y96 || io.x+1.U < io.y95 || io.x+1.U < io.y94 || io.x+1.U < io.y93 || io.x+1.U < io.y92 || io.x+1.U < io.y91
		)
		{
			when(
			io.y50+1.U < io.z || io.y49+1.U < io.z || io.y48+1.U < io.z || io.y47+1.U < io.z || io.y46+1.U < io.z || io.y45+1.U < io.z || io.y44+1.U < io.z || io.y43+1.U < io.z || io.y42+1.U < io.z || io.y41+1.U < io.z ||
			io.y40+1.U < io.z || io.y39+1.U < io.z || io.y38+1.U < io.z || io.y37+1.U < io.z || io.y36+1.U < io.z || io.y35+1.U < io.z || io.y34+1.U < io.z || io.y33+1.U < io.z || io.y32+1.U < io.z || io.y31+1.U < io.z ||
			io.y30+1.U < io.z || io.y29+1.U < io.z || io.y28+1.U < io.z || io.y27+1.U < io.z || io.y26+1.U < io.z || io.y25+1.U < io.z || io.y24+1.U < io.z || io.y23+1.U < io.z || io.y22+1.U < io.z || io.y21+1.U < io.z ||
			io.y20+1.U < io.z || io.y19+1.U < io.z || io.y18+1.U < io.z || io.y17+1.U < io.z || io.y16+1.U < io.z || io.y15+1.U < io.z || io.y14+1.U < io.z || io.y13+1.U < io.z || io.y12+1.U < io.z || io.y11+1.U < io.z ||
			io.y10+1.U < io.z || io.y9+1.U < io.z || io.y8+1.U < io.z || io.y7+1.U < io.z || io.y6+1.U < io.z || io.y5+1.U < io.z || io.y4+1.U < io.z || io.y3+1.U < io.z || io.y2+1.U < io.z || (!io.en2 && io.y1 < io.z) ||
			io.y60+1.U < io.z || io.y59+1.U < io.z || io.y58+1.U < io.z || io.y57+1.U < io.z || io.y56+1.U < io.z || io.y55+1.U < io.z || io.y54+1.U < io.z || io.y53+1.U < io.z || io.y52+1.U < io.z || io.y51+1.U < io.z ||
			io.y70+1.U < io.z || io.y69+1.U < io.z || io.y68+1.U < io.z || io.y67+1.U < io.z || io.y66+1.U < io.z || io.y65+1.U < io.z || io.y64+1.U < io.z || io.y63+1.U < io.z || io.y62+1.U < io.z || io.y61+1.U < io.z ||
			io.y80+1.U < io.z || io.y79+1.U < io.z || io.y78+1.U < io.z || io.y77+1.U < io.z || io.y76+1.U < io.z || io.y75+1.U < io.z || io.y74+1.U < io.z || io.y73+1.U < io.z || io.y72+1.U < io.z || io.y71+1.U < io.z ||
			io.y90+1.U < io.z || io.y89+1.U < io.z || io.y88+1.U < io.z || io.y87+1.U < io.z || io.y86+1.U < io.z || io.y85+1.U < io.z || io.y84+1.U < io.z || io.y83+1.U < io.z || io.y82+1.U < io.z || io.y81+1.U < io.z ||
			io.y100+1.U < io.z || io.y99+1.U < io.z || io.y98+1.U < io.z || io.y97+1.U < io.z || io.y96+1.U < io.z || io.y95+1.U < io.z || io.y94+1.U < io.z || io.y93+1.U < io.z || io.y92+1.U < io.z || io.y91+1.U < io.z
			)
			{
			io.u := io.x
			res := res + io.z - io.x
			}
		}
		cnt := cnt + 1.U
	}
	assert(!cnt === 50.U || res > 100.U)
}

class Example109 extends Module { 
	val io = IO(new Bundle {
		val x = Input(UInt(8.W)) 
		val y1 = Input(UInt(8.W)) 
		val y2 = Input(UInt(8.W)) 
		val y3 = Input(UInt(8.W)) 
		val y4 = Input(UInt(8.W)) 
		val y5 = Input(UInt(8.W)) 
		val y6 = Input(UInt(8.W)) 
		val y7 = Input(UInt(8.W)) 
		val y8 = Input(UInt(8.W)) 
		val y9 = Input(UInt(8.W)) 
		val y10 = Input(UInt(8.W)) 
		val y11 = Input(UInt(8.W)) 
		val y12 = Input(UInt(8.W)) 
		val y13 = Input(UInt(8.W)) 
		val y14 = Input(UInt(8.W)) 
		val y15 = Input(UInt(8.W)) 
		val y16 = Input(UInt(8.W)) 
		val y17 = Input(UInt(8.W)) 
		val y18 = Input(UInt(8.W)) 
		val y19 = Input(UInt(8.W)) 
		val y20 = Input(UInt(8.W)) 
		val y21 = Input(UInt(8.W)) 
		val y22 = Input(UInt(8.W)) 
		val y23 = Input(UInt(8.W)) 
		val y24 = Input(UInt(8.W)) 
		val y25 = Input(UInt(8.W)) 
		val y26 = Input(UInt(8.W)) 
		val y27 = Input(UInt(8.W)) 
		val y28 = Input(UInt(8.W)) 
		val y29 = Input(UInt(8.W)) 
		val y30 = Input(UInt(8.W)) 
		val y31 = Input(UInt(8.W)) 
		val y32 = Input(UInt(8.W)) 
		val y33 = Input(UInt(8.W)) 
		val y34 = Input(UInt(8.W)) 
		val y35 = Input(UInt(8.W)) 
		val y36 = Input(UInt(8.W)) 
		val y37 = Input(UInt(8.W)) 
		val y38 = Input(UInt(8.W)) 
		val y39 = Input(UInt(8.W)) 
		val y40 = Input(UInt(8.W)) 
		val y41 = Input(UInt(8.W)) 
		val y42 = Input(UInt(8.W)) 
		val y43 = Input(UInt(8.W)) 
		val y44 = Input(UInt(8.W)) 
		val y45 = Input(UInt(8.W)) 
		val y46 = Input(UInt(8.W)) 
		val y47 = Input(UInt(8.W)) 
		val y48 = Input(UInt(8.W)) 
		val y49 = Input(UInt(8.W)) 
		val y50 = Input(UInt(8.W))

		val y51 = Input(UInt(8.W)) 
		val y52 = Input(UInt(8.W)) 
		val y53 = Input(UInt(8.W)) 
		val y54 = Input(UInt(8.W)) 
		val y55 = Input(UInt(8.W)) 
		val y56 = Input(UInt(8.W)) 
		val y57 = Input(UInt(8.W)) 
		val y58 = Input(UInt(8.W)) 
		val y59 = Input(UInt(8.W)) 
		val y60 = Input(UInt(8.W)) 
		val y61 = Input(UInt(8.W)) 
		val y62 = Input(UInt(8.W)) 
		val y63 = Input(UInt(8.W)) 
		val y64 = Input(UInt(8.W)) 
		val y65 = Input(UInt(8.W)) 
		val y66 = Input(UInt(8.W)) 
		val y67 = Input(UInt(8.W)) 
		val y68 = Input(UInt(8.W)) 
		val y69 = Input(UInt(8.W)) 
		val y70 = Input(UInt(8.W)) 
		val y71 = Input(UInt(8.W)) 
		val y72 = Input(UInt(8.W)) 
		val y73 = Input(UInt(8.W)) 
		val y74 = Input(UInt(8.W)) 
		val y75 = Input(UInt(8.W)) 
		val y76 = Input(UInt(8.W)) 
		val y77 = Input(UInt(8.W)) 
		val y78 = Input(UInt(8.W)) 
		val y79 = Input(UInt(8.W)) 
		val y80 = Input(UInt(8.W)) 
		val y81 = Input(UInt(8.W)) 
		val y82 = Input(UInt(8.W)) 
		val y83 = Input(UInt(8.W)) 
		val y84 = Input(UInt(8.W)) 
		val y85 = Input(UInt(8.W)) 
		val y86 = Input(UInt(8.W)) 
		val y87 = Input(UInt(8.W)) 
		val y88 = Input(UInt(8.W)) 
		val y89 = Input(UInt(8.W)) 
		val y90 = Input(UInt(8.W)) 
		val y91 = Input(UInt(8.W)) 
		val y92 = Input(UInt(8.W)) 
		val y93 = Input(UInt(8.W)) 
		val y94 = Input(UInt(8.W)) 
		val y95 = Input(UInt(8.W)) 
		val y96 = Input(UInt(8.W)) 
		val y97 = Input(UInt(8.W)) 
		val y98 = Input(UInt(8.W)) 
		val y99 = Input(UInt(8.W)) 
		val y100 = Input(UInt(8.W)) 

		val en1 = Input(Bool())
		val en2 = Input(Bool())
		val z = Input(UInt(8.W)) 
		val u = Output(UInt(8.W))
		val v = Output(UInt(8.W))
	})
	val a = io.en1 && io.en2
	val res = Wire(UInt(8.W))

	io.u := 0.U
	io.v := 0.U
	res := 3.U
	
	when(a)
	{
		io.v := io.y1
	}
	when(
	(!io.en1 && io.x+1.U < io.y50) || (!io.en1 && io.x+1.U < io.y49) || (!io.en1 && io.x+1.U < io.y48) || (!io.en1 && io.x+1.U < io.y47) || (!io.en1 && io.x+1.U < io.y46) || (!io.en1 && io.x+1.U < io.y45) || (!io.en1 && io.x+1.U < io.y44) || (!io.en1 && io.x+1.U < io.y43) || (!io.en1 && io.x+1.U < io.y42) || (!io.en1 && (!io.en1 && io.x+1.U < io.y41) ||
	(!io.en1 && io.x+1.U < io.y40) || (!io.en1 && io.x+1.U < io.y39) || (!io.en1 && io.x+1.U < io.y38) || (!io.en1 && io.x+1.U < io.y37) || (!io.en1 && io.x+1.U < io.y36) || (!io.en1 && io.x+1.U < io.y35) || (!io.en1 && io.x+1.U < io.y34) || (!io.en1 && io.x+1.U < io.y33) || (!io.en1 && io.x+1.U < io.y32) || (!io.en1 && io.x+1.U < io.y31) ||
	(!io.en1 && io.x+1.U < io.y30) || (!io.en1 && io.x+1.U < io.y29) || (!io.en1 && io.x+1.U < io.y28) || (!io.en1 && io.x+1.U < io.y27) || (!io.en1 && io.x+1.U < io.y26) || (!io.en1 && io.x+1.U < io.y25) || (!io.en1 && io.x+1.U < io.y24) || io.x+1.U < io.y23) || (!io.en1 && io.x+1.U < io.y22) || (!io.en1 && io.x+1.U < io.y21) ||
	(!io.en1 && io.x+1.U < io.y20) || (!io.en1 && io.x+1.U < io.y19) || (!io.en1 && io.x+1.U < io.y18) || (!io.en1 && io.x+1.U < io.y17) || (!io.en1 && io.x+1.U < io.y16) || (!io.en1 && io.x+1.U < io.y15) || (!io.en1 && io.x+1.U < io.y14) || (!io.en1 && io.x+1.U < io.y13) || (!io.en1 && io.x+1.U < io.y12) || (!io.en1 && io.x+1.U < io.y11) ||
	(!io.en1 && io.x+1.U < io.y10) || (!io.en1 && io.x+1.U < io.y9) || (!io.en1 && io.x+1.U < io.y8) || (!io.en1 && io.x+1.U < io.y7) || (!io.en1 && io.x+1.U < io.y6) || (!io.en1 && io.x+1.U < io.y5) || (!io.en1 && io.x+1.U < io.y4) || (!io.en1 && io.x+1.U < io.y3) || (!io.en1 && io.x+1.U < io.y2) || (io.en1 && io.x < io.y1) ||
	(!io.en1 && io.x+1.U < io.y60) || (!io.en1 && io.x+1.U < io.y59) || (!io.en1 && io.x+1.U < io.y58) || (!io.en1 && io.x+1.U < io.y57) || (!io.en1 && io.x+1.U < io.y56) || (!io.en1 && io.x+1.U < io.y55) || (!io.en1 && io.x+1.U < io.y54) ||(!io.en1 && io.x+1.U < io.y53) || (!io.en1 && io.x+1.U < io.y52) || (!io.en1 && io.x+1.U < io.y51) ||
	(!io.en1 && io.x+1.U < io.y70) || (!io.en1 && io.x+1.U < io.y69) || (!io.en1 && io.x+1.U < io.y68) || (!io.en1 && io.x+1.U < io.y67) || (!io.en1 && io.x+1.U < io.y66) || (!io.en1 && io.x+1.U < io.y65) || (!io.en1 && io.x+1.U < io.y64) || (!io.en1 && io.x+1.U < io.y63) || (!io.en1 && io.x+1.U < io.y62) || (!io.en1 && io.x+1.U < io.y61) ||
	(!io.en1 && io.x+1.U < io.y80) || (!io.en1 && io.x+1.U < io.y79) || (!io.en1 && io.x+1.U < io.y78) || (!io.en1 && io.x+1.U < io.y77) || (!io.en1 && io.x+1.U < io.y76) || (!io.en1 && io.x+1.U < io.y75) || (!io.en1 && io.x+1.U < io.y74) || (!io.en1 && io.x+1.U < io.y73) || (!io.en1 && io.x+1.U < io.y72) || (!io.en1 && io.x+1.U < io.y71) ||
	(!io.en1 && io.x+1.U < io.y90) || (!io.en1 && io.x+1.U < io.y89) || (!io.en1 && io.x+1.U < io.y88) || (!io.en1 && io.x+1.U < io.y87) || (!io.en1 && io.x+1.U < io.y86) || (!io.en1 && io.x+1.U < io.y85) || (!io.en1 && io.x+1.U < io.y84) || (!io.en1 && io.x+1.U < io.y83) || (!io.en1 && io.x+1.U < io.y82) || (!io.en1 && io.x+1.U < io.y81) ||
	(!io.en1 && io.x+1.U < io.y100) || (!io.en1 && io.x+1.U < io.y99) || (!io.en1 && io.x+1.U < io.y98) || (!io.en1 && io.x+1.U < io.y97) || (!io.en1 && io.x+1.U < io.y96) || (!io.en1 && io.x+1.U < io.y95) || (!io.en1 && io.x+1.U < io.y94) || (!io.en1 && io.x+1.U < io.y93) || (!io.en1 && io.x+1.U < io.y92) || (!io.en1 && io.x+1.U < io.y91)
	)
	{
		when(
		(!io.en2 && io.y50+1.U < io.z) || (!io.en2 && io.y49+1.U < io.z) || (!io.en2 && io.y48+1.U < io.z) || (!io.en2 && io.y47+1.U < io.z) || (!io.en2 && io.y46+1.U < io.z) || (!io.en2 && io.y45+1.U < io.z) || (!io.en2 && io.y44+1.U < io.z) || (!io.en2 && io.y43+1.U < io.z) || (!io.en2 && io.y42+1.U < io.z) || (!io.en2 && io.y41+1.U < io.z) ||
		(!io.en2 && io.y40+1.U < io.z) || (!io.en2 && io.y39+1.U < io.z) || (!io.en2 && io.y38+1.U < io.z) || (!io.en2 && io.y37+1.U < io.z) || (!io.en2 && io.y36+1.U < io.z) || (!io.en2 && io.y35+1.U < io.z) || (!io.en2 && io.y34+1.U < io.z) || (!io.en2 && io.y33+1.U < io.z) || (!io.en2 && io.y32+1.U < io.z) || (!io.en2 && io.y31+1.U < io.z) ||
		(!io.en2 && io.y30+1.U < io.z) || (!io.en2 && io.y29+1.U < io.z) || (!io.en2 && io.y28+1.U < io.z) || (!io.en2 && io.y27+1.U < io.z) || (!io.en2 && io.y26+1.U < io.z) || (!io.en2 && io.y25+1.U < io.z) || (!io.en2 && io.y24+1.U < io.z) || (!io.en2 && io.y23+1.U < io.z) || (!io.en2 && io.y22+1.U < io.z) || (!io.en2 && io.y21+1.U < io.z) ||
		(!io.en2 && io.y20+1.U < io.z) || (!io.en2 && io.y19+1.U < io.z) || (!io.en2 && io.y18+1.U < io.z) || (!io.en2 && io.y17+1.U < io.z) || (!io.en2 && io.y16+1.U < io.z) || (!io.en2 && io.y15+1.U < io.z) || (!io.en2 && io.y14+1.U < io.z) || (!io.en2 && io.y13+1.U < io.z) || (!io.en2 && io.y12+1.U < io.z) || (!io.en2 && io.y11+1.U < io.z) ||
		(!io.en2 && io.y10+1.U < io.z) || (!io.en2 && io.y9+1.U < io.z) || (!io.en2 && io.y8+1.U < io.z) || (!io.en2 && io.y7+1.U < io.z) || (!io.en2 && io.y6+1.U < io.z) || (!io.en2 && io.y5+1.U < io.z) || (!io.en2 && io.y4+1.U < io.z) || (!io.en2 && io.y3+1.U < io.z) || (!io.en2 && io.y2+1.U < io.z) || (io.en2 && io.y1 < io.z) ||
		(!io.en2 && io.y60+1.U < io.z) || (!io.en2 && io.y59+1.U < io.z) || (!io.en2 && io.y58+1.U < io.z) || (!io.en2 && io.y57+1.U < io.z) || (!io.en2 && io.y56+1.U < io.z) || (!io.en2 && io.y55+1.U < io.z) || (!io.en2 && io.y54+1.U < io.z) || (!io.en2 && io.y53+1.U < io.z) || (!io.en2 && io.y52+1.U < io.z) || (!io.en2 && io.y51+1.U < io.z) ||
		(!io.en2 && io.y70+1.U < io.z) || (!io.en2 && io.y69+1.U < io.z) || (!io.en2 && io.y68+1.U < io.z) || (!io.en2 && io.y67+1.U < io.z) || (!io.en2 && io.y66+1.U < io.z) || (!io.en2 && io.y65+1.U < io.z) || (!io.en2 && io.y64+1.U < io.z) || (!io.en2 && io.y63+1.U < io.z) || (!io.en2 && io.y62+1.U < io.z) || (!io.en2 && io.y61+1.U < io.z) ||
		(!io.en2 && io.y80+1.U < io.z) || (!io.en2 && io.y79+1.U < io.z) || (!io.en2 && io.y78+1.U < io.z) || (!io.en2 && io.y77+1.U < io.z) || (!io.en2 && io.y76+1.U < io.z) || (!io.en2 && io.y75+1.U < io.z) || (!io.en2 && io.y74+1.U < io.z) || (!io.en2 && io.y73+1.U < io.z) || (!io.en2 && io.y72+1.U < io.z) || (!io.en2 && io.y71+1.U < io.z) ||
		(!io.en2 && io.y90+1.U < io.z) || (!io.en2 && io.y89+1.U < io.z) || (!io.en2 && io.y88+1.U < io.z) || (!io.en2 && io.y87+1.U < io.z) || (!io.en2 && io.y86+1.U < io.z) || (!io.en2 && io.y85+1.U < io.z) || (!io.en2 && io.y84+1.U < io.z) || (!io.en2 && io.y83+1.U < io.z) || (!io.en2 && io.y82+1.U < io.z) || (!io.en2 && io.y81+1.U < io.z) ||
		(!io.en2 && io.y100+1.U < io.z) || (!io.en2 && io.y99+1.U < io.z) || (!io.en2 && io.y98+1.U < io.z) || (!io.en2 && io.y97+1.U < io.z) || (!io.en2 && io.y96+1.U < io.z) || (!io.en2 && io.y95+1.U < io.z) || (!io.en2 && io.y94+1.U < io.z) || (!io.en2 && io.y93+1.U < io.z) || (!io.en2 && io.y92+1.U < io.z) || (!io.en2 && io.y91+1.U < io.z)
		)
		{
			io.u := io.x
			res := io.z - io.x
		}
	}
	assert(res > 2.U)
}

class Example110 extends Module { 
	val io = IO(new Bundle {
		val x = Input(UInt(8.W)) 
		val y1 = Input(UInt(8.W)) 
		val y2 = Input(UInt(8.W)) 
		val y3 = Input(UInt(8.W)) 
		val y4 = Input(UInt(8.W)) 
		val y5 = Input(UInt(8.W)) 
		val y6 = Input(UInt(8.W)) 
		val y7 = Input(UInt(8.W)) 
		val y8 = Input(UInt(8.W)) 
		val y9 = Input(UInt(8.W)) 
		val y10 = Input(UInt(8.W)) 
		val y11 = Input(UInt(8.W)) 
		val y12 = Input(UInt(8.W)) 
		val y13 = Input(UInt(8.W)) 
		val y14 = Input(UInt(8.W)) 
		val y15 = Input(UInt(8.W)) 
		val y16 = Input(UInt(8.W)) 
		val y17 = Input(UInt(8.W)) 
		val y18 = Input(UInt(8.W)) 
		val y19 = Input(UInt(8.W)) 
		val y20 = Input(UInt(8.W)) 
		val y21 = Input(UInt(8.W)) 
		val y22 = Input(UInt(8.W)) 
		val y23 = Input(UInt(8.W)) 
		val y24 = Input(UInt(8.W)) 
		val y25 = Input(UInt(8.W)) 
		val y26 = Input(UInt(8.W)) 
		val y27 = Input(UInt(8.W)) 
		val y28 = Input(UInt(8.W)) 
		val y29 = Input(UInt(8.W)) 
		val y30 = Input(UInt(8.W)) 
		val y31 = Input(UInt(8.W)) 
		val y32 = Input(UInt(8.W)) 
		val y33 = Input(UInt(8.W)) 
		val y34 = Input(UInt(8.W)) 
		val y35 = Input(UInt(8.W)) 
		val y36 = Input(UInt(8.W)) 
		val y37 = Input(UInt(8.W)) 
		val y38 = Input(UInt(8.W)) 
		val y39 = Input(UInt(8.W)) 
		val y40 = Input(UInt(8.W)) 
		val y41 = Input(UInt(8.W)) 
		val y42 = Input(UInt(8.W)) 
		val y43 = Input(UInt(8.W)) 
		val y44 = Input(UInt(8.W)) 
		val y45 = Input(UInt(8.W)) 
		val y46 = Input(UInt(8.W)) 
		val y47 = Input(UInt(8.W)) 
		val y48 = Input(UInt(8.W)) 
		val y49 = Input(UInt(8.W)) 
		val y50 = Input(UInt(8.W))

		val y51 = Input(UInt(8.W)) 
		val y52 = Input(UInt(8.W)) 
		val y53 = Input(UInt(8.W)) 
		val y54 = Input(UInt(8.W)) 
		val y55 = Input(UInt(8.W)) 
		val y56 = Input(UInt(8.W)) 
		val y57 = Input(UInt(8.W)) 
		val y58 = Input(UInt(8.W)) 
		val y59 = Input(UInt(8.W)) 
		val y60 = Input(UInt(8.W)) 
		val y61 = Input(UInt(8.W)) 
		val y62 = Input(UInt(8.W)) 
		val y63 = Input(UInt(8.W)) 
		val y64 = Input(UInt(8.W)) 
		val y65 = Input(UInt(8.W)) 
		val y66 = Input(UInt(8.W)) 
		val y67 = Input(UInt(8.W)) 
		val y68 = Input(UInt(8.W)) 
		val y69 = Input(UInt(8.W)) 
		val y70 = Input(UInt(8.W)) 
		val y71 = Input(UInt(8.W)) 
		val y72 = Input(UInt(8.W)) 
		val y73 = Input(UInt(8.W)) 
		val y74 = Input(UInt(8.W)) 
		val y75 = Input(UInt(8.W)) 
		val y76 = Input(UInt(8.W)) 
		val y77 = Input(UInt(8.W)) 
		val y78 = Input(UInt(8.W)) 
		val y79 = Input(UInt(8.W)) 
		val y80 = Input(UInt(8.W)) 
		val y81 = Input(UInt(8.W)) 
		val y82 = Input(UInt(8.W)) 
		val y83 = Input(UInt(8.W)) 
		val y84 = Input(UInt(8.W)) 
		val y85 = Input(UInt(8.W)) 
		val y86 = Input(UInt(8.W)) 
		val y87 = Input(UInt(8.W)) 
		val y88 = Input(UInt(8.W)) 
		val y89 = Input(UInt(8.W)) 
		val y90 = Input(UInt(8.W)) 
		val y91 = Input(UInt(8.W)) 
		val y92 = Input(UInt(8.W)) 
		val y93 = Input(UInt(8.W)) 
		val y94 = Input(UInt(8.W)) 
		val y95 = Input(UInt(8.W)) 
		val y96 = Input(UInt(8.W)) 
		val y97 = Input(UInt(8.W)) 
		val y98 = Input(UInt(8.W)) 
		val y99 = Input(UInt(8.W)) 
		val y100 = Input(UInt(8.W)) 

		val en1 = Input(Bool())
		val en2 = Input(Bool())
		val z = Input(UInt(8.W)) 
		val u = Output(UInt(8.W))
		val v = Output(UInt(8.W))
	})
	val a = io.en1 && io.en2
	val res = Wire(UInt(8.W))

	io.u := 0.U
	io.v := 0.U
	res := 3.U
	
	when(a)
	{
		io.v := io.y1
	}
	when(
	(!io.en1 && io.x+1.U < io.y50) || (!io.en1 && io.x+1.U < io.y49) || (!io.en1 && io.x+1.U < io.y48) || (!io.en1 && io.x+1.U < io.y47) || (!io.en1 && io.x+1.U < io.y46) || (!io.en1 && io.x+1.U < io.y45) || (!io.en1 && io.x+1.U < io.y44) || (!io.en1 && io.x+1.U < io.y43) || (!io.en1 && io.x+1.U < io.y42) || (!io.en1 && io.x+1.U < io.y41) ||
	(!io.en1 && io.x+1.U < io.y40) || (!io.en1 && io.x+1.U < io.y39) || (!io.en1 && io.x+1.U < io.y38) || (!io.en1 && io.x+1.U < io.y37) || (!io.en1 && io.x+1.U < io.y36) || (!io.en1 && io.x+1.U < io.y35) || (!io.en1 && io.x+1.U < io.y34) || (!io.en1 && io.x+1.U < io.y33) || (!io.en1 && io.x+1.U < io.y32) || (!io.en1 && io.x+1.U < io.y31) ||
	(!io.en1 && io.x+1.U < io.y30) || (!io.en1 && io.x+1.U < io.y29) || (!io.en1 && io.x+1.U < io.y28) || (!io.en1 && io.x+1.U < io.y27) || (!io.en1 && io.x+1.U < io.y26) || (!io.en1 && io.x+1.U < io.y25) || (!io.en1 && io.x+1.U < io.y24) || (!io.en1 && io.x+1.U < io.y23) || (!io.en1 && io.x+1.U < io.y22) || (!io.en1 && io.x+1.U < io.y21) ||
	(!io.en1 && io.x+1.U < io.y20) || (!io.en1 && io.x+1.U < io.y19) || (!io.en1 && io.x+1.U < io.y18) || (!io.en1 && io.x+1.U < io.y17) || (!io.en1 && io.x+1.U < io.y16) || (!io.en1 && io.x+1.U < io.y15) || (!io.en1 && io.x+1.U < io.y14) || (!io.en1 && io.x+1.U < io.y13) || (!io.en1 && io.x+1.U < io.y12) || (!io.en1 && io.x+1.U < io.y11) ||
	(!io.en1 && io.x+1.U < io.y10) || (!io.en1 && io.x+1.U < io.y9) || (!io.en1 && io.x+1.U < io.y8) || (!io.en1 && io.x+1.U < io.y7) || (!io.en1 && io.x+1.U < io.y6) || (!io.en1 && io.x+1.U < io.y5) || (!io.en1 && io.x+1.U < io.y4) || (!io.en1 && io.x+1.U < io.y3) || (!io.en1 && io.x+1.U < io.y2) || (io.en1 && io.x < io.y1) ||
	(!io.en1 && io.x+1.U < io.y60) || (!io.en1 && io.x+1.U < io.y59) || (!io.en1 && io.x+1.U < io.y58) || (!io.en1 && io.x+1.U < io.y57) || (!io.en1 && io.x+1.U < io.y56) || (!io.en1 && io.x+1.U < io.y55) || (!io.en1 && io.x+1.U < io.y54) ||(!io.en1 && io.x+1.U < io.y53) || (!io.en1 && io.x+1.U < io.y52) || (!io.en1 && io.x+1.U < io.y51) ||
	(!io.en1 && io.x+1.U < io.y70) || (!io.en1 && io.x+1.U < io.y69) || (!io.en1 && io.x+1.U < io.y68) || (!io.en1 && io.x+1.U < io.y67) || (!io.en1 && io.x+1.U < io.y66) || (!io.en1 && io.x+1.U < io.y65) || (!io.en1 && io.x+1.U < io.y64) || (!io.en1 && io.x+1.U < io.y63) || (!io.en1 && io.x+1.U < io.y62) || (!io.en1 && io.x+1.U < io.y61) ||
	(!io.en1 && io.x+1.U < io.y80) || (!io.en1 && io.x+1.U < io.y79) || (!io.en1 && io.x+1.U < io.y78) || (!io.en1 && io.x+1.U < io.y77) || (!io.en1 && io.x+1.U < io.y76) || (!io.en1 && io.x+1.U < io.y75) || (!io.en1 && io.x+1.U < io.y74) || (!io.en1 && io.x+1.U < io.y73) || (!io.en1 && io.x+1.U < io.y72) || (!io.en1 && io.x+1.U < io.y71) ||
	(!io.en1 && io.x+1.U < io.y90) || (!io.en1 && io.x+1.U < io.y89) || (!io.en1 && io.x+1.U < io.y88) || (!io.en1 && io.x+1.U < io.y87) || (!io.en1 && io.x+1.U < io.y86) || (!io.en1 && io.x+1.U < io.y85) || (!io.en1 && io.x+1.U < io.y84) || (!io.en1 && io.x+1.U < io.y83) || (!io.en1 && io.x+1.U < io.y82) || (!io.en1 && io.x+1.U < io.y81) ||
	(!io.en1 && io.x+1.U < io.y100) || (!io.en1 && io.x+1.U < io.y99) || (!io.en1 && io.x+1.U < io.y98) || (!io.en1 && io.x+1.U < io.y97) || (!io.en1 && io.x+1.U < io.y96) || (!io.en1 && io.x+1.U < io.y95) || (!io.en1 && io.x+1.U < io.y94) || (!io.en1 && io.x+1.U < io.y93) || (!io.en1 && io.x+1.U < io.y92) || (!io.en1 && io.x+1.U < io.y91)
	)
	{
		when(
		(!io.en2 && io.y50+1.U < io.z) || (!io.en2 && io.y49+1.U < io.z) || (!io.en2 && io.y48+1.U < io.z) || (!io.en2 && io.y47+1.U < io.z) || (!io.en2 && io.y46+1.U < io.z) || (!io.en2 && io.y45+1.U < io.z) || (!io.en2 && io.y44+1.U < io.z) || (!io.en2 && io.y43+1.U < io.z) || (!io.en2 && io.y42+1.U < io.z) || (!io.en2 && io.y41+1.U < io.z) ||
		(!io.en2 && io.y40+1.U < io.z) || (!io.en2 && io.y39+1.U < io.z) || (!io.en2 && io.y38+1.U < io.z) || (!io.en2 && io.y37+1.U < io.z) || (!io.en2 && io.y36+1.U < io.z) || (!io.en2 && io.y35+1.U < io.z) || (!io.en2 && io.y34+1.U < io.z) || (!io.en2 && io.y33+1.U < io.z) || (!io.en2 && io.y32+1.U < io.z) || (!io.en2 && io.y31+1.U < io.z) ||
		(!io.en2 && io.y30+1.U < io.z) || (!io.en2 && io.y29+1.U < io.z) || (!io.en2 && io.y28+1.U < io.z) || (!io.en2 && io.y27+1.U < io.z) || (!io.en2 && io.y26+1.U < io.z) || (!io.en2 && io.y25+1.U < io.z) || (!io.en2 && io.y24+1.U < io.z) || (!io.en2 && io.y23+1.U < io.z) || (!io.en2 && io.y22+1.U < io.z) || (!io.en2 && io.y21+1.U < io.z) ||
		(!io.en2 && io.y20+1.U < io.z) || (!io.en2 && io.y19+1.U < io.z) || (!io.en2 && io.y18+1.U < io.z) || (!io.en2 && io.y17+1.U < io.z) || (!io.en2 && io.y16+1.U < io.z) || (!io.en2 && io.y15+1.U < io.z) || (!io.en2 && io.y14+1.U < io.z) || (!io.en2 && io.y13+1.U < io.z) || (!io.en2 && io.y12+1.U < io.z) || (!io.en2 && io.y11+1.U < io.z) ||
		(!io.en2 && io.y10+1.U < io.z) || (!io.en2 && io.y9+1.U < io.z) || (!io.en2 && io.y8+1.U < io.z) || (!io.en2 && io.y7+1.U < io.z) || (!io.en2 && io.y6+1.U < io.z) || (!io.en2 && io.y5+1.U < io.z) || (!io.en2 && io.y4+1.U < io.z) || (!io.en2 && io.y3+1.U < io.z) || (!io.en2 && io.y2+1.U < io.z) || (io.en2 && io.y1 < io.z) ||
		(!io.en2 && io.y60+1.U < io.z) || (!io.en2 && io.y59+1.U < io.z) || (!io.en2 && io.y58+1.U < io.z) || (!io.en2 && io.y57+1.U < io.z) || (!io.en2 && io.y56+1.U < io.z) || (!io.en2 && io.y55+1.U < io.z) || (!io.en2 && io.y54+1.U < io.z) || (!io.en2 && io.y53+1.U < io.z) || (!io.en2 && io.y52+1.U < io.z) || (!io.en2 && io.y51+1.U < io.z) ||
		(!io.en2 && io.y70+1.U < io.z) || (!io.en2 && io.y69+1.U < io.z) || (!io.en2 && io.y68+1.U < io.z) || (!io.en2 && io.y67+1.U < io.z) || (!io.en2 && io.y66+1.U < io.z) || (!io.en2 && io.y65+1.U < io.z) || (!io.en2 && io.y64+1.U < io.z) || (!io.en2 && io.y63+1.U < io.z) || (!io.en2 && io.y62+1.U < io.z) || (!io.en2 && io.y61+1.U < io.z) ||
		(!io.en2 && io.y80+1.U < io.z) || (!io.en2 && io.y79+1.U < io.z) || (!io.en2 && io.y78+1.U < io.z) || (!io.en2 && io.y77+1.U < io.z) || (!io.en2 && io.y76+1.U < io.z) || (!io.en2 && io.y75+1.U < io.z) || (!io.en2 && io.y74+1.U < io.z) || (!io.en2 && io.y73+1.U < io.z) || (!io.en2 && io.y72+1.U < io.z) || (!io.en2 && io.y71+1.U < io.z) ||
		(!io.en2 && io.y90+1.U < io.z) || (!io.en2 && io.y89+1.U < io.z) || (!io.en2 && io.y88+1.U < io.z) || (!io.en2 && io.y87+1.U < io.z) || (!io.en2 && io.y86+1.U < io.z) || (!io.en2 && io.y85+1.U < io.z) || (!io.en2 && io.y84+1.U < io.z) || (!io.en2 && io.y83+1.U < io.z) || (!io.en2 && io.y82+1.U < io.z) || (!io.en2 && io.y81+1.U < io.z) ||
		(!io.en2 && io.y100+1.U < io.z) || (!io.en2 && io.y99+1.U < io.z) || (!io.en2 && io.y98+1.U < io.z) || (!io.en2 && io.y97+1.U < io.z) || (!io.en2 && io.y96+1.U < io.z) || (!io.en2 && io.y95+1.U < io.z) || (!io.en2 && io.y94+1.U < io.z) || (!io.en2 && io.y93+1.U < io.z) || (!io.en2 && io.y92+1.U < io.z) || (!io.en2 && io.y91+1.U < io.z)
		)
		{
			io.u := io.x
			res := io.z - io.x
		}
	}
	assert(res > 2.U)
}

class Example111 extends Module { 
	val io = IO(new Bundle {
		val x = Input(UInt(8.W)) 
		val y1 = Input(UInt(8.W)) 
		val y2 = Input(UInt(8.W)) 
		val y3 = Input(UInt(8.W)) 
		val y4 = Input(UInt(8.W)) 
		val y5 = Input(UInt(8.W)) 
		val y6 = Input(UInt(8.W)) 
		val y7 = Input(UInt(8.W)) 
		val y8 = Input(UInt(8.W)) 
		val y9 = Input(UInt(8.W)) 
		val y10 = Input(UInt(8.W)) 
		val y11 = Input(UInt(8.W)) 
		val y12 = Input(UInt(8.W)) 
		val y13 = Input(UInt(8.W)) 
		val y14 = Input(UInt(8.W)) 
		val y15 = Input(UInt(8.W)) 
		val y16 = Input(UInt(8.W)) 
		val y17 = Input(UInt(8.W)) 
		val y18 = Input(UInt(8.W)) 
		val y19 = Input(UInt(8.W)) 
		val y20 = Input(UInt(8.W)) 
		val y21 = Input(UInt(8.W)) 
		val y22 = Input(UInt(8.W)) 
		val y23 = Input(UInt(8.W)) 
		val y24 = Input(UInt(8.W)) 
		val y25 = Input(UInt(8.W)) 
		val y26 = Input(UInt(8.W)) 
		val y27 = Input(UInt(8.W)) 
		val y28 = Input(UInt(8.W)) 
		val y29 = Input(UInt(8.W)) 
		val y30 = Input(UInt(8.W)) 
		val y31 = Input(UInt(8.W)) 
		val y32 = Input(UInt(8.W)) 
		val y33 = Input(UInt(8.W)) 
		val y34 = Input(UInt(8.W)) 
		val y35 = Input(UInt(8.W)) 
		val y36 = Input(UInt(8.W)) 
		val y37 = Input(UInt(8.W)) 
		val y38 = Input(UInt(8.W)) 
		val y39 = Input(UInt(8.W)) 
		val y40 = Input(UInt(8.W)) 
		val y41 = Input(UInt(8.W)) 
		val y42 = Input(UInt(8.W)) 
		val y43 = Input(UInt(8.W)) 
		val y44 = Input(UInt(8.W)) 
		val y45 = Input(UInt(8.W)) 
		val y46 = Input(UInt(8.W)) 
		val y47 = Input(UInt(8.W)) 
		val y48 = Input(UInt(8.W)) 
		val y49 = Input(UInt(8.W)) 
		val y50 = Input(UInt(8.W))

		val y51 = Input(UInt(8.W)) 
		val y52 = Input(UInt(8.W)) 
		val y53 = Input(UInt(8.W)) 
		val y54 = Input(UInt(8.W)) 
		val y55 = Input(UInt(8.W)) 
		val y56 = Input(UInt(8.W)) 
		val y57 = Input(UInt(8.W)) 
		val y58 = Input(UInt(8.W)) 
		val y59 = Input(UInt(8.W)) 
		val y60 = Input(UInt(8.W)) 
		val y61 = Input(UInt(8.W)) 
		val y62 = Input(UInt(8.W)) 
		val y63 = Input(UInt(8.W)) 
		val y64 = Input(UInt(8.W)) 
		val y65 = Input(UInt(8.W)) 
		val y66 = Input(UInt(8.W)) 
		val y67 = Input(UInt(8.W)) 
		val y68 = Input(UInt(8.W)) 
		val y69 = Input(UInt(8.W)) 
		val y70 = Input(UInt(8.W)) 
		val y71 = Input(UInt(8.W)) 
		val y72 = Input(UInt(8.W)) 
		val y73 = Input(UInt(8.W)) 
		val y74 = Input(UInt(8.W)) 
		val y75 = Input(UInt(8.W)) 
		val y76 = Input(UInt(8.W)) 
		val y77 = Input(UInt(8.W)) 
		val y78 = Input(UInt(8.W)) 
		val y79 = Input(UInt(8.W)) 
		val y80 = Input(UInt(8.W)) 
		val y81 = Input(UInt(8.W)) 
		val y82 = Input(UInt(8.W)) 
		val y83 = Input(UInt(8.W)) 
		val y84 = Input(UInt(8.W)) 
		val y85 = Input(UInt(8.W)) 
		val y86 = Input(UInt(8.W)) 
		val y87 = Input(UInt(8.W)) 
		val y88 = Input(UInt(8.W)) 
		val y89 = Input(UInt(8.W)) 
		val y90 = Input(UInt(8.W)) 
		val y91 = Input(UInt(8.W)) 
		val y92 = Input(UInt(8.W)) 
		val y93 = Input(UInt(8.W)) 
		val y94 = Input(UInt(8.W)) 
		val y95 = Input(UInt(8.W)) 
		val y96 = Input(UInt(8.W)) 
		val y97 = Input(UInt(8.W)) 
		val y98 = Input(UInt(8.W)) 
		val y99 = Input(UInt(8.W)) 
		val y100 = Input(UInt(8.W)) 

		val en1 = Input(Bool())
		val en2 = Input(Bool())
		val z = Input(UInt(8.W)) 
		val u = Output(UInt(8.W))
		val v = Output(UInt(8.W))
	})
	val a = io.en1 && io.en2
	val res = Wire(UInt(8.W))

	io.u := 0.U
	io.v := 0.U
	res := 3.U
	
	when(a)
	{
		io.v := io.y1
	}
	when(
	(!io.en1 && io.x+1.U < io.y50) || (!io.en1 && io.x+1.U < io.y49) || (!io.en1 && io.x+1.U < io.y48) || (!io.en1 && io.x+1.U < io.y47) || (!io.en1 && io.x+1.U < io.y46) || (!io.en1 && io.x+1.U < io.y45) || (!io.en1 && io.x+1.U < io.y44) || (!io.en1 && io.x+1.U < io.y43) || (!io.en1 && io.x+1.U < io.y42) || (!io.en1 && io.x+1.U < io.y41) ||
	(!io.en1 && io.x+1.U < io.y40) || (!io.en1 && io.x+1.U < io.y39) || (!io.en1 && io.x+1.U < io.y38) || (!io.en1 && io.x+1.U < io.y37) || (!io.en1 && io.x+1.U < io.y36) || (!io.en1 && io.x+1.U < io.y35) || (!io.en1 && io.x+1.U < io.y34) || (!io.en1 && io.x+1.U < io.y33) || (!io.en1 && io.x+1.U < io.y32) || (!io.en1 && io.x+1.U < io.y31) ||
	(!io.en1 && io.x+1.U < io.y30) || (!io.en1 && io.x+1.U < io.y29) || (!io.en1 && io.x+1.U < io.y28) || (!io.en1 && io.x+1.U < io.y27) || (!io.en1 && io.x+1.U < io.y26) || (!io.en1 && io.x+1.U < io.y25) || (!io.en1 && io.x+1.U < io.y24) || (!io.en1 && io.x+1.U < io.y23) || (!io.en1 && io.x+1.U < io.y22) || (!io.en1 && io.x+1.U < io.y21) ||
	(!io.en1 && io.x+1.U < io.y20) || (!io.en1 && io.x+1.U < io.y19) || (!io.en1 && io.x+1.U < io.y18) || (!io.en1 && io.x+1.U < io.y17) || (!io.en1 && io.x+1.U < io.y16) || (!io.en1 && io.x+1.U < io.y15) || (!io.en1 && io.x+1.U < io.y14) || (!io.en1 && io.x+1.U < io.y13) || (!io.en1 && io.x+1.U < io.y12) || (!io.en1 && io.x+1.U < io.y11) ||
	(!io.en1 && io.x+1.U < io.y10) || (!io.en1 && io.x+1.U < io.y9) || (!io.en1 && io.x+1.U < io.y8) || (!io.en1 && io.x+1.U < io.y7) || (!io.en1 && io.x+1.U < io.y6) || (!io.en1 && io.x+1.U < io.y5) || (!io.en1 && io.x+1.U < io.y4) || (!io.en1 && io.x+1.U < io.y3) || (!io.en1 && io.x+1.U < io.y2) || (io.en1 && io.x < io.y1) ||
	(!io.en1 && io.x+1.U < io.y60) || (!io.en1 && io.x+1.U < io.y59) || (!io.en1 && io.x+1.U < io.y58) || (!io.en1 && io.x+1.U < io.y57) || (!io.en1 && io.x+1.U < io.y56) || (!io.en1 && io.x+1.U < io.y55) || (!io.en1 && io.x+1.U < io.y54) ||(!io.en1 && io.x+1.U < io.y53) || (!io.en1 && io.x+1.U < io.y52) || (!io.en1 && io.x+1.U < io.y51) ||
	(!io.en1 && io.x+1.U < io.y70) || (!io.en1 && io.x+1.U < io.y69) || (!io.en1 && io.x+1.U < io.y68) || (!io.en1 && io.x+1.U < io.y67) || (!io.en1 && io.x+1.U < io.y66) || (!io.en1 && io.x+1.U < io.y65) || (!io.en1 && io.x+1.U < io.y64) || (!io.en1 && io.x+1.U < io.y63) || (!io.en1 && io.x+1.U < io.y62) || (!io.en1 && io.x+1.U < io.y61) ||
	(!io.en1 && io.x+1.U < io.y80) || (!io.en1 && io.x+1.U < io.y79) || (!io.en1 && io.x+1.U < io.y78) || (!io.en1 && io.x+1.U < io.y77) || (!io.en1 && io.x+1.U < io.y76) || (!io.en1 && io.x+1.U < io.y75) || (!io.en1 && io.x+1.U < io.y74) || (!io.en1 && io.x+1.U < io.y73) || (!io.en1 && io.x+1.U < io.y72) || (!io.en1 && io.x+1.U < io.y71) ||
	(!io.en1 && io.x+1.U < io.y90) || (!io.en1 && io.x+1.U < io.y89) || (!io.en1 && io.x+1.U < io.y88) || (!io.en1 && io.x+1.U < io.y87) || (!io.en1 && io.x+1.U < io.y86) || (!io.en1 && io.x+1.U < io.y85) || (!io.en1 && io.x+1.U < io.y84) || (!io.en1 && io.x+1.U < io.y83) || (!io.en1 && io.x+1.U < io.y82) || (!io.en1 && io.x+1.U < io.y81) ||
	(!io.en1 && io.x+1.U < io.y100) || (!io.en1 && io.x+1.U < io.y99) || (!io.en1 && io.x+1.U < io.y98) || (!io.en1 && io.x+1.U < io.y97) || (!io.en1 && io.x+1.U < io.y96) || (!io.en1 && io.x+1.U < io.y95) || (!io.en1 && io.x+1.U < io.y94) || (!io.en1 && io.x+1.U < io.y93) || (!io.en1 && io.x+1.U < io.y92) || (!io.en1 && io.x+1.U < io.y91)
	)
	{
		when(
		(!io.en2 && io.y50+1.U < io.z) || (!io.en2 && io.y49+1.U < io.z) || (!io.en2 && io.y48+1.U < io.z) || (!io.en2 && io.y47+1.U < io.z) || (!io.en2 && io.y46+1.U < io.z) || (!io.en2 && io.y45+1.U < io.z) || (!io.en2 && io.y44+1.U < io.z) || (!io.en2 && io.y43+1.U < io.z) || (!io.en2 && io.y42+1.U < io.z) || (!io.en2 && io.y41+1.U < io.z) ||
		(!io.en2 && io.y40+1.U < io.z) || (!io.en2 && io.y39+1.U < io.z) || (!io.en2 && io.y38+1.U < io.z) || (!io.en2 && io.y37+1.U < io.z) || (!io.en2 && io.y36+1.U < io.z) || (!io.en2 && io.y35+1.U < io.z) || (!io.en2 && io.y34+1.U < io.z) || (!io.en2 && io.y33+1.U < io.z) || (!io.en2 && io.y32+1.U < io.z) || (!io.en2 && io.y31+1.U < io.z) ||
		(!io.en2 && io.y30+1.U < io.z) || (!io.en2 && io.y29+1.U < io.z) || (!io.en2 && io.y28+1.U < io.z) || (!io.en2 && io.y27+1.U < io.z) || (!io.en2 && io.y26+1.U < io.z) || (!io.en2 && io.y25+1.U < io.z) || (!io.en2 && io.y24+1.U < io.z) || (!io.en2 && io.y23+1.U < io.z) || (!io.en2 && io.y22+1.U < io.z) || (!io.en2 && io.y21+1.U < io.z) ||
		(!io.en2 && io.y20+1.U < io.z) || (!io.en2 && io.y19+1.U < io.z) || (!io.en2 && io.y18+1.U < io.z) || (!io.en2 && io.y17+1.U < io.z) || (!io.en2 && io.y16+1.U < io.z) || (!io.en2 && io.y15+1.U < io.z) || (!io.en2 && io.y14+1.U < io.z) || (!io.en2 && io.y13+1.U < io.z) || (!io.en2 && io.y12+1.U < io.z) || (!io.en2 && io.y11+1.U < io.z) ||
		(!io.en2 && io.y10+1.U < io.z) || (!io.en2 && io.y9+1.U < io.z) || (!io.en2 && io.y8+1.U < io.z) || (!io.en2 && io.y7+1.U < io.z) || (!io.en2 && io.y6+1.U < io.z) || (!io.en2 && io.y5+1.U < io.z) || (!io.en2 && io.y4+1.U < io.z) || (!io.en2 && io.y3+1.U < io.z) || (!io.en2 && io.y2+1.U < io.z) || (io.en2 && io.y1 < io.z) ||
		(!io.en2 && io.y60+1.U < io.z) || (!io.en2 && io.y59+1.U < io.z) || (!io.en2 && io.y58+1.U < io.z) || (!io.en2 && io.y57+1.U < io.z) || (!io.en2 && io.y56+1.U < io.z) || (!io.en2 && io.y55+1.U < io.z) || (!io.en2 && io.y54+1.U < io.z) || (!io.en2 && io.y53+1.U < io.z) || (!io.en2 && io.y52+1.U < io.z) || (!io.en2 && io.y51+1.U < io.z) ||
		(!io.en2 && io.y70+1.U < io.z) || (!io.en2 && io.y69+1.U < io.z) || (!io.en2 && io.y68+1.U < io.z) || (!io.en2 && io.y67+1.U < io.z) || (!io.en2 && io.y66+1.U < io.z) || (!io.en2 && io.y65+1.U < io.z) || (!io.en2 && io.y64+1.U < io.z) || (!io.en2 && io.y63+1.U < io.z) || (!io.en2 && io.y62+1.U < io.z) || (!io.en2 && io.y61+1.U < io.z) ||
		(!io.en2 && io.y80+1.U < io.z) || (!io.en2 && io.y79+1.U < io.z) || (!io.en2 && io.y78+1.U < io.z) || (!io.en2 && io.y77+1.U < io.z) || (!io.en2 && io.y76+1.U < io.z) || (!io.en2 && io.y75+1.U < io.z) || (!io.en2 && io.y74+1.U < io.z) || (!io.en2 && io.y73+1.U < io.z) || (!io.en2 && io.y72+1.U < io.z) || (!io.en2 && io.y71+1.U < io.z) ||
		(!io.en2 && io.y90+1.U < io.z) || (!io.en2 && io.y89+1.U < io.z) || (!io.en2 && io.y88+1.U < io.z) || (!io.en2 && io.y87+1.U < io.z) || (!io.en2 && io.y86+1.U < io.z) || (!io.en2 && io.y85+1.U < io.z) || (!io.en2 && io.y84+1.U < io.z) || (!io.en2 && io.y83+1.U < io.z) || (!io.en2 && io.y82+1.U < io.z) || (!io.en2 && io.y81+1.U < io.z) ||
		(!io.en2 && io.y100+1.U < io.z) || (!io.en2 && io.y99+1.U < io.z) || (!io.en2 && io.y98+1.U < io.z) || (!io.en2 && io.y97+1.U < io.z) || (!io.en2 && io.y96+1.U < io.z) || (!io.en2 && io.y95+1.U < io.z) || (!io.en2 && io.y94+1.U < io.z) || (!io.en2 && io.y93+1.U < io.z) || (!io.en2 && io.y92+1.U < io.z) || (!io.en2 && io.y91+1.U < io.z)
		)
		{
			io.u := io.x
			res := io.z - io.x
		}
	}
	assert(!(io.en1 && io.en2) || res > 2.U)
}

class Example112 extends Module { 
	val io = IO(new Bundle {
		val x = Input(UInt(8.W)) 
		val y1 = Input(UInt(8.W)) 
		val y2 = Input(UInt(8.W)) 
		val y3 = Input(UInt(8.W)) 
		val y4 = Input(UInt(8.W)) 
		val y5 = Input(UInt(8.W)) 
		val y6 = Input(UInt(8.W)) 
		val y7 = Input(UInt(8.W)) 
		val y8 = Input(UInt(8.W)) 
		val y9 = Input(UInt(8.W)) 
		val y10 = Input(UInt(8.W)) 
		val y11 = Input(UInt(8.W)) 
		val y12 = Input(UInt(8.W)) 
		val y13 = Input(UInt(8.W)) 
		val y14 = Input(UInt(8.W)) 
		val y15 = Input(UInt(8.W)) 
		val y16 = Input(UInt(8.W)) 
		val y17 = Input(UInt(8.W)) 
		val y18 = Input(UInt(8.W)) 
		val y19 = Input(UInt(8.W)) 
		val y20 = Input(UInt(8.W)) 
		val y21 = Input(UInt(8.W)) 
		val y22 = Input(UInt(8.W)) 
		val y23 = Input(UInt(8.W)) 
		val y24 = Input(UInt(8.W)) 
		val y25 = Input(UInt(8.W)) 
		val y26 = Input(UInt(8.W)) 
		val y27 = Input(UInt(8.W)) 
		val y28 = Input(UInt(8.W)) 
		val y29 = Input(UInt(8.W)) 
		val y30 = Input(UInt(8.W)) 
		val y31 = Input(UInt(8.W)) 
		val y32 = Input(UInt(8.W)) 
		val y33 = Input(UInt(8.W)) 
		val y34 = Input(UInt(8.W)) 
		val y35 = Input(UInt(8.W)) 
		val y36 = Input(UInt(8.W)) 
		val y37 = Input(UInt(8.W)) 
		val y38 = Input(UInt(8.W)) 
		val y39 = Input(UInt(8.W)) 
		val y40 = Input(UInt(8.W)) 
		val y41 = Input(UInt(8.W)) 
		val y42 = Input(UInt(8.W)) 
		val y43 = Input(UInt(8.W)) 
		val y44 = Input(UInt(8.W)) 
		val y45 = Input(UInt(8.W)) 
		val y46 = Input(UInt(8.W)) 
		val y47 = Input(UInt(8.W)) 
		val y48 = Input(UInt(8.W)) 
		val y49 = Input(UInt(8.W)) 
		val y50 = Input(UInt(8.W))

		val y51 = Input(UInt(8.W)) 
		val y52 = Input(UInt(8.W)) 
		val y53 = Input(UInt(8.W)) 
		val y54 = Input(UInt(8.W)) 
		val y55 = Input(UInt(8.W)) 
		val y56 = Input(UInt(8.W)) 
		val y57 = Input(UInt(8.W)) 
		val y58 = Input(UInt(8.W)) 
		val y59 = Input(UInt(8.W)) 
		val y60 = Input(UInt(8.W)) 
		val y61 = Input(UInt(8.W)) 
		val y62 = Input(UInt(8.W)) 
		val y63 = Input(UInt(8.W)) 
		val y64 = Input(UInt(8.W)) 
		val y65 = Input(UInt(8.W)) 
		val y66 = Input(UInt(8.W)) 
		val y67 = Input(UInt(8.W)) 
		val y68 = Input(UInt(8.W)) 
		val y69 = Input(UInt(8.W)) 
		val y70 = Input(UInt(8.W)) 
		val y71 = Input(UInt(8.W)) 
		val y72 = Input(UInt(8.W)) 
		val y73 = Input(UInt(8.W)) 
		val y74 = Input(UInt(8.W)) 
		val y75 = Input(UInt(8.W)) 
		val y76 = Input(UInt(8.W)) 
		val y77 = Input(UInt(8.W)) 
		val y78 = Input(UInt(8.W)) 
		val y79 = Input(UInt(8.W)) 
		val y80 = Input(UInt(8.W)) 
		val y81 = Input(UInt(8.W)) 
		val y82 = Input(UInt(8.W)) 
		val y83 = Input(UInt(8.W)) 
		val y84 = Input(UInt(8.W)) 
		val y85 = Input(UInt(8.W)) 
		val y86 = Input(UInt(8.W)) 
		val y87 = Input(UInt(8.W)) 
		val y88 = Input(UInt(8.W)) 
		val y89 = Input(UInt(8.W)) 
		val y90 = Input(UInt(8.W)) 
		val y91 = Input(UInt(8.W)) 
		val y92 = Input(UInt(8.W)) 
		val y93 = Input(UInt(8.W)) 
		val y94 = Input(UInt(8.W)) 
		val y95 = Input(UInt(8.W)) 
		val y96 = Input(UInt(8.W)) 
		val y97 = Input(UInt(8.W)) 
		val y98 = Input(UInt(8.W)) 
		val y99 = Input(UInt(8.W)) 
		val y100 = Input(UInt(8.W)) 

		val en1 = Input(Bool())
		val en2 = Input(Bool())
		val z = Input(UInt(8.W)) 
		val u = Output(UInt(8.W))
		val v = Output(UInt(8.W))
	})
	val a = io.en1 && io.en2
	val cnt = RegInit(0.U(8.W))
	val res = RegInit(0.U(8.W))


	io.u := 0.U
	io.v := 0.U
	
	when(a)
	{
		io.v := io.y1
	}
	when(cnt < 50.U)
	{
	when(
	(!io.en1 && io.x+1.U < io.y50) || (!io.en1 && io.x+1.U < io.y49) || (!io.en1 && io.x+1.U < io.y48) || (!io.en1 && io.x+1.U < io.y47) || (!io.en1 && io.x+1.U < io.y46) || (!io.en1 && io.x+1.U < io.y45) || (!io.en1 && io.x+1.U < io.y44) || (!io.en1 && io.x+1.U < io.y43) || (!io.en1 && io.x+1.U < io.y42) || (!io.en1 && (!io.en1 && io.x+1.U < io.y41) ||
	(!io.en1 && io.x+1.U < io.y40) || (!io.en1 && io.x+1.U < io.y39) || (!io.en1 && io.x+1.U < io.y38) || (!io.en1 && io.x+1.U < io.y37) || (!io.en1 && io.x+1.U < io.y36) || (!io.en1 && io.x+1.U < io.y35) || (!io.en1 && io.x+1.U < io.y34) || (!io.en1 && io.x+1.U < io.y33) || (!io.en1 && io.x+1.U < io.y32) || (!io.en1 && io.x+1.U < io.y31) ||
	(!io.en1 && io.x+1.U < io.y30) || (!io.en1 && io.x+1.U < io.y29) || (!io.en1 && io.x+1.U < io.y28) || (!io.en1 && io.x+1.U < io.y27) || (!io.en1 && io.x+1.U < io.y26) || (!io.en1 && io.x+1.U < io.y25) || (!io.en1 && io.x+1.U < io.y24) || io.x+1.U < io.y23) || (!io.en1 && io.x+1.U < io.y22) || (!io.en1 && io.x+1.U < io.y21) ||
	(!io.en1 && io.x+1.U < io.y20) || (!io.en1 && io.x+1.U < io.y19) || (!io.en1 && io.x+1.U < io.y18) || (!io.en1 && io.x+1.U < io.y17) || (!io.en1 && io.x+1.U < io.y16) || (!io.en1 && io.x+1.U < io.y15) || (!io.en1 && io.x+1.U < io.y14) || (!io.en1 && io.x+1.U < io.y13) || (!io.en1 && io.x+1.U < io.y12) || (!io.en1 && io.x+1.U < io.y11) ||
	(!io.en1 && io.x+1.U < io.y10) || (!io.en1 && io.x+1.U < io.y9) || (!io.en1 && io.x+1.U < io.y8) || (!io.en1 && io.x+1.U < io.y7) || (!io.en1 && io.x+1.U < io.y6) || (!io.en1 && io.x+1.U < io.y5) || (!io.en1 && io.x+1.U < io.y4) || (!io.en1 && io.x+1.U < io.y3) || (!io.en1 && io.x+1.U < io.y2) || (io.en1 && io.x < io.y1) ||
	(!io.en1 && io.x+1.U < io.y60) || (!io.en1 && io.x+1.U < io.y59) || (!io.en1 && io.x+1.U < io.y58) || (!io.en1 && io.x+1.U < io.y57) || (!io.en1 && io.x+1.U < io.y56) || (!io.en1 && io.x+1.U < io.y55) || (!io.en1 && io.x+1.U < io.y54) ||(!io.en1 && io.x+1.U < io.y53) || (!io.en1 && io.x+1.U < io.y52) || (!io.en1 && io.x+1.U < io.y51) ||
	(!io.en1 && io.x+1.U < io.y70) || (!io.en1 && io.x+1.U < io.y69) || (!io.en1 && io.x+1.U < io.y68) || (!io.en1 && io.x+1.U < io.y67) || (!io.en1 && io.x+1.U < io.y66) || (!io.en1 && io.x+1.U < io.y65) || (!io.en1 && io.x+1.U < io.y64) || (!io.en1 && io.x+1.U < io.y63) || (!io.en1 && io.x+1.U < io.y62) || (!io.en1 && io.x+1.U < io.y61) ||
	(!io.en1 && io.x+1.U < io.y80) || (!io.en1 && io.x+1.U < io.y79) || (!io.en1 && io.x+1.U < io.y78) || (!io.en1 && io.x+1.U < io.y77) || (!io.en1 && io.x+1.U < io.y76) || (!io.en1 && io.x+1.U < io.y75) || (!io.en1 && io.x+1.U < io.y74) || (!io.en1 && io.x+1.U < io.y73) || (!io.en1 && io.x+1.U < io.y72) || (!io.en1 && io.x+1.U < io.y71) ||
	(!io.en1 && io.x+1.U < io.y90) || (!io.en1 && io.x+1.U < io.y89) || (!io.en1 && io.x+1.U < io.y88) || (!io.en1 && io.x+1.U < io.y87) || (!io.en1 && io.x+1.U < io.y86) || (!io.en1 && io.x+1.U < io.y85) || (!io.en1 && io.x+1.U < io.y84) || (!io.en1 && io.x+1.U < io.y83) || (!io.en1 && io.x+1.U < io.y82) || (!io.en1 && io.x+1.U < io.y81) ||
	(!io.en1 && io.x+1.U < io.y100) || (!io.en1 && io.x+1.U < io.y99) || (!io.en1 && io.x+1.U < io.y98) || (!io.en1 && io.x+1.U < io.y97) || (!io.en1 && io.x+1.U < io.y96) || (!io.en1 && io.x+1.U < io.y95) || (!io.en1 && io.x+1.U < io.y94) || (!io.en1 && io.x+1.U < io.y93) || (!io.en1 && io.x+1.U < io.y92) || (!io.en1 && io.x+1.U < io.y91)
	)
	{
		when(
		(!io.en2 && io.y50+1.U < io.z) || (!io.en2 && io.y49+1.U < io.z) || (!io.en2 && io.y48+1.U < io.z) || (!io.en2 && io.y47+1.U < io.z) || (!io.en2 && io.y46+1.U < io.z) || (!io.en2 && io.y45+1.U < io.z) || (!io.en2 && io.y44+1.U < io.z) || (!io.en2 && io.y43+1.U < io.z) || (!io.en2 && io.y42+1.U < io.z) || (!io.en2 && io.y41+1.U < io.z) ||
		(!io.en2 && io.y40+1.U < io.z) || (!io.en2 && io.y39+1.U < io.z) || (!io.en2 && io.y38+1.U < io.z) || (!io.en2 && io.y37+1.U < io.z) || (!io.en2 && io.y36+1.U < io.z) || (!io.en2 && io.y35+1.U < io.z) || (!io.en2 && io.y34+1.U < io.z) || (!io.en2 && io.y33+1.U < io.z) || (!io.en2 && io.y32+1.U < io.z) || (!io.en2 && io.y31+1.U < io.z) ||
		(!io.en2 && io.y30+1.U < io.z) || (!io.en2 && io.y29+1.U < io.z) || (!io.en2 && io.y28+1.U < io.z) || (!io.en2 && io.y27+1.U < io.z) || (!io.en2 && io.y26+1.U < io.z) || (!io.en2 && io.y25+1.U < io.z) || (!io.en2 && io.y24+1.U < io.z) || (!io.en2 && io.y23+1.U < io.z) || (!io.en2 && io.y22+1.U < io.z) || (!io.en2 && io.y21+1.U < io.z) ||
		(!io.en2 && io.y20+1.U < io.z) || (!io.en2 && io.y19+1.U < io.z) || (!io.en2 && io.y18+1.U < io.z) || (!io.en2 && io.y17+1.U < io.z) || (!io.en2 && io.y16+1.U < io.z) || (!io.en2 && io.y15+1.U < io.z) || (!io.en2 && io.y14+1.U < io.z) || (!io.en2 && io.y13+1.U < io.z) || (!io.en2 && io.y12+1.U < io.z) || (!io.en2 && io.y11+1.U < io.z) ||
		(!io.en2 && io.y10+1.U < io.z) || (!io.en2 && io.y9+1.U < io.z) || (!io.en2 && io.y8+1.U < io.z) || (!io.en2 && io.y7+1.U < io.z) || (!io.en2 && io.y6+1.U < io.z) || (!io.en2 && io.y5+1.U < io.z) || (!io.en2 && io.y4+1.U < io.z) || (!io.en2 && io.y3+1.U < io.z) || (!io.en2 && io.y2+1.U < io.z) || (io.en2 && io.y1 < io.z) ||
		(!io.en2 && io.y60+1.U < io.z) || (!io.en2 && io.y59+1.U < io.z) || (!io.en2 && io.y58+1.U < io.z) || (!io.en2 && io.y57+1.U < io.z) || (!io.en2 && io.y56+1.U < io.z) || (!io.en2 && io.y55+1.U < io.z) || (!io.en2 && io.y54+1.U < io.z) || (!io.en2 && io.y53+1.U < io.z) || (!io.en2 && io.y52+1.U < io.z) || (!io.en2 && io.y51+1.U < io.z) ||
		(!io.en2 && io.y70+1.U < io.z) || (!io.en2 && io.y69+1.U < io.z) || (!io.en2 && io.y68+1.U < io.z) || (!io.en2 && io.y67+1.U < io.z) || (!io.en2 && io.y66+1.U < io.z) || (!io.en2 && io.y65+1.U < io.z) || (!io.en2 && io.y64+1.U < io.z) || (!io.en2 && io.y63+1.U < io.z) || (!io.en2 && io.y62+1.U < io.z) || (!io.en2 && io.y61+1.U < io.z) ||
		(!io.en2 && io.y80+1.U < io.z) || (!io.en2 && io.y79+1.U < io.z) || (!io.en2 && io.y78+1.U < io.z) || (!io.en2 && io.y77+1.U < io.z) || (!io.en2 && io.y76+1.U < io.z) || (!io.en2 && io.y75+1.U < io.z) || (!io.en2 && io.y74+1.U < io.z) || (!io.en2 && io.y73+1.U < io.z) || (!io.en2 && io.y72+1.U < io.z) || (!io.en2 && io.y71+1.U < io.z) ||
		(!io.en2 && io.y90+1.U < io.z) || (!io.en2 && io.y89+1.U < io.z) || (!io.en2 && io.y88+1.U < io.z) || (!io.en2 && io.y87+1.U < io.z) || (!io.en2 && io.y86+1.U < io.z) || (!io.en2 && io.y85+1.U < io.z) || (!io.en2 && io.y84+1.U < io.z) || (!io.en2 && io.y83+1.U < io.z) || (!io.en2 && io.y82+1.U < io.z) || (!io.en2 && io.y81+1.U < io.z) ||
		(!io.en2 && io.y100+1.U < io.z) || (!io.en2 && io.y99+1.U < io.z) || (!io.en2 && io.y98+1.U < io.z) || (!io.en2 && io.y97+1.U < io.z) || (!io.en2 && io.y96+1.U < io.z) || (!io.en2 && io.y95+1.U < io.z) || (!io.en2 && io.y94+1.U < io.z) || (!io.en2 && io.y93+1.U < io.z) || (!io.en2 && io.y92+1.U < io.z) || (!io.en2 && io.y91+1.U < io.z)
		)
			{
			io.u := io.x
			res := res + io.z - io.x
			}
		}
		cnt := cnt + 1.U
	}
	assert(!cnt === 50.U || res > 100.U)
}
