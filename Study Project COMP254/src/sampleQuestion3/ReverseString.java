package sampleQuestion3;

public class ReverseString {

	
	public static void reverse(String s)
	{
		reversed(s, s.length()-1); //reverse it
	}
	
	
	//input: a string and the index of the last character in it
	//output: reversed string
	public static void reversed(String s, int n)
	{
		  //stopping condition
		  if( n<0 ) 
			  throw new IllegalStateException("String must have one or more chars");
		if(n>=0)
		{
		  System.out.println(s.charAt(n));
		  //
		  reversed(s,n-1);// recur
		}
	}
	public static void main(String[] args) {
		String s= "COMP";
		reverse(s);
	}

}
