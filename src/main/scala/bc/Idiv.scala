package bc
import vm.{MachineUnderflowException, VirtualMachine}

/**
  * Created by diegoromero on 05/03/2017.
  */
class Idiv extends ByteCode {
  override val code: Byte = bytecode("idiv")

  /**
    * Returns a new [[VirtualMachine]] after executing this bytecode operation.
    *
    * @param vm the initial virtual machine
    * @return a new virtual machine
    */
  override def execute(vm: VirtualMachine): VirtualMachine = {
    try {
      vm.push(vm.pop()._1 / vm.pop()._1)
    } catch {
      case e: Exception => throw new MachineUnderflowException(e.toString)
    }
  }
  override def toString: String = "idiv"
}
