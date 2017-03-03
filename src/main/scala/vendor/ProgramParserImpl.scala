package vendor
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
    val lines = Source.fromFile(file).getLines
    val instructionList = Vector()
    for (line <- lines) {
      val fields = line.split(" ")
      if (fields.nonEmpty) {
        println(line)
      }
    }
    println(instructionList)
    val vector: Vector[Int] = Vector(1, 2, 3)
    val inst: Instruction = new Instruction("iconst", vector)
    Vector(inst, inst)
  }

  /**
    * Parses a string representation of a bytecode program
    * into an `InstructionList`.
    *
    * @param string the string to parse
    * @return an instruction list
    */
  override def parseString(string: String): InstructionList = Vector()
}