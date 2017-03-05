package bc

class ByteCodeFactoryImpl extends ByteCodeFactory{
  /**
    * Returns a [[ByteCode]].
    *
    * This method creates a new [[ByteCode]] object given the `byte`
    * that corresponds to the bytecode (see [[ByteCodeValues]]. If
    * the bytecode requires arguments then an optional integer
    * argument is provided.
    *
    * This method should throw an [[InvalidBytecodeException]] if the
    * given bytecode value is unknown.
    *
    * @param byte the byte code of a bytecode
    * @param args an optional integer argument (depends on bytecode)
    * @return a new bytecode object
    */
  override def make(byte: Byte, args: Int*): ByteCode = {
    byte match {
      case 1 => new Iconst(args(0))
      case 2 => new Iadd
      case 3 => new Isub
      case 4 => new Imul
      case 5 => new Idiv
      case 6 => new Irem
      case 7 => new Ineg
      case 8 => new Iinc
      case 9 => new Idec
      case 10 => new Idup
      case 11 => new Iswap
      case 12 => new Print
      case _ => throw new InvalidBytecodeException("failed")
    }
  }
}
