package question3;

public class ElementLargest {
	
	public static int[] findTenLargest(int[] arr) {
	    int[] largestIndices = new int[10];
	    for (int i = 0; i < 10; i++) {
	        largestIndices[i] = i;
	    }
	    for (int i = 10; i < arr.length; i++) {
	        int smallestIndex = 0;
	        for (int j = 1; j < 10; j++) {
	            if (arr[largestIndices[j]] < arr[largestIndices[smallestIndex]]) {
	                smallestIndex = j;
	            }
	        }
	        if (arr[i] > arr[largestIndices[smallestIndex]]) {
	            largestIndices[smallestIndex] = i;
	        }
	    }
	    int[] largestElements = new int[10];
	    for (int i = 0; i < 10; i++) {
	        largestElements[i] = arr[largestIndices[i]];
	    }
	    return largestElements;
	}


	public static void main(String[] args) {
		int arr[]={1,22,3,40,5,6,27,8,9,10,113,12,13,14,15,16,17,18,19,20};
		
		System.out.println("Entered Array:");
		for(int i:arr) //n primitive operations
		{
			System.out.print(i +" ");
		}

		int []tenLargest=findTenLargest(arr);
		System.out.println("\n\nTen largest Elements in the array: ");	
		for(int i=0;i<tenLargest.length;i++) //n+1 operations
		{
			System.out.print(tenLargest[i]+" ");
		}

	}
}
