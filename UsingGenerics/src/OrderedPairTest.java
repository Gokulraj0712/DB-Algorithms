
public class OrderedPairTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Pair<String, Integer> p1 = new OrderedPair<String, Integer>("Even", 8); 
		Pair<String, String> p2 = new OrderedPair<String, String>("hello", "world");
		// display the key and value of first ordered pair
		System.out.printf("Key is %s%n", p1.getKey());
		System.out.printf("Value is %s%n", p1.getValue());
		// display the key and value of second ordered pair
		System.out.printf("Key is %s%n", p2.getKey());
		System.out.printf("Value is %s%n", p2.getValue());


	}

}
