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
package com.exercise1.Gokulraj.Venugopal;

import java.util.Iterator;

/**
 * An interface for positional lists.
 * @author Michael T. Goodrich
 * @author Roberto Tamassia
 * @author Michael H. Goldwasser
 * @see Position
 */
public interface PositionalList<E> extends Iterable<E> {

  /**
   * Returns the number of elements in the list.
   * @return number of elements in the list
   */
  int size();

  /**
   * Tests whether the list is empty.
   * @return true if the list is empty, false otherwise
   */
  boolean isEmpty();

  /**
   * Returns the first Position in the list.
   *
   * @return the first Position in the list (or null, if empty)
   */
  Position<E> first();

  /**
   * Returns the last Position in the list.
   *
   * @return the last Position in the list (or null, if empty)
   */
  Position<E> last();

  /**
   * Returns the Position immediately before Position p.
   * @param p   a Position of the list
   * @return the Position of the preceding element (or null, if p is first)
   * @throws IllegalArgumentException if p is not a valid position for this list
   */
  Position<E> before(Position<E> p) throws IllegalArgumentException;

  /**
   * Returns the Position immediately after Position p.
   * @param p   a Position of the list
   * @return the Position of the following element (or null, if p is last)
   * @throws IllegalArgumentException if p is not a valid position for this list
   */
  Position<E> after(Position<E> p) throws IllegalArgumentException;

  /**
   * Inserts an element at the front of the list.
   *
   * @param e the new element
   * @return the Position representing the location of the new element
   */
  Position<E> addFirst(E e);

  /**
   * Inserts an element at the back of the list.
   *
   * @param e the new element
   * @return the Position representing the location of the new element
   */
  Position<E> addLast(E e);

  /**
   * Inserts an element immediately before the given Position.
   *
   * @param p the Position before which the insertion takes place
   * @param e the new element
   * @return the Position representing the location of the new element
   * @throws IllegalArgumentException if p is not a valid position for this list
   */
  Position<E> addBefore(Position<E> p, E e)
    throws IllegalArgumentException;

  /**
   * Inserts an element immediately after the given Position.
   *
   * @param p the Position after which the insertion takes place
   * @param e the new element
   * @return the Position representing the location of the new element
   * @throws IllegalArgumentException if p is not a valid position for this list
   */
  Position<E> addAfter(Position<E> p, E e)
    throws IllegalArgumentException;

  /**
   * Replaces the element stored at the given Position and returns the replaced element.
   *
   * @param p the Position of the element to be replaced
   * @param e the new element
   * @return the replaced element
   * @throws IllegalArgumentException if p is not a valid position for this list
   */
  E set(Position<E> p, E e) throws IllegalArgumentException;

  /**
   * Removes the element stored at the given Position and returns it.
   * The given position is invalidated as a result.
   *
   * @param p the Position of the element to be removed
   * @return the removed element
   * @throws IllegalArgumentException if p is not a valid position for this list
   */
  E remove(Position<E> p) throws IllegalArgumentException;

  /**
   * Returns an iterator of the elements stored in the list.
   * @return iterator of the list's elements
   */
  Iterator<E> iterator();

  /**
   * Returns the positions of the list in iterable form from first to last.
   * @return iterable collection of the list's positions
   */
  Iterable<Position<E>> positions();
  
  /**
   * Returns the current index of the element stored at the given Position.
   * Used default type to add method defenition in Interface
   * @param p the Position of the element to be searched
   * @return the index of the element stored at the given Position, or -1 if not found
   */
  public default int indexOf(Position<E> p) {
      int index = 0;
      for (Position<E> current : positions()) {
          if (current.equals(p)) {
              return index; // return index of element
          }
          index++;
      }
      return -1; //return -1 if element not found
  }
  

	/** 
	 *************************************************
	 *************************************************
	 ********Student Name: Gokulraj Venugopal*********
	 ********Student ID: 301202722********************
	 *************************************************
	 *************************************************
	 **/

  public static void main(String[] args) {
	  //Creating list 1
	  LinkedPositionalList<String> list = new LinkedPositionalList<>();
	  System.out.println("List 1:");
	  Position<String> a = list.addFirst("a");	// AddFirst with element a
	  Position<String> b = list.addAfter(a, "b"); //Add element 'b' after 'a'
	  Position<String> c = list.addAfter(b, "c"); //Add element 'c' after 'b'
	  Position<String> d;
	  
	  System.out.println(a.getElement().toString() + " " +list.indexOf(a)); // prints 0
	  System.out.println(b.getElement().toString() + " " +list.indexOf(b) ); // prints 1
	  System.out.println(c.getElement().toString() + " " +list.indexOf(c)); // prints 2
	  
	  
	  list.remove(b); //Removing element 'b'
	  System.out.println("\nRemoved 'b'");
	  System.out.println("\nUpdated List 1:");
	  
	  System.out.println(a.getElement().toString() +" " + list.indexOf(a)); // prints 0
	  System.out.println(c.getElement().toString() +" " + list.indexOf(c)); // prints 1

	  //Creating list 2
	  PositionalList<String> list1 = new LinkedPositionalList<>();
	  System.out.println("\nList 2:");
	  Position<String> p1 = list1.addLast("apple"); // Adding 'apple' to end of list
	  Position<String> p2 = list1.addLast("banana"); // Adding 'banana' to end of list
	  Position<String> p3 = list1.addLast("orange"); // Adding 'orange' to end of list
	  Position<String> p4 = list1.addLast("pear");	// Adding 'pear' to end of list
	  Position<String> p5 = list1.addFirst("mango");	// Adding 'mango end of list

	  System.out.println(p1.getElement().toString()+" " + list1.indexOf(p1)); // Output: 1
	  System.out.println(p2.getElement().toString()+" " +list1.indexOf(p2)); // Output: 2
	  System.out.println(p3.getElement().toString() +" " +list1.indexOf(p3)); // Output: 3
	  System.out.println(p4.getElement().toString()+" " +list1.indexOf(p4)); // Output: 4
	  System.out.println(p5.getElement().toString()+" " +list1.indexOf(p5)); // Output: 0
  }
}

