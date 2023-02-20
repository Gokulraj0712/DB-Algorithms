
public class GenericBoxTest {
	
	public static void main(String[] args) {
		GenericBox<String> box1 = new GenericBox<String>();
		String s = new String("hello");
		box1.set(s);
		System.out.println(box1.get());
		String res = box1.get(); // no error
	}

}
