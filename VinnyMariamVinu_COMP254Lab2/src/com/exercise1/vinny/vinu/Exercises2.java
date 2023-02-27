package com.exercise1.vinny.vinu;

public class Exercises2 {

	//running time is:  
	/** Returns the sum of the integers in given array. */
	public static int example1(int n) {  
		int sum = 0;
	    for (int i=1; i <= n; i++)       //O(n)
	      sum += i;
	    return sum;
	}
	//
	public static int example2(int n) {
	    int p = 1;
	    for (int i=1; i <= 2*n; i++)      //O(n)
	      p *= i;
	    return p;
	}
	//
	public static int example3(int n) {
	    int p = 1;
	    for (int i=1; i <= Math.pow(n,2); i++)       //O(n^2)
	      p *= i;
	    return p;
	}
  
	//
	public static int example4(int n) {
	    int sum = 0;
	    for (int i=1; i <= 2*n; i++)				//O(n)
	    {
	    	for(int j=1;j<=i; j++)					//O(n^2)
	    		sum +=i;
	    }
	    	
	    return sum;
	}
	//
	public static int example5(int n) {
	    int sum = 0;
	    for (int i=1; i <= Math.pow(n,2); i++)     //O(n^2)
	    {
	    	for(int j=1;j<=i; j++)					//O(n^3)
	    		sum +=i;
	    }
	    	
	    return sum;
	}
}
