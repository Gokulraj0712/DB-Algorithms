package question3;
import java.util.Scanner;

public class RepeatedIntegers {

		void print(int a[],int s)  
		{
			int c[]=new int[s];
			int i;// declare the value
			System.out.println("Repeated integers are : ");// repeat the interger value
			for(i=0;i<s;i++)  // loop apply
			{
				if(c[a[i]]==1)  
					System.out.print(a[i]+" ");// declare the value of a
				else  // loop apply
					c[a[i]]++;
			}
		}
		
		public static void main(String[] args)
		{
			RepeatedIntegers obj=new RepeatedIntegers();// repeat the integer
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter the size of array");// declare the size of  array
			int n=sc.nextInt();
			int[] arr=new int[n];
			System.out.println("Enter the Elemnts in Array"); //  declare the elements in array 
			for(int i=0;i<n;i++)
				arr[i]=sc.nextInt();
			obj.print(arr,n);// object will be in array form
		}
	
	
}
