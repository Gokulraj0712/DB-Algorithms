package com.exercise3.vinny.vinu;
/*
 * Name : Vinny Mariam Vinu 
 * Student Number:  301234317
 * */

public class Exercise3 
{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		int[] arr = {3, 7, 11, 6, 2, 12, 15, 18};
		int max = MaxElement(arr);
		System.out.println("Integer that cannot be formed as the sum of two integers : " + max );
		

	}

	private static int MaxElement(int[] arr) 
	{
		// TODO Auto-generated method stub
		int n = arr.length;
		int max = arr[0];
		for(int i=1; i<n;i++) //O(n) to find max value
		{
			if(max < arr[i])
				max = arr[i];
		}
		return (max*2)+1; 
	}

}
