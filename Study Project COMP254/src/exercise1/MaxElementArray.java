package exercise1;

public class MaxElementArray {
	
	static int getMAxElement(int [] arr, int len)
	{
		int max;
		if(len==1)
		{
			max=arr[0];
			return max;
		}
		else
		{
			return max=arr[len]>getMAxElement(arr,len-1)?arr[len]:getMAxElement(arr, len-1);
		}
	}
	
	public static void main(String[] args) {
		int[] array= {1,2,5,8,9,6,4,7,5,3};
		int result=getMAxElement(array, array.length-1);
		System.out.println(result);
	}

}
