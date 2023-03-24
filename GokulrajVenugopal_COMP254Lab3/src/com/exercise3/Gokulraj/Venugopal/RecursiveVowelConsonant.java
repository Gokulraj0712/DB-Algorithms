package com.exercise3.Gokulraj.Venugopal;

import java.util.Scanner;

public class RecursiveVowelConsonant {

	public static boolean hasMoreVowels(String str,int vowels, int consonants) {
	    //Empty string has equal number of vowels and consonants
	    if (str.length() == 0) {
	    	return vowels > consonants;
	    }

	    //Changing first character to lowercase
	    char firstChar = Character.toLowerCase(str.charAt(0));	
	        
	  /*
	   * vowels will be incremented by 1 if the first character is present in 'aeiou' 
	   * else, consonants will be incremented by 1
	   */
	    
	    if ("aeiou".indexOf(firstChar) >= 0) {
	        vowels++;
	    } else {
	        consonants++;
	    }

	    /*
	     * Recursive case: 
			Add the counts of vowels and consonants in the rest of the string
	     */
	    return hasMoreVowels(str.substring(1), vowels, consonants);
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
		    String str = scanner.nextLine();
		    
		    if (hasMoreVowels(str,0,0)) //Function call
		        System.out.println("String '"+ str + "' have more Vowels than Consonants.");
		    
		    else
		        System.out.println("String '" + str+ "' doesn't have more Vowels than Consonants.");
		    
		    scanner.close();
		}
}
