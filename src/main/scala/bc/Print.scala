package bc

import vm.VirtualMachine

class Print  extends ByteCode {


  override val code: Byte = bytecode("print")

  /**
    * Returns a new [[VirtualMachine]] after executing this bytecode operation.
    * vm.pop()._1 is the second element of the tuple returned
    *
    * @param vm the initial virtual machine
    * @return a new virtual machine
    */

  override def execute(vm: VirtualMachine): VirtualMachine = {
    println(vm.pop()._1)
    vm
  }

  override def toString: String = "print"
}