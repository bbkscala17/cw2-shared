package bc

import vm.VirtualMachine

class iconst extends ByteCode {
  override val code: Byte = _

  /**
    * Returns a new [[VirtualMachine]] after executing this bytecode operation.
    *
    * @param vm the initial virtual machine
    * @return a new virtual machine
    */
  override def execute(vm: VirtualMachine): VirtualMachine = {

  }
}
