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

/**
 * Implementation of the stack ADT using a fixed-length array.  All
 * operations are performed in constant time. An exception is thrown
 * if a push operation is attempted when the size of the stack is
 * equal to the length of the array.
 *
 * @author Michael T. Goodrich
 * @author Roberto Tamassia
 * @author Michael H. Goldwasser
 */
public class ArrayStack<E> implements Stack<E> {
  /** Default array capacity. */
  public static final int CAPACITY=1000;   // default array capacity

  /** Generic array used for storage of stack elements. */
  private E[] data;                        // generic array used for storage

  /** Index of the top element of the stack in the array. */
  private int t = -1;                      // index of the top element in stack

  /** Constructs an empty stack using the default array capacity. */
  public ArrayStack() { this(CAPACITY); }  // constructs stack with default capacity

  /**
   * Constructs and empty stack with the given array capacity.
   * @param capacity length of the underlying array
   */
  @SuppressWarnings({"unchecked"})
  public ArrayStack(int capacity) {        // constructs stack with given capacity
    data = (E[]) new Object[capacity];     // safe cast; compiler may give warning
  }

  /**
   * Returns the number of elements in the stack.
   * @return number of elements in the stack
   */
  @Override
  public int size() { return (t + 1); }

  /**
   * Tests whether the stack is empty.
   * @return true if the stack is empty, false otherwise
   */
  @Override
  public boolean isEmpty() { return (t == -1); }

  /**
   * Inserts an element at the top of the stack.
   * @param e   the element to be inserted
   * @throws IllegalStateException if the array storing the elements is full
   */
  @Override
  public void push(E e) throws IllegalStateException {
    if (size() == data.length) throw new IllegalStateException("Stack is full");
    data[++t] = e;                           // increment t before storing new item
  }

  /**
   * Returns, but does not remove, the element at the top of the stack.
   * @return top element in the stack (or null if empty)
   */
  @Override
  public E top() {
    if (isEmpty()) return null;
    return data[t];
  }

  /**
   * Removes and returns the top element from the stack.
   * @return element removed (or null if empty)
   */
  @Override
  public E pop() {
    if (isEmpty()) return null;
    E answer = data[t];
    data[t] = null;                        // dereference to help garbage collection
    t--;
    return answer;
  }

  /**
   * Produces a string representation of the contents of the stack.
   * (ordered from top to bottom). This exists for debugging purposes only.
   *
   * @return textual representation of the stack
   */
  public String toString() {
    StringBuilder sb = new StringBuilder("(");
    for (int j = t; j >= 0; j--) {
      sb.append(data[j]);
      if (j > 0) sb.append(", ");
    }
    sb.append(")");
    return sb.toString();
  }
  
  /**
   * Transfer all elements from Source stack S to Target Stack T
   * Source stack will be empty after the operations
   * @param S
   * @param T
   */
  public static void transfer(Stack<Integer> S, Stack<Integer> T) {
	  //Loop executes Until Source is empty  
	  while (!S.isEmpty()) {
		//Pop the top most element from Source and add to element
	        int element = S.pop();
	        
	      //Push element into Target
	        T.push(element);
	    }
	}

  /** Demonstrates sample usage of a stack. */
  public static void main(String[] args) {
	//Source Stack Creation 
    Stack<Integer> S = new ArrayStack<>();  // contents: ()
    S.push(1);                              // contents: (1)
    S.push(2);                              // contents: (2, 1)
    S.push(3); 								// contents: (3, 2, 1)
    S.push(4); 								// contents: (4, 3, 2, 1)
    S.push(5); 								// contents: (5, 4, 3, 2, 1)
  	
    System.out.println("Before Transfer");
    System.out.println("Source Stack: ");
    System.out.println(S);	
    	
  //Target Stack Creation 
    Stack<Integer> T = new ArrayStack<>();
    
    System.out.println("\nTarget Stack:");
    System.out.println(T);
  //Function call to Transfer Source Stack elements to Empty Target Stack
    transfer(S, T);
    
    System.out.println("\n\nAfter Transfer");
    System.out.println("Source Stack:");
    System.out.println(S); 					// ()
    System.out.println("\nTarget Stack");
    System.out.println(T);					// (1, 2, 3, 4, 5)
    
    //Can use below method to print Target Stack
    // Print elements of T to confirm transfer
    // pop function removes all the values from Target Stack and will be empty once loop completes execution
    
    System.out.println("\n\nPrinting Each element of Target Stack in each Line");
    while (!T.isEmpty()) {
        System.out.println(T.pop());
    }
    
    System.out.println("\n\nTarget Stack after pop function:");
         System.out.println(T);
  }
}
