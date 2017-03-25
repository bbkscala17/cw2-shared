package vm
import bc.{ByteCode, ByteCodeParserImpl, ByteCodeValues, InvalidBytecodeException}
import vendor.{Instruction, ProgramParserImpl}

import scala.collection.mutable.ListBuffer

class VirtualMachineParserImpl extends VirtualMachineParser with ByteCodeValues{

  val programParserImpl = new ProgramParserImpl
  val byteCodeParserImpl = new ByteCodeParserImpl

  /**
    * Returns a vector of [[bc.ByteCode]].
    *
    * This method parses a file into a vector of bytecode objects.
    * Note, this method should throw a [[bc.InvalidBytecodeException]]
    * if it fails to parse a program file correctly.
    *
    * @param file the file containing a program
    * @return a vector of bytecodes
    */
  override def parse(file: String): Vector[ByteCode] = {
    //todo: diego ill write tests for this file?
    parseInstructionList(programParserImpl.parse(file))
  }

  /**
    * Returns a vector of [[bc.ByteCode]].
    *
    * This method parses a string into a vector of bytecode objects.
    * Note, this method should throw a [[bc.InvalidBytecodeException]]
    * if it fails to parse a program string correctly.
    *
    * @param str a string containing a program
    * @return a vector of bytecodes
    */
  override def parseString(str: String): Vector[ByteCode] = {
    parseInstructionList(programParserImpl.parseString(str))
  }

  private def parseInstructionList(instructionList: Vector[Instruction]): Vector[ByteCode]  ={
    var byteVectorBuffer = new ListBuffer[Byte]
    instructionList.foreach(i => {
      try {
        if(i.args.isEmpty) {
          byteVectorBuffer += bytecode(i.name)
        } else {
          byteVectorBuffer += bytecode(i.name)
          byteVectorBuffer += i.args(0).toByte
        }
      } catch {
        case nse: NoSuchElementException => throw new InvalidBytecodeException("invalid byte code exception at: virtual machine parser implementation")
        case e: Exception => "general error"
      }
    })

    byteCodeParserImpl.parse(byteVectorBuffer.toVector)
  }
}
