package question3;

import java.util.Arrays;

/**
 * 
 * @author gokulrajvenugopal
 * Let B be an array of size n ≥ 6 containing integers from 1 to n−5 inclusive, 
 * five of which are repeated. Write and test a method for finding the five integers in B 
 * that are repeated. What is the running time of this algorithm? 
 * Hint: Sort the array B then scan it from front to end looking for the repeated entries
 *
 */

public class IntegerRepeat {
	
	public static int[] findRepeatedIntegers(int[] B) {
	    Arrays.sort(B); // Sort the array in ascending order
	    int[] repeatedIntegers = new int[5]; // Create an array to store the repeated integers
	    int repeatedIndex = 0; // Index for the repeatedIntegers array
	    
	    for (int i = 1; i < B.length; i++) 
	    {
	        if (B[i] == B[i-1]) { // Check if the current element is the same as the previous element
	            repeatedIntegers[repeatedIndex] = B[i];
	            repeatedIndex++;
	            if (repeatedIndex == 5) { // Stop searching if all 5 repeated integers have been found
	                break;
	            }
	        }
	    }
	    return repeatedIntegers;
	}
	
	public static void main(String[] args) {
		int[] B = {1, 2, 3, 4, 5, 1, 2, 3, 4, 6, 7, 8, 9, 6, 7, 8, 9, 10, 11, 12};
		System.out.println("Entered Array of Numbers:");
		for(int i:B)
			System.out.print(i +" ");
		
	    int[] repeatedIntegers = findRepeatedIntegers(B);
	    System.out.println("\nThe repeated integers in B are:");
	    for (int i = 0; i < repeatedIntegers.length; i++) {
	        System.out.print(repeatedIntegers[i] + " ");
	    }
	}

}
