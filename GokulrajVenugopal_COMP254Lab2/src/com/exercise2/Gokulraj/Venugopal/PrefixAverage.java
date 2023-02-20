package com.exercise2.Gokulraj.Venugopal;

import java.util.Random;

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

/**
 * Demonstration of algorithms for computing the prefix averages of an array.
 *
 * @author Michael T. Goodrich
 * @author Roberto Tamassia
 * @author Michael H. Goldwasser
 */

/** 
 *************************************************
 *************************************************
 *
 *
 *************************************************
 ********Student Name: Gokulraj Venugopal*********
 ********Student ID: 301202722********************
 *  **********************************************
 *
 **/

class PrefixAverage {

  /** Returns an array a such that, for all j, a[j] equals 
   * the average of x[0], ..., x[j]. 
   * A[j] = (X[0] + X[1] + … + X[j])/(j+1)
   * 
   * ******************************************************/
  // inner loop size will be 1, 2, 3, ..., n  (based on j=0,1,2,...,n-1)
  // we know that 1+2+3+...+ n-1+n = n(n+1)/2
  // so, the running time os O(n^2)
  public static double[] prefixAverage1(double[] x) {
    int n = x.length;
    double[] a = new double[n];    // filled with zeros by default
    for (int j=0; j < n; j++) {
      double total = 0;            // begin computing x[0] + ... + x[j]
      for (int i=0; i <= j; i++)
        total += x[i];
      a[j] = total / (j+1);        // record the average
    }
    return a;
  }

  /** Returns an array a such that, for all j, a[j] equals the average of x[0], ..., x[j]. */
  // the running time is O(n)
  public static double[] prefixAverage2(double[] x) {
    int n = x.length;
    double[] a = new double[n];    // filled with zeros by default
    double total = 0;              // compute prefix sum as x[0] + x[1] + ...
    for (int j=0; j < n; j++) {
      total += x[j];               // update prefix sum to include x[j]
      a[j] = total / (j+1);        // compute average based on current sum
    }
    return a;
  }
  public static long PreAvgTime1(double n)
  {
	  double[] a = new double[(int)n]; 	//Declaring a double array of size n
	  Random rand = new Random();		//Declaring a random variable
	  for(int j=0;j<a.length;j++)		//Loop executes a.length times , n times
	  {  
		  a[j]=rand.nextDouble();		//Initializing random number to Array a indexes, executes n-1 times
	  }
	  
	  long startTime = System.nanoTime();	//startTime before the function call is stored
	  prefixAverage1(a);					// Function call to prefixAverage1
	  long endTime = System.nanoTime();		//endTime is stored after the function prefixAverage1 is executed
	  System.out.println("Prefix Average 1 : "
			  		+ "ArraySize=" + n 
			  		+ "----StartTime: " + startTime
			  		+ "     EndTime: " + endTime 
			  		+ "     Elapsed Time:" + (endTime - startTime));
	  return (endTime - startTime);			//Returning the time taken to execute the function prefixAverage1
  }
	  
  public static long PreAvgTime2(double n)
  {
	  double[] a = new double[(int)n];	//Declaring a double array of size n
	  Random rand = new Random();		//Declaring a random variable
	  for(int j=0;j<a.length;j++)		//Loop executes a.length times , n times
	  {
		  a[j]=rand.nextDouble();		//Initializing random number to Array a indexes, executes n-1 times
	  }
	  long startTime = System.nanoTime();	//startTime before the function call is stored
	  prefixAverage2(a);					// Function call to prefixAverage2
	  long endTime = System.nanoTime();		//endTime is stored after the function prefixAverage2 is executed
	  System.out.println("Prefix Average 2 : "
	  					+ "ArraySize=" + n 
	  					+ "----StartTime: " + startTime+ 
	  					"     EndTime: " + endTime + 
	  					"     Elapsed Time:" + (endTime - startTime));
	  return (endTime - startTime);			//Returning the time taken to execute the function prefixAverage2
  }


}
