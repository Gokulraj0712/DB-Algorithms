
public class BoxTest {
	public static void main(String[] args) {
		Integer myInt = new Integer (5);
		Box box1 = new Box();
		//place an integer in th ebox
		box1.set(myInt);
		//place a string in the box
		String s = new String("hello");
		box1.set(s);
		//get the string from the box
		System.out.println(box1.get());
		//try to get an integer from the box
		Integer res = (Integer) box1.get(); // error
	}
}
