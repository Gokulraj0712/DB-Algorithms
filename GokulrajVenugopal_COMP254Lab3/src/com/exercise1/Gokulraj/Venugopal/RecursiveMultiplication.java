package com.exercise1.Gokulraj.Venugopal;

import java.util.Scanner;

public class RecursiveMultiplication {

	//Function to multiply 2 numbers using recursion
	public static int doMultiply(int m, int n)
	{
		if(n==0)		//Any number multiplied by 0 is 0
			return 0;
		else if(n>0)
			return m+doMultiply(m, n-1);	//Recursively add m to the product of m and n-1
		else
			return -doMultiply(m, -n);	// If n is negative, negate both n and m to get the same product but with a positive n	
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
	      Scanner s=new Scanner(System.in);
          System.out.println("Enter the first number: ");
          int m=s.nextInt();
          System.out.println("Enter the second number: ");
          int n=s.nextInt();
          System.out.println("Result: "+ doMultiply(m, n)); //Function call
          s.close();
		
	}
	
}
