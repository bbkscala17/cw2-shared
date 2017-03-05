package bc

class ByteCodeParserImpl extends ByteCodeParser{
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
  override def parse(bc: Vector[Byte]): Vector[ByteCode] = ???
}
