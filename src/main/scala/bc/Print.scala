package bc

import vm.VirtualMachine

class Print(override val code: Byte)  extends ByteCode {
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
}