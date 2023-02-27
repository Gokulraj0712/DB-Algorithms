package question1;
/*
 * Write and test a recursive Java method that takes a character 
 * string s and outputs its reverse. For example, 
 * the reverse of 'java' would be 'avaj'. 
 * Hint: use charAt method of String class.
 */


public class ReverseString {
	
	public String reverse(String str)  
	{  
		//checks if the string is empty then returns the string
		if(str.isEmpty())  
		{   
			//if the above condition is true returns the same string      
			return str;  
		}   
		else   
		{  
			return reverse(str.substring(1))+str.charAt(0);  
		}  
	}  

	/** 
	 *************************************************
	 *************************************************
	 ********Student Name: Gokulraj Venugopal*********
	 ********Student ID: 301202722********************
	 *************************************************
	 *************************************************
	 **/
	public static void main(String[] args) {
		ReverseString RS = new ReverseString();
		String S = "JAVA";
		if(S.isEmpty())
		{
			System.out.println("String is empty!! Cannot Reverse");
		}
		else
		{	
			System.out.println(RS.reverse(S));
		}
	}

}
