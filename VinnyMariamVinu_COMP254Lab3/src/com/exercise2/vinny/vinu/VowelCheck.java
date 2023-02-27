package com.exercise2.vinny.vinu;

import java.util.Scanner;

public class VowelCheck 
{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("enter your string:");
		
		String str = sc.next();		 
        str = str.toLowerCase();
 
        System.out.println("Number of vowels in string : ");
 
        System.out.println(vowelCheck(str, str.length()));

	}
	
	//recursive function to count the number of vowels
	 public static int vowelCheck(String str, int length)
	    {
		 	if(str==null||length==0)
		 		return 0;
	        if (length == 1) {
	            return isVowel(str.charAt(length-1));
	        }
	        //System.out.println(str.charAt(length - 1));
	       // System.out.println(str + (length-1) + isVowel(str.charAt(length-1)));
	        return vowelCheck(str, length-1 )+isVowel(str.charAt(length-1));
	    }

	 //function to check if a character is a vowel
	private static int isVowel(char ch) 
	{
		// TODO Auto-generated method stub
		if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') 
		{
	        return 1;
	    }
	    else 
	    {
	        return 0;
	    }
	}

}
