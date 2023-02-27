package com.exercise3.vinny.vinu;
/**
 * @author Vinny Mariam Vinu - 301234317
 *
 */
public class CircularlyLinkedList<E> 
{

	  private static class Node<E> 
	  {

	    private E element;   
	    private Node<E> next; 
	    public Node(E e, Node<E> n) {
	      element = e;
	      next = n;
	    }
	    public E getElement() { return element; }

	    public Node<E> getNext() { return next; }

	    public void setNext(Node<E> n) { next = n; }
	  } 
	  private Node<E> tail = null;          
	  private int size = 0;                       
	  public CircularlyLinkedList() { }         
	  public int size() { return size; }

	  public boolean isEmpty() { return size == 0; }

	  public E first() 
	  {             
	    if (isEmpty()) return null;
	    return tail.getNext().getElement();        
	  }

	  public E last() 
	  {             
	    if (isEmpty()) return null;
	    return tail.getElement();
	  }

	  public void rotate() 
	  {         
	    if (tail != null)            
	      tail = tail.getNext();       
	  }

	  public void addFirst(E e) 
	  {                
	    if (size == 0) {
	      tail = new Node<>(e, null);
	      tail.setNext(tail);                     
	    } else {
	      Node<E> newest = new Node<>(e, tail.getNext());
	      tail.setNext(newest);
	    }
	    size++;
	  }

	  public void addLast(E e) 
	  { 
	    addFirst(e);           
	    tail = tail.getNext(); 
	  }

	  public E removeFirst() {                   // removes and returns the first element
	    if (isEmpty()) return null;              // nothing to remove
	    Node<E> head = tail.getNext();
	    if (head == tail) tail = null;           // must be the only node left
	    else tail.setNext(head.getNext());       // removes "head" from the list
	    size--;
	    return head.getElement();
	  }

	  public String toString() {
	    if (tail == null) return "()";
	    StringBuilder sb = new StringBuilder("(");
	    Node<E> walk = tail;
	    do {
	      walk = walk.getNext();
	      sb.append(walk.getElement());
	      if (walk != tail)
	        sb.append(", ");
	    } while (walk != tail);
	    sb.append(")");
	    return sb.toString();
	  }
	  
	//main method
	  public static void main(String[] args)
	  {
		  
		  //(LAX, MSP, ATL, BOS)
		  CircularlyLinkedList<String> list1 = new CircularlyLinkedList<String>();
		  CircularlyLinkedList<String> list2 = new CircularlyLinkedList<String>();
		  list1.addFirst("Circularly");
		  list1.addLast("LinkedList");
		  list2.addLast("Circularly");
		  list2.addFirst("LinkedList");
		  list1.addFirst("L2");
		  //
		  System.out.println(list1);
		  System.out.println(list2);
		  boolean t =isSameElements(list1,list2);
		  if (t == true)
			  System.out.println("List1 and List2 have all same elements");
		  else 
			  System.out.println("List1 and List2 does not have all same elements");


		  //
	  }
	  private static boolean isSameElements(CircularlyLinkedList<String> list1, CircularlyLinkedList<String> list2) 
	  {
		// TODO Auto-generated method stub
		  if(list1.isEmpty() && list2.isEmpty())
		  {
			  return true;
		  }
		  else if (list1.size != list2.size)
		  {
			  return false;
		  }
		  else
		  {

			  Node<String> temp1 = list1.tail.getNext();
			  Node<String> temp2 = list2.tail.getNext();
			  while (temp1 != list1.tail) 
			  {
		            int count = 0;
		            while (!temp1.element.equals(temp2.element)) {
		            	temp2 = temp2.next;
		                count++;
		                if (count >= list2.size()) {
		                    return false;
		                }
		            }
		            temp1 = temp1.getNext();
		            temp2 = list2.tail.getNext();
		        }
		        return true;
		  }
	  }

	}

