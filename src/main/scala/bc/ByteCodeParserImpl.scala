package bc

import scala.collection.mutable.ListBuffer

class ByteCodeParserImpl extends ByteCodeParser {
  /**
    * Parses a vector of `Byte` into a vector of `ByteCode`.
    * Uses ByteCodeFactory to construct ByteCode objects from Byte
    *
    * You should use [[ByteCodeValues.bytecode]] to help translate
    * the individual `Byte`s into a corresponding [[ByteCode]].
    *
    * @param bc a vector of bytes representing bytecodes
    * @return a vector of `ByteCode` objects
    */
  override def parse(bc: Vector[Byte]): Vector[ByteCode] = {
    //TODO add a comment explaining what the code is doing, what the vars and why done this way
    val factory = new ByteCodeFactoryImpl
    var toReturn = new ListBuffer[ByteCode]

    var remainingBytes = bc
    while(remainingBytes.nonEmpty){
      val byte1 = remainingBytes(0)
      remainingBytes = remainingBytes.drop(1)
      if(byte1 == bytecode("iconst")){
        val byte2 = remainingBytes(0)
        remainingBytes = remainingBytes.drop(1)
        val obj = factory.make(byte1, byte2)
        toReturn += obj
      } else {
        val obj = factory.make(byte1)
        toReturn += obj
      }
    }
    toReturn.toVector
  }
}
