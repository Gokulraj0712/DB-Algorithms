package exercise01;

public class SortingExample {

	public static void main(String[] args) {
		
		int[] arrayToSort = {1, 5, 7, 3, 9};
		for(int i=0;i<arrayToSort.length;i++)
		{
			for(int j=i+1;j<arrayToSort.length;j++)
			{
				if(arrayToSort[j]<arrayToSort[i])
				{
					int temp=arrayToSort[j];
					arrayToSort[j]=arrayToSort[i];
					arrayToSort[i]=temp;
				}
			}
		}
		
		for(int a:arrayToSort)
		{
			System.out.print(a +" ");
		}

	}

}


/* Arrays.sort(arrayToSort);
for(int a:arrayToSort)
	System.out.print(a+ " ");
*/