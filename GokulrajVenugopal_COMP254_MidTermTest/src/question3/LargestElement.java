package question3;

import java.util.Iterator;

/**
 * Write and test an efficient Java/Python method for finding the 
 * ten largest elements in an array of size n. 
 * What is the running time of your algorithm? 
 * Hint: Use an auxiliary array to store indices of largest elements 
 * and ignore previous found elements. Note that 10 is a constant
 * @author gokulrajvenugopal
 *
 */
public class LargestElement {
	
	/**
	 * 
	 * Answer : O(n^2)
   *  			  
   *  For any given number of elements in arr[], 2 loops execute, 
   *  hence running time is quadratic.
   *  */
	public static int[] tenLargest(int arr[]){
		int tenlargest[]=new int[10];
		for (int i = 0;i<arr.length;i++)   //n primitive operations (O(n))
		{
			for (int j=i+1;j<arr.length;j++)  //n*(n-i) primitive operations O(n^2)
			{
				if(arr[i]<arr[j]) 	
				{
					int temp=arr[i];	
					arr[i]=arr[j];	
					arr[j]=temp;	
				}
			}
		}

		int i=0;
		while(i<10) //n+1 primitive operations
		{
			tenlargest[i]=arr[i]; //n primitive operations
			i++; //n primitive operations
		}
		
		return tenlargest;

	}

		public static void main(String[] args) 
		{
			int arr[]={1,22,3,40,5,6,27,8,9,10,113,12,13,14,15,16,17,18,19,20};
			
			System.out.println("Entered Array:");
			for(int i:arr) //n primitive operations
			{
				System.out.print(i +" ");
			}

			int []tenLargest=tenLargest(arr);
			System.out.println("\n\nTen largest Elements in the array: ");	
			for(int i=0;i<tenLargest.length;i++) //n+1 operations
			{
				System.out.print(tenLargest[i]+" ");
			}

		}

}