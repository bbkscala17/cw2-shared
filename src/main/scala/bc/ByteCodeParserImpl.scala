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
    //vector(2) coming in for iadd
    val factory = new ByteCodeFactoryImpl
    var toReturn = new ListBuffer[ByteCode]
    for (x <- 0 to bc.length - 1) {
      if (bc(x) != bytecode("iconst") && (bc.length ==1 || (x > 0 && bc(x - 1) != bytecode("iconst")))) {
        //current one and previous one are not inconst
        toReturn += factory.make(bc(x))
      } else if (bc(x) == bytecode("iconst") && x + 1 < bc.length) {
        toReturn += factory.make(bc(x), bc(x + 1))
      }
    }
    toReturn.toVector
  }
}
