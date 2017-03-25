package bc

import vm.{MachineUnderflowException, VirtualMachine}

class Iadd extends ByteCode {

  override val code: Byte = bytecode("iadd")
  /**
    * Returns a new [[VirtualMachine]] after executing this bytecode operation.
    * vm.pop()._1 is the second element of the tuple returned
    *
    * @param vm the initial virtual machine
    * @return a new virtual machine
    */

  override def execute(vm: VirtualMachine): VirtualMachine = {
    try {
      vm.push(vm.pop()._1 + vm.pop()._1)
    } catch {
      //todo: make sure throw the appropiate exception for each of the edge cases
      case e: Exception => throw new MachineUnderflowException(e.toString)
    }
  }

  override def toString: String = "iadd"
}