package example

import chisel3._
import chiseltest._
import chiseltest.formal._
import org.scalatest.flatspec.AnyFlatSpec

class ExampleFormalSpec extends AnyFlatSpec with Formal with ChiselScalatestTester {
    behavior of "Example"
    it should "pass" in {
        verify(new Example(), Seq(BoundedCheck(20), Z3EngineAnnotation))
    }
}

class Example2FormalSpec extends AnyFlatSpec with Formal with ChiselScalatestTester {
    behavior of "Example"
    it should "pass" in {
        verify(new Example2(), Seq(BoundedCheck(20), Z3EngineAnnotation))
    }
}

class Example3FormalSpec extends AnyFlatSpec with Formal with ChiselScalatestTester {
    behavior of "Example3"
    it should "pass" in {
        verify(new Example3(), Seq(BoundedCheck(50), Z3EngineAnnotation))
    }
}

class Example4FormalSpec extends AnyFlatSpec with Formal with ChiselScalatestTester {
    behavior of "Example4"
    it should "pass" in {
        verify(new Example4(), Seq(BoundedCheck(20), Z3EngineAnnotation))
    }
}


class Example107FormalSpec extends AnyFlatSpec with Formal with ChiselScalatestTester {
    behavior of "Example107"
    it should "pass" in {
        verify(new Example107(), Seq(BoundedCheck(50), Z3EngineAnnotation))
    }
}

class Example108FormalSpec extends AnyFlatSpec with Formal with ChiselScalatestTester {
    behavior of "Example108"
    it should "pass" in {
        verify(new Example108(), Seq(BoundedCheck(50), Z3EngineAnnotation))
    }
}

class Example109FormalSpec extends AnyFlatSpec with Formal with ChiselScalatestTester {
    behavior of "Example109"
    it should "pass" in {
        verify(new Example109(), Seq(BoundedCheck(1), Z3EngineAnnotation))
    }
}

class Example110FormalSpec extends AnyFlatSpec with Formal with ChiselScalatestTester {
    behavior of "Example110"
    it should "pass" in {
        verify(new Example110(), Seq(BoundedCheck(1), Z3EngineAnnotation))
    }
}

class Example111FormalSpec extends AnyFlatSpec with Formal with ChiselScalatestTester {
    behavior of "Example111"
    it should "pass" in {
        verify(new Example111(), Seq(BoundedCheck(1), Z3EngineAnnotation))
    }
}

class Example112FormalSpec extends AnyFlatSpec with Formal with ChiselScalatestTester {
    behavior of "Example112"
    it should "pass" in {
        verify(new Example112(), Seq(BoundedCheck(50), Z3EngineAnnotation))
    }
}
