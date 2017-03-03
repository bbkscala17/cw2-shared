package vendor

/**
  * Created by diegoromero on 03/03/2017.
  */
class ProgramParserImpl extends ProgramParser {

  /**
    * Parses a file representation of a bytecode program
    * into an `InstructionList`.
    *
    * @param file the file to parse
    * @return an instruction list
    */
  override def parse(file: String): InstructionList = {

    new Vector[Instruction]
  }

  /**
    * Parses a string representation of a bytecode program
    * into an `InstructionList`.
    *
    * @param string the string to parse
    * @return an instruction list
    */
  override def parseString(string: String): InstructionList = {
    new Vector[Instruction]
  }
}

object Driver extends App{
  val programParser = new ProgramParserImpl

  println(programParser.parse("diego"))
}