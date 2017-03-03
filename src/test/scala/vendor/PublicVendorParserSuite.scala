package vendor

import factory.VirtualMachineFactory
import org.scalatest.FunSuite

class PublicVendorParserSuite extends FunSuite {
  val vp = VirtualMachineFactory.vendorParser    

  test("[3] vendor parser should parse a program string correctly") {
    val insts = vp.parseString("iconst 4\niconst 5\niadd\nprint")
    assert(insts.length == 4)
  }

  test("[4] vendor parser should parse a program file to correct number of instructions") {
    val insts = vp.parse("programs/p03.vm")
    assert(insts.length == 20)
  }

  test("[5] vendor parser should parse a program file to correct names") {
    val insts = vp.parse("programs/p03.vm")
    val all = Vector("iconst", "iconst", "iswap", "iadd", "iconst", "iadd",
      "iconst", "isub", "iconst", "imul", "iconst", "idiv",
      "iconst", "irem", "ineg", "idec", "iinc", "idup", "print", "print")
    for (i <- insts.indices) {
      assert(insts(i).name == all(i))
    }
  }

  test("[6] vendor parser should parse a program file to correct args") {
    val insts = vp.parse("programs/p03.vm")
    val all = Vector(Vector(7), Vector(7), Vector(), Vector(), Vector(2), Vector(), Vector(4), Vector(1), Vector(), Vector(2), Vector(), Vector(1), Vector(), Vector(), Vector(), Vector(), Vector(), Vector(), Vector())
    for (i <- insts.indices) {
      assert(insts(i).args == all(i))
    }
  }

  // for(insn <- instructionList){
  //     println(insn.getClass)
  //     println(insn.toString)
  //   }
  //   println(instructionList.toVector.getClass)
}
