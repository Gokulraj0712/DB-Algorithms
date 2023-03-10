/*
 * Copyright 2014, Michael T. Goodrich, Roberto Tamassia, Michael H. Goldwasser
 *
 * Developed for use with the book:
 *
 *    Data Structures and Algorithms in Java, Sixth Edition
 *    Michael T. Goodrich, Roberto Tamassia, and Michael H. Goldwasser
 *    John Wiley & Sons, 2014
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.exercise2.Gokulraj.Venugopal;


import java.util.Stack;

/**
 * Realization of a stack as an adaptation of a SinglyLinkedList.
 * All operations are performed in constant time.
 * Adapter Pattern
 * The adapter design pattern applies to any context where we effectively want to
 * modify an existing class so that its methods match those of a related, but different,
 * class or interface. One general way to apply the adapter pattern is to define a new
 * class in such a way that it contains an instance of the existing class as a hidden
 * field, and then to implement each method of the new class using methods of this
 * hidden instance variable. By applying the adapter pattern in this way, we have
 * created a new class that performs some of the same functions as an existing class,
 * but repackaged in a more convenient way.
 *
 * @author Michael T. Goodrich
 * @author Roberto Tamassia
 * @author Michael H. Goldwasser
 * @see SinglyLinkedList
 */
public class LinkedStack<E> extends Stack<E> {

  /** The primary storage for elements of the stack */
  private SinglyLinkedList<E> list = new SinglyLinkedList<>();   // an empty list

  /** Constructs an initially empty stack. */
  public LinkedStack() { }                   // new stack relies on the initially empty list

  /**
   * Returns the number of elements in the stack.
   * @return number of elements in the stack
   */

  public int size() { return list.size(); }

  /**
   * Tests whether the stack is empty.
   * @return true if the stack is empty, false otherwise
   */

  public boolean isEmpty() { return list.isEmpty(); }

  /**
   * Inserts an element at the top of the stack.
   * @param element   the element to be inserted
 * @return 
   */

  public E push(E element) { 
	  list.addFirst(element);
	  return element; 
	  }

  /**
   * Returns, but does not remove, the element at the top of the stack.
   * @return top element in the stack (or null if empty)
   */
  public E top() { return list.first(); }

  /**
   * Removes and returns the top element from the stack.
   * @return element removed (or null if empty)
   */
  @Override
  public E pop() { return list.removeFirst(); }

  /** Produces a string representation of the contents of the stack.
   *  (ordered from top to bottom)
   *
   * This exists for debugging purposes only.
   *
   * @return textual representation of the stack
   */
  public String toString() {
    return list.toString();
  }
  
  /**
   * Transfer all elements from Source stack to Target Stack
   * Source stack will be empty after the operations
   * @param Source - Source Stack
   * @param Target - Target Stack
   */
  public static void transfer(Stack<Integer> Source, Stack<Integer> Target)
  {
      //Loop executes Until Source is empty
      while(!Source.isEmpty())
      {
          //Pop the top most element from Source and add to temp
          int temp = Source.pop();
          
          //Push temp into Target
          System.out.println("Element Transferred to Target Stack:"+temp);
          Target.push(temp);
      }
  }
  
	/** 
	 *************************************************
	 *************************************************
	 ********Student Name: Gokulraj Venugopal*********
	 ********Student ID: 301202722********************
	 *************************************************
	 *************************************************
	 **/
  public static void main(String[] args)
  {
      //2 Stack Creation - Source Stack sourceS and Target Stack targetS
      Stack<Integer> sourceS = new Stack<Integer>();
      Stack<Integer> targetS = new Stack<Integer>();
      
      //Adding elements to Source Stack
      sourceS.push(1);
      sourceS.push(2);
      sourceS.push(3);
      sourceS.push(4);
      sourceS.push(5);
      sourceS.push(6);
      System.out.println("Source Stack from Bottom to Top:");
      
      //Can be printed either using foreach loop either in both ways
      //below method uses the Java 8 method reference syntax to print 
      //each element of the sourceS collection to the console
      //sourceS.forEach(System.out::println);  
      
      for(Integer s:sourceS)
      {
    	  System.out.println(s);
      }
      
      System.out.println();
      
      //Function call to Transfer Source Stack elements to Empty Target Stack
      transfer(sourceS, targetS);


      //Prints Target Stack with elements 
      System.out.println("\nContents of new Transfer after transfer (Bottom to Top):");
      targetS.forEach(System.out::println);
      
      //Prints a empty stack as Source Stack is Empty
      System.out.println("\nContents of Source Stack after transfer:\n");
      sourceS.forEach(System.out::println);
      System.out.print("Source Stack is Empty");

  }
}
