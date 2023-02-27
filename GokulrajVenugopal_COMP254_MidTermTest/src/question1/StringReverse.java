package question1;

public class StringReverse {
	
	public static String reverse(String s) {
	    if (s.length() <= 1) {
	        return s;
	    } else {
	        return reverse(s.substring(1)) + s.charAt(0);
	    }
	}

	public static void main(String[] args) {
		StringReverse SR = new StringReverse();
		System.out.println(SR.reverse("JAVA"));
		
	}
}
