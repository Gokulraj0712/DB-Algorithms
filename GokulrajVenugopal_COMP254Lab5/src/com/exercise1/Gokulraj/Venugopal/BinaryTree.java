package com.exercise1.Gokulraj.Venugopal;
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

/**
 * An interface for a binary tree, in which each node has at most two children.
 *
 * @author Michael T. Goodrich
 * @author Roberto Tamassia
 * @author Michael H. Goldwasser
 */
public interface BinaryTree<E> extends Tree<E> {

  /**
   * Returns the Position of p's left child (or null if no child exists).
   *
   * @param p A valid Position within the tree
   * @return the Position of the left child (or null if no child exists)
   * @throws IllegalArgumentException if p is not a valid Position for this tree
   */
  Position<E> left(Position<E> p) throws IllegalArgumentException;

  /**
   * Returns the Position of p's right child (or null if no child exists).
   *
   * @param p A valid Position within the tree
   * @return the Position of the right child (or null if no child exists)
   * @throws IllegalArgumentException if p is not a valid Position for this tree
   */
  Position<E> right(Position<E> p) throws IllegalArgumentException;

  /**
   * Returns the Position of p's sibling (or null if no sibling exists).
   *
   * @param p A valid Position within the tree
   * @return the Position of the sibling (or null if no sibling exists)
   * @throws IllegalArgumentException if p is not a valid Position for this tree
   */
  Position<E> sibling(Position<E> p) throws IllegalArgumentException;
  
/**
 *  The preorderNext method accepts a position p and then returns a
 *  position visited after the position p in a preorder traversal of a binary
 *  tree T.
 *  
 *  preorder traversal, get the current position, traverse the left
 *  subtree, then traverse the right subtree.
 */
  	public default Position<E> preorderNext(Position<E> p)
  	{
	  if(left(p) != null)
		  return left(p);

	  if(right(p) != null)
		  return right(p);

	  Position<E> k = parent(p);
	  while(k != null && (right(k) == null || right(k) == p))
	  {
		  p = k;
		  k = parent(k);
	  }

	  if(k == null)
		  return null;

	  return right(k);
  	}
  
  	
 /**
  * The inorderNext method accepts a position p and then returns a position 
  * visited after the position p in a inorder traversal of a binary tree T.
  * 
  * inorder traversal, traverse the left subtree, get the current
  * position, and then traverse the right subtree
  */
	public default Position<E> inorderNext(Position<E> p)
	{
		if(right(p) != null)
		{
			Position<E> k = right(p);
			while(left(k) != null)
			{
				k = left(k);
			}
			return k;
		}
		if(parent(p) == null)
			return null;
		
		Position<E> k = parent(p);
		
		if(left(k) != null && left(k) == p)
			return k;
		
		while(k != null && (right(k) == null || right(k) == p))
		{
			p = k;
			k = parent(k);
		}
	
		if(k == null)
			return null;
	
		return k;
	} // end of inorderNext method
	  
/** 
 *************************************************
 *************************************************
 ********Student Name: Gokulraj Venugopal*********
 ********Student ID: 301202722********************
 *************************************************
 *************************************************
 **/

 public static void main(String[] args) {
	//Create an object for LinkedBinaryTree class
	 LinkedBinaryTree<Integer> T = new LinkedBinaryTree<Integer>();

	 // add elements to the binary tree T
	 Position<Integer> p1 = T.addRoot(45);
	 Position<Integer> p2 = T.addLeft(p1, 35);
	 Position<Integer> p3 = T.addLeft(p2, 25);
	 Position<Integer> p4 = T.addRight(p1, 55);
	 Position<Integer> p5 = T.addRight(p2, 40);
	 Position<Integer> p6 = T.addLeft(p4, 50);
	 Position<Integer> p7 = T.addLeft(p5, 38);
	 Position<Integer> p8 = T.addRight(p7, 39);
	 Position<Integer> p9 = T.addRight(p5, 42);
	 Position<Integer> p10 = T.addRight(p9, 44);
	 Position<Integer> p11 = T.addRight(p4, 60);
	 Position<Integer> p12 = T.addRight(p11, 63);

	 //Display the preorder traversal of T
	 System.out.print("Preorder traversal of T: ");
	 Iterable<Position<Integer>> itr2 = T.preorder();
	 for(Position<Integer> p : itr2)
	 System.out.print(p.getElement() + " ");
	 System.out.println();

	 /*Display the position visited after each element in a preorder 
	  * traversal of T
	  */
	 for(Position<Integer> p : itr2)
	 {
		 Position<Integer> result = T.preorderNext(p);
		 if(result == null)
			 System.out.println("preorderNext(" + p.getElement() + "): null");
		 else
			 System.out.println("preorderNext(" + p.getElement() + "): " + result.getElement());
	 }
	 System.out.println();

	 //Display the inorder traversal of T
	 System.out.print("Inorder traversal of T: ");
	 Iterable<Position<Integer>> itr1 = T.inorder();
	 for(Position<Integer> p : itr1)
	 System.out.print(p.getElement() + " ");
	 System.out.println();

	 /*Display the position visited after each element in a 
	  * inorder traversal of T
	  */
	 for(Position<Integer> p : itr1)
	 {
		 Position<Integer> result = T.inorderNext(p);
		 if(result == null)
			 System.out.println("inorderNext(" + p.getElement() + "): null");
		 else
			 System.out.println("inorderNext(" + p.getElement() + "): " + result.getElement());
	 }
	 System.out.println();
 }
  
}
