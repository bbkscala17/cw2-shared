package bc
import vm.VirtualMachine

/**
  * Created by diegoromero on 05/03/2017.
  */
class Iswap extends ByteCode {
  override val code: Byte = bytecode("iswap")

  /**
    * Returns a new [[VirtualMachine]] after executing this bytecode operation.
    *
    * @param vm the initial virtual machine
    * @return a new virtual machine
    */
  override def execute(vm: VirtualMachine): VirtualMachine = {
    val first: Int = vm.pop()._1
    val second: Int = vm.pop()._1
    vm.push(first)
    vm.push(second)
  }
}
