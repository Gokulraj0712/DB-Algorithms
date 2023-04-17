package com.exercise2.Gokulraj.Venugopal;

import java.util.Comparator;

public class BottomUpMergeSortClass {


	public static <K> void mergeSortBottomUp(Queue<K> S, Comparator<K> comp) {
	    int n = S.size();
	    if (n < 2) return;                     // queue is trivially sorted
	    
	    // create n queues, each containing a single element from S
	    Queue<Queue<K>> queues = new LinkedQueue<>();
	    for (int i = 0; i < n; i++) {
	        Queue<K> q = new LinkedQueue<>();
	        q.enqueue(S.dequeue());
	        queues.enqueue(q);
	    }
	    
	    // repeatedly merge adjacent queues until only one queue remains
	    while (queues.size() > 1) {
	        Queue<K> q1 = queues.dequeue();
	        Queue<K> q2 = queues.dequeue();
	        Queue<K> merged = new LinkedQueue<>();
	        mergeb(q1, q2, merged, comp);
	        queues.enqueue(merged);
	    }
	    
	    // the last remaining queue is the sorted queue
	    Queue<K> sorted = queues.dequeue();
	    while (!sorted.isEmpty()) {
	        S.enqueue(sorted.dequeue());
	    }
	}
  
  
  
  
  //--support bootm up merge sort of queus
  public static <K> void mergeb(Queue<K> S1, Queue<K> S2, Queue<K> S,
		    Comparator<K> comp) {
		    while (!S1.isEmpty() && !S2.isEmpty()) {
		        if (comp.compare(S1.first(), S2.first()) < 0) {
		            S.enqueue(S1.dequeue());
		        } else {
		            S.enqueue(S2.dequeue());
		        }
		    }
		    while (!S1.isEmpty()) {
		        S.enqueue(S1.dequeue());
		    }
		    while (!S2.isEmpty()) {
		        S.enqueue(S2.dequeue());
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
		  Integer[] S = new Integer[]{85, 24, 63, 45, 17, 31, 96, 50};
		  
		  //create a Comparator object
		  Comparator<Integer> comp = new Comparator<Integer>() {
		      public int compare(Integer i1, Integer i2) {
		        return i1.compareTo(i2);
		      }
		    };
		  
		    System.out.println("Initial Queue");
		    Queue<Integer> queue = new LinkedQueue<>();
		    for (Integer i : S) {
		       System.out.print(i + " ");
		       queue.enqueue(i);
		    }
		    
		  mergeSortBottomUp(queue, comp);
		  
		  System.out.println("\n\nSorted Queue:");
		  while (!queue.isEmpty()) { // Print the sorted queue 
		        System.out.print(queue.dequeue()+ " ");
		  }
	  }
	}
