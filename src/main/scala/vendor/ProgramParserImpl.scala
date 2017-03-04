package vendor
import scala.collection.mutable.ListBuffer
import scala.io.Source

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
    parseLines(Source.fromFile(file).getLines.toArray[String])
  }

  /**
    * Parses a string representation of a bytecode program
    * into an `InstructionList`.
    *
    * @param string the string to parse
    * @return an instruction list
    */
  override def parseString(string: String): InstructionList = {
    parseLines(string.split("\n"))
  }

  /**
    * Take each line of instructions (e.g. iconst 7) and break it down
    * into fields, containing name (iconst) and args (7)
    * Then take each field from each line, and make an Instruction from it
    * Build all the instructions into a mutable list buffer and convert this
    * to a vector to return
    *
    * @param lines the lines to be parsed
    * @return and InstructionList
    */
   private def parseLines(lines: Array[String]): InstructionList = {
    var instructionList = new ListBuffer[Instruction]
    for (line <- lines) {
      val fields = line.split(" ")
      val args = fields.drop(1).map(x => x.toInt).toVector
      instructionList += new Instruction(fields(0), args)
    }
    instructionList.toVector
  }

}