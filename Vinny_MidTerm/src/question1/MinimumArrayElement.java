package question1;

/**
 * 
 * @author gokulrajvenugopal
 * Write and test a Java/Python recursive method for finding 
 * the minimum element in an array, A, of n elements. 
 * What the running time? Hint: an array of size 1 would be the stop condition. 
 * The implementation is similar to linearSum method in lecture 5 examples. 
 * You can use the Math.min method for finding the minimum of two numbers.
 *
 */

/**
 * 
 * @author gokulrajvenugopal
 * The time complexity of the provided method is O(n), 
 * where n is the size of the input array arr.

The reason for this time complexity is that the function getMinElement 
is called recursively n times, where n is the length of the array arr. 
In each recursive call, the function performs a constant amount of work 
(i.e., compares two elements of the array and makes a recursive call with the
 array of size n-1), so the total work done by the function is proportional
  to the size of the input array, which is O(n).

Note that the space complexity of this method is also O(n) because
 it uses the call stack to keep track of the recursive calls, 
 and each call adds a new frame to the stack
 *
 */
public class MinimumArrayElement {
	static int getMinElement(int [] arr, int len)
	{
		int min;
		if(len==1)
		{
			min=arr[0];
			return min;
		}
		else
		{
			return min=arr[len]<getMinElement(arr,len-1)?arr[len]:getMinElement(arr, len-1);
		}
	}
	
	public static void main(String[] args) {
		int[] array= {1,2,5,8,9,6,4,7,5,3};
		int result=getMinElement(array, array.length-1);
		System.out.println(result);
	}

}
