package factory

import bc._
import sun.jvm.hotspot.jdi.VirtualMachineImpl
import vendor.{ProgramParser, ProgramParserImpl}
import vm.{VirtualMachine, VirtualMachineParser, VirtualMachineParserImpl}

/**
  * The `VirtualMachineFactory` follows the *factory pattern*. It provides
  * methods for each of the important parts in this assignment. You must
  * implement each method such that it returns an object of the correct type.
  */
object VirtualMachineFactory {
  // TODO
  def byteCodeFactory: ByteCodeFactory = new ByteCodeFactoryImpl

  // TODO
  def vendorParser: ProgramParser = new ProgramParserImpl

  // TODO
  def byteCodeParser: ByteCodeParser = new ByteCodeParserImpl

  // TODO
  def virtualMachineParser: VirtualMachineParser = new VirtualMachineParserImpl

  // TODO
  def virtualMachine: VirtualMachine = ???
}
