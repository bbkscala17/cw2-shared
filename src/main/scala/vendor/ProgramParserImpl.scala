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

    for (line <- lines) {
      var fields = line.split(" ")
      val name = fields(0)
      val ints = fields.filter(e => e.eq(Int))

      println("name", name)
      println("ints", ints.foreach(e => print(e, " ")))
//      val name = fields(0)
//
//      val x = fields.drop(0)
//      println(x)
//      println(x.map(l => l).toVector)
//      println(args)
//      val i = new Instruction(name, args)
//      println(i.toString)
    }
    val inst: Instruction = new Instruction("iconst", Vector(1,2,3))
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

object Tester extends App {
  val x = new ProgramParserImpl

  x.parse("programs/p03.vm")
}