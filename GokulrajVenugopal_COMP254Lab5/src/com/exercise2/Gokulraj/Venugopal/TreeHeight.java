package com.exercise2.Gokulraj.Venugopal;

public class TreeHeight {
	/**\
	 * printSubtreeHeight function which calls postorderTraversal 
	 * when the root of the tree is not null
	 * @param Tree t
	 */
	public static void printSubtreeHeight(Tree t) 
	{
	    if (t.root() == null) {
	        return;
	    }
	    postorderTraversal(t, t.root());
	}

	/**
	 * postorderTraversal - recurssive function
	 * @param Tree t
	 * @param Position p
	 * @return height of the Element
	 */
	public static int postorderTraversal(Tree t, Position p) {
	    int height = 0;
	    for (Object p1 : t.children(p)) {
	        Position<String> c = (Position<String>) p1;
	        height = Math.max(height, postorderTraversal(t, c) + 1);
	    }
	    System.out.println("Element: " + p.getElement() + " \tHeight: " + height);
	    return height;
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
		//Adding elements to Tree T
		LinkedBinaryTree<String> T = new LinkedBinaryTree<>();
		Position<String> root = T.addRoot("A");
		Position<String> p1 = T.addLeft(root, "B");
		Position<String> p2 = T.addRight(root, "C");
		Position<String> p3 = T.addLeft(p1, "D");
		Position<String> p4 = T.addRight(p1, "E");
		Position<String> p5 = T.addLeft(p2, "F");
		Position<String> p6 = T.addRight(p2, "G");

		//Function Call to printSubtreeHeight
		printSubtreeHeight(T);
	}

}