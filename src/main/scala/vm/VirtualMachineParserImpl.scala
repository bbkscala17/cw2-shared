package vm
import bc.{ByteCode, ByteCodeParserImpl, ByteCodeValues, Iadd}
import com.sun.org.apache.bcel.internal.generic.InstructionList
import vendor.ProgramParserImpl

import scala.collection.mutable.ListBuffer
import scala.io.Source

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
    val instructionList: programParserImpl.InstructionList = programParserImpl.parse(file)

    var byteVectorBuffer = new ListBuffer[Byte]
    instructionList.foreach(i => {
      if(i.args.isEmpty) {
        byteVectorBuffer += bytecode(i.name)
      } else {
        byteVectorBuffer += bytecode(i.name)
        byteVectorBuffer += i.args(0).toByte
      }
    })

    byteCodeParserImpl.parse(byteVectorBuffer.toVector)
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

  }
}
