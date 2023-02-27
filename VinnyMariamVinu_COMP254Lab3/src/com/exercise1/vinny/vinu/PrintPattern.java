package com.exercise1.vinny.vinu;

import java.util.Scanner;

public class PrintPattern 
{

	public static void main(String[] args) 
	{
		try  
		{
			Scanner sc = new Scanner(System.in);
			int num1;
			System.out.println("Enter the number :");
			num1 = sc.nextInt();
			printNumPatternTop(num1);
			printNumPatternBottom(num1);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}

	}

	//function to print Bottom pattern
	private static void printNumPatternBottom(int num1) 
	{
		// TODO Auto-generated method stub
		if(num1 >= 1)
        {
           
           drawPatternBottom(num1-1);
           printNumPatternBottom(num1-1);
        }
		
	}
	//function to print Top pattern
	private static void printNumPatternTop(int num1) 
	{	
	        if(num1 >= 1)
	        {
	           printNumPatternTop(num1-1);
	           drawPatternTop(num1);
	        }
	}

	//function to draw Bottom pattern
	private static void drawPatternTop(int num1) 
	{
		// TODO Auto-generated method stub
		for(int i=0;i<num1; i++)
		{
			System.out.print(" * ");
		}
		System.out.print("\n");
	}
	
	//function to draw Bottom pattern
	private static void drawPatternBottom(int num1) 
	{
		// TODO Auto-generated method stub
		for(int i=num1-1;i>=0; i--)
		{
			System.out.print(" * ");
		}
		System.out.print("\n");
	}

}
