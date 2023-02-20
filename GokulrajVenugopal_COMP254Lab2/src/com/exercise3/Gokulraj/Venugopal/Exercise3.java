package com.exercise3.Gokulraj.Venugopal;

public class Exercise3 {
	
	/**
	 * Returns the missing number in the list of unique progressive numbers passed to function
	 * Time complexity of this algorithm is O(n) 
	 */
	public static int findMissingNumber(int[] nums) {
	    int n = nums.length;			// Length of the array is initialized to n
	    int sum = n * (n + 1) / 2;		// sum is initialized with the sum of the first n numbers
	    int missingNumber = sum;		// missingNumber is initialized with sum
	    for (int i = 0; i < n; i++) {	// n+1 primitive operations  // Loop from 0 to n-1
	        missingNumber -= nums[i];	// n primitive operations 	//the value of nums[i] is reduced from missingNumber
	    }
	    return missingNumber;			// 1 primitive operations
	}
	
	/** 
	 *************************************************
	 *****************Main Method*********************
	 *************************************************
	 *
	 *
	 *************************************************
	 ********Student Name: Gokulraj Venugopal*********
	 ********Student ID: 301202722********************
	 *  **********************************************
	 *
	 **/
	public static void main(String[] args) {
	    int[] nums = {0, 1, 2, 4};			//Array declared and values added
	    System.out.println("Missing Number: " + findMissingNumber(nums)); 	//Function call to findMissingNumber by passing the array
	}


}
