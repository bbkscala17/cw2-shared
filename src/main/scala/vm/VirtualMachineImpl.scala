package vm
import bc.ByteCode

import scala.collection.mutable

//TODO machineunderflowexception


/**
  * Represents a stack-based virtual machine.
  *
  * An implementation of a virtual machine is capable of executing
  * a vector of [[bc.ByteCode]] values. This is where the command
  * pattern comes into play! That is, we defer the execution of
  * each bytecode until it is executed by the virtual machine.
  *
  */

class VirtualMachineImpl extends VirtualMachine {

  private var internalStack: Vector[Int] = Vector()
  /**
    * Executes a vector of bytecodes.
    *
    * Note, that this is an "immutable" object. That is, it
    * will return a new virtual machine after executing each
    * of the bytecode objects in the vector.
    *
    * @param bc a vector of bytecodes
    * @return a new virtual machine
    */
  override def execute(bc: Vector[ByteCode]): VirtualMachine = {
    bc.foreach(b => println(b.toString))
    val toExecute = bc.take(1) // take(1) means take 1 item not take item at positon 1
    println("item to execute is " + toExecute(0).toString())
    toExecute(0).execute(this)
  }

  /**
    * Executes the next bytecode in the vector of bytecodes.
    *
    * This method only executes a single byte code in the vector of bytecodes.
    * It returns a tuple of the new vector of bytecodes (with the executed
    * bytecode removed) and the new virtual machine.
    *
    * You may assume that `bc` contains at least 1 bytecode.
    *
    * @param bc the vector of bytecodes
    * @return a tuple of a new vector of bytecodes and virtual machine
    */
  override def executeOne(bc: Vector[ByteCode]): (Vector[ByteCode], VirtualMachine) = {
    val newVm = bc(0).execute(this)
    (bc.drop(1), newVm)
  }

  /**
    * Pushes an integer value onto the virtual machine stack.
    *
    * @param value the integer to push
    * @return a new virtual machine with the integer `value` pushed
    */
  override def push(value: Int): VirtualMachine = {
    internalStack = Vector(value) ++ internalStack
    println("internal stack now is: ", internalStack)
    this
  }

  /**
    * Pops an integer value off of the virtual machine stack.
    *
    * @return (i, vm), where i is the integer popped and vm is the
    *         new virtual machine
    */
  override def pop(): (Int, VirtualMachine) = {
    val firstStackValue = internalStack(0)
    // this will take all the elements of the internal stack except
    // the first one and assign them back to internal stack
    internalStack = internalStack.takeRight(internalStack.length-1)
    println("internal stack now is: ", internalStack)
    (firstStackValue, this)
  }

  /**
    * Returns the state of the virtual machine stack.
    *
    * The value at index 0 is the value on the top of the stack.
    *
    * @return the state of the stack
    */
  override def state: Vector[Int] = {
    internalStack
  }
}
