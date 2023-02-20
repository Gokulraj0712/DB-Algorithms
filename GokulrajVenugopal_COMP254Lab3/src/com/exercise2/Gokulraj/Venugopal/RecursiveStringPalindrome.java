package com.exercise2.Gokulraj.Venugopal;

import java.util.Scanner;

public class RecursiveStringPalindrome {
	
	public static boolean isPalindrome(String s)
	{
		//If length is 0 or 1 then String is palindrome
		if(s.length()<=1) 
			return true;
		
		//Check whether the first and last character of the string is different or not
		else if(s.charAt(0)!=s.charAt(s.length()-1))
			return false;
		/*
		 * If the first and last characters are equal, 
		 * it then removes the first and last characters from the string and 
		 * recursively calls itself with the remaining string. 
		 * This process continues until the length of the string is less than or equal to 1,
		 * at which point the method returns true.
		 */
		else
			return isPalindrome(s.substring(1,s.length()-1));
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
	        Scanner scanner = new Scanner(System.in);
	        System.out.print("Enter a string: ");
	        String s = scanner.nextLine();
	        
	        if (isPalindrome(s)) //Function Call
	            System.out.println(s + " is a palindrome");
	        else
	            System.out.println(s + " is not a palindrome");	
	        
	        scanner.close();
	}
}
