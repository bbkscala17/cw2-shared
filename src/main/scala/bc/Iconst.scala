package bc

import vm.VirtualMachine

class Iconst(override val code: Byte) extends ByteCode {

  /**
    * Returns a new [[VirtualMachine]] after executing this bytecode operation.
    *
    * @param vm the initial virtual machine
    * @return a new virtual machine
    */
  override def execute(vm: VirtualMachine): VirtualMachine = vm.push(code)
}
