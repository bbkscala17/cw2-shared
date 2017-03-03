package bc

import vm.VirtualMachine

class Iadd(override val code: Byte) extends ByteCode {
  /**
    * Returns a new [[VirtualMachine]] after executing this bytecode operation.
    * vm.pop()._1 is the second element of the tuple returned
    *
    * @param vm the initial virtual machine
    * @return a new virtual machine
    */

  override def execute(vm: VirtualMachine): VirtualMachine = vm.push(vm.pop()._1 + vm.pop()._1)
}