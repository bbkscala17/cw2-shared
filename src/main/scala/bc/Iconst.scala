package bc

import vm.VirtualMachine

class Iconst(NUM: Int) extends ByteCode {


  override val code: Byte = bytecode("iconst")

  /**
    * Returns a new [[VirtualMachine]] after executing this bytecode operation.
    *
    * @param vm the initial virtual machine
    * @return a new virtual machine
    */
  override def execute(vm: VirtualMachine): VirtualMachine = vm.push(NUM)
  override def toString: String = "iconst"
}
