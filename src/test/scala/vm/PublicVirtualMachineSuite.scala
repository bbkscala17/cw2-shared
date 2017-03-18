package vm

import factory.VirtualMachineFactory
import org.scalatest.FunSuite

class PublicVirtualMachineSuite extends FunSuite {
  val vmp = VirtualMachineFactory.virtualMachineParser
  val bcp = VirtualMachineFactory.byteCodeParser
  val vm  = VirtualMachineFactory.virtualMachine

//  test("[10] a virtual machine should execute a program") {
//    val bc  = vmp.parse("programs/p05.vm")
//    val vm2 = vm.execute(bc)
//  }

  test("[2] iconst should work correctly") {
    val bc  = vmp.parseString("iconst 1")
    val (bc2, vm2) = vm.executeOne(bc)
    assert(vm2.state.head == 1)
  }

  test("[2] icston should be able to store multiple values if called more than once") {
    val bc = vmp.parseString("iconst 1\niconst 3\niconst 4\niconst 7")
    var next = vm.executeOne(bc)
    assert(next._2.state.head == 1)
    next = next._2.executeOne(next._1)
    assert(next._2.state.head == 3)
  }

  test("[2] iadd should work correctly") {
    val bc  = vmp.parseString("iconst 1\niconst 2\niadd")
    var next = vm.executeOne(bc)
    assert(next._2.state.head == 1)
    next = next._2.executeOne(next._1)
    assert(next._2.state.head == 2)
    next = next._2.executeOne(next._1)
    assert(next._2.state.head == 3)
  }

  test("[2] iadd should work on big numbers") {
    val bc  = vmp.parseString("iconst 10\niconst 20\niadd\niconst 10\niadd")
    var next = vm.executeOne(bc)
    assert(next._2.state.head == 10)
    next = next._2.executeOne(next._1)
    assert(next._2.state.head == 20)
    next = next._2.executeOne(next._1)
    assert(next._2.state.head == 30)
    next = next._2.executeOne(next._1)
    next = next._2.executeOne(next._1)
    assert(next._2.state.head == 40)
  }

  test("[2] iadd should work importing form a file too") {
    val bc = vmp.parse("programs/p01.vm")
    var next = vm.executeOne(bc)
    assert(next._2.state.head == 4)
    next = next._2.executeOne(next._1)
    assert(next._2.state.head == 5)
    next = next._2.executeOne(next._1)
    assert(next._2.state.head == 9)
    next = next._2.executeOne(next._1)
  }

  test("[2] isub should work correctly") {
    val bc  = vmp.parseString("iconst 1\niconst 2\nisub")
    var next = vm.executeOne(bc)
    assert(next._2.state.head == 1)
    next = next._2.executeOne(next._1)
    assert(next._2.state.head == 2)
    next = next._2.executeOne(next._1)
    assert(next._2.state.head == 1)
  }

  test("[2] other instructions should work importing form a file too") {
    val bc = vmp.parse("programs/p02-bad-stack.vm")
    var next = vm.executeOne(bc)
    1 to 20 foreach { _ => {
      next = next._2.executeOne(next._1)
    }}
  }

  test("[2] iswap should work correctly") {
    val bc  = vmp.parseString("iconst 1\niconst 2\niswap")
    var next = vm.executeOne(bc)
    assert(next._2.state.head == 1)
    next = next._2.executeOne(next._1)
    assert(next._2.state.head == 2)
    next = next._2.executeOne(next._1)
    assert(next._2.state(0) == 1)
    assert(next._2.state(1) == 2)
  }
}
