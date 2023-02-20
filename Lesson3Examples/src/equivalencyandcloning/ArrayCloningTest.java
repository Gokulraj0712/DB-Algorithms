package equivalencyandcloning;

public class ArrayCloningTest {

	public static void main(String[] args) {
		int[ ] data = {2, 3, 5, 7, 11, 13, 17, 19};
		int[ ] backup;
		backup = data; // warning; not a copy
		System.out.println("original array data");
		printArray(data);
		backup[0]=10;
		System.out.println("modified array data by changing backup");
		printArray(data);
		//deep copy of 1-dim arrays
		backup=data.clone();
		System.out.println("cloned array data");
		printArray(backup);
		backup[0]=20;
		System.out.println("array data not affected by changing backup");
		printArray(data);
		//
		System.out.println("deep copy of two-dimensional arrays");
		//deep copy of two-dimensional arrays
		int [][] matrix = { {1, 5}, {2, 6}, {3, 7} };
		print2dArray(matrix);
		int[][] backup2d = deepClone(matrix) ;
		//modify cell 0,0 in backup2d
		backup2d[0][0]=9;
		System.out.println("changing the deep copy does not affect"
				+ " original two-dimensional array");

		print2dArray(matrix);


	}
	//prints a two-dimensional array
	public static void print2dArray(int[][] array2d)
	{
		for (int i = 0; i < array2d.length; i++) //for each row
		{ 
			printArray(array2d[i]); // print row

		}
	}
	public static void printArray(int[] array)
	{

		System.out.print("[");
		for(int element : array)
			System.out.print(element +" ");
		System.out.println("]");

	}
	//cloning the individual rows of a two-dimensional array
	//of integers
	public static int[ ][ ] deepClone(int[ ][ ] original) 
	{ 
		int[ ][ ] backup = new int[original.length][ ]; // create top-level array of arrays
		//deep copy cloning the individual rows of an array
		for (int k=0; k < original.length; k++)
			backup[k] = original[k].clone( ); // copy row k
		return backup;
	}
	
	

}
