package equivalencyandcloning;

import java.util.Arrays;

public class ArrayEquivalencyTest {

	public static void main(String[] args) {
		//using == operator
		System.out.println("Using == operator");
		int[] arr1 = new int[5]; // each element is initialized to 0
		int[] arr2 = new int[5]; // each element is initialized to 0
		System.out.println(arr1 == arr2); // returns false
		
		//using equals method of Object class
		System.out.println("Using equals method of Object class");
		int[] array1 = new int[5]; // each element is initialized to 0
		int[] array2 = new int[5]; // each element is initialized to 0
		System.out.println(array1.equals(array2)); // returns false
		
		//using equals method of Arrays class
		System.out.println("Using equals method of Arrays class");
		int[] array3 = new int[5]; // each element is initialized to 0
		int[] array4 = new int[5]; // each element is initialized to 0
		System.out.println(Arrays.equals(array3, array4)); // returns true

		//testing two dimensional arrays
		int[][] a = { {1,5}, {2,6} };
		int[][] b = { {1,5}, {2,6} };
		//shallow comparison with two dim arrays
		System.out.println("Shallow comparison with two dim arrays");
		if (Arrays.equals(a, b) || a == b)
		    System.out.println("Arrays are equal");
		else
		    System.out.println("Arrays ore not equal.");
		//deep comparison with two dim arrays
		System.out.println("Deep comparison with two dim arrays");
		if (Arrays.deepEquals(a, b) )
	    System.out.println("Arrays are equal");
		else
	    System.out.println("Arrays ore not equal.");
		

	}

}
