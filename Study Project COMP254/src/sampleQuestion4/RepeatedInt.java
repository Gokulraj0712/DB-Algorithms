package sampleQuestion4;

public class RepeatedInt {

	public static void main(String[] args) {
		// // integers from 1 to n-1 inclusive, one of which is repeated
		int a[] = {1,2,3,3,4,5}; 
		System.out.println(findRepeatedInt(a));

	}
	/* Let A be an array of size n containing integers
	 *  from 1 to n-1 inclusive, one of which is repeated. 
	 *  Describe an algorithm for finding the integer in A that is
	 *  repeated.
	 */
	public static int findRepeatedInt(int[ ] A) {
		boolean[ ] found = new boolean[A.length]; // all elements false, by default
		for (int val : A)
			if (found[val])
				return val;
			else
				found[val] = true;
		
		return -1; // shouldn't happen if input as expected
		}

}
