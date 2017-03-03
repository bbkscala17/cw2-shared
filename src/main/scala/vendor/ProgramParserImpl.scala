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
    import scala.io.Source
    val lines = Source.fromFile(file).getLines
    var instructionList = new ListBuffer[Instruction]
    for (line <- lines) {
      val fields = line.split(" ")
      val args = fields.filter(field => fields.indexOf(field) > 0).map(x => x.toInt).toVector
      instructionList += new Instruction(fields(0), args)
    val vector: Vector[Int] = Vector(1, 2, 3)
    val inst: Instruction = new Instruction("iconst", vector)
    for(insn <- instructionList){
      println(insn.getClass)
      println(insn.toString)
    }
    println(instructionList.toVector.getClass)
    instructionList.toVector
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

object Tester extends App {
  val x = new ProgramParserImpl

  x.parse("programs/p03.vm")
}