package com.exercise2.vinny.vinu;
/*
 * Copyright 2014, Michael T. Goodrich, Roberto Tamassia, Michael H. Goldwasser
 *
 * Developed for use with the book:
 *
 *    Data Structures and Algorithms in Java, Sixth Edition
 *    Michael T. Goodrich, Roberto Tamassia, and Michael H. Goldwasser
 *    John Wiley & Sons, 2014
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

import java.util.Arrays;
import java.util.Random;

/**
 * Demonstration of algorithms for testing element uniqueness.
 *
 * @author Michael T. Goodrich
 * @author Roberto Tamassia
 * @author Michael H. Goldwasser
 */
class Uniqueness {

  /** Returns true if there are no duplicate elements in the array. */
  public static boolean unique1(int[] data) {
    int n = data.length;
    for (int j=0; j < n-1; j++)
      for (int k=j+1; k < n; k++)
        if (data[j] == data[k])
          return false;                    // found duplicate pair
    return true;                           // if we reach this, elements are unique
  }

  /** Returns true if there are no duplicate elements in the array. */
  public static boolean unique2(int[] data) {
    int n = data.length;
    int[] temp = Arrays.copyOf(data, n);   // make copy of data
    Arrays.sort(temp);                     // and sort the copy
    for (int j=0; j < n-1; j++)
      if (temp[j] == temp[j+1])            // check neighboring entries
        return false;                      // found duplicate pair
    return true;                           // if we reach this, elements are unique
  }
  
  /*
   * Name : Vinny Mariam Vinu 
   * Student Number:  301234317
   * */
  
  public static void main(String[] args) 
  {
	  
      int result1 =binarySearch1(100000, 1000000);
      if(result1 == -1)
    	  System.out.println("No result found for unique1");
      else
    	  System.out.println("Value of n such that the unique 1 algorithm runs in one minute or less : " +result1 );
      
      int result2 =binarySearch1(10000, 10000000);
      if(result2 == -1)
    	  System.out.println("No result found for unique2");
      else
      System.out.println("Value of n such that the unique 1 algorithm runs in one minute or less : " +result2 );
      
  }
  //method to calculate time of unique1
  public static long timeCalculate1(int n)
  {
	  int[] arr = new int[n];
	  Random rand = new Random();
	  for(int i = 0; i< n; i++)
	  {
		  arr[i]= rand.nextInt();
	  }
	  long startTime = System.currentTimeMillis();
      boolean temp = unique1(arr);
      long endTime = System.currentTimeMillis();
	return endTime- startTime;
  }
//method to calculate time of unique2
  public static long timeCalculate2(int n)
  {
	  int[] arr = new int[n];
	  Random rand = new Random();
	  for(int i = 0; i< n; i++)
	  {
		  arr[i]= rand.nextInt();
	  }
	  long startTime = System.currentTimeMillis();
      boolean temp = unique2(arr);
      long endTime = System.currentTimeMillis();
	return endTime- startTime;
  }
  //binary search to find n for unique1
  public static int binarySearch1(int left, int right) 
	  {
	        while (left <= right) 
	        {
	            int mid = (left + right) / 2;
	            long time = timeCalculate1(mid);
	            System.out.println("time " + time + ", n = " + mid);
	            if (( time>900) &&  (time <1000)) 
	            {
	            	System.out.println("\n Time: " + time); 
	                return mid;
	            } else if (time < 950) {
	                left = mid + 1;
	            } else if (time > 1000){
	                right = mid - 1;
	            }
	        }
	        
	        return -1;
	    }
  //binary search to find n for unique1
	  public static int binarySearch2(int left, int right) 
	  {
	        while (left <= right) 
	        {
	            int mid = (left + right) / 2;
	            long time = timeCalculate2(mid);
	            System.out.println("time " + time + ", n = " + mid);
	            if (( time>900) &&  (time <1000)) 
	            {
	            	System.out.println("\n Time: " + time); 
	                return mid;
	            } else if (time < 950) {
	                left = mid + 1;
	            } else if (time > 1000){
	                right = mid - 1;
	            }
	        }
	        
	        return -1;
	    }
}
/*
 time 908, n = 550000

 Time: 908
Value of n such that the unique 1 algorithm runs in one minute or less : 550000
time 424, n = 5005000
time 1595, n = 7502500
time 358, n = 6253750
time 6399, n = 6878125
time 1413, n = 6565937
time 1523, n = 6409843
time 31, n = 6331796
time 123, n = 6370819
time 1876, n = 6390331
time 1136, n = 6380575
time 912, n = 6375697

 Time: 912
Value of n such that the unique 1 algorithm runs in one minute or less : 6375697

 * */
