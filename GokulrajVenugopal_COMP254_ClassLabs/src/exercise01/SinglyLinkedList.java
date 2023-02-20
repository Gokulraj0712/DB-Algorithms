package exercise01;


public class  SinglyLinkedList<E> {
	//Create Instance variables
	int size = 0;
	private Node<E> head = null;
	private Node<E> tail = null;
	
	//Create inner class for Node 
	public static class Node<E>{
		private E element;
		private Node<E> next;
		//Create constructor
		public Node(E element , Node<E> next) {
			this.next = next;
			this.element = element;
		}	
	}
	
	//Create Empty Constructor
	public SinglyLinkedList() {}
	
	public Node getNode(int index) {
		Node node = head;
		for(int i=1;i<index;i++) {
			node = node.next;      //First iteration will store second indexed number into node
		}
		return node;
	}
	
	/*
	 * Function to return previous Node (The Node which comes previous to the Node which is having Passed parameter data)
	 * @param -> The Node data
	 * @return -> returns the Node where the Node.next contains data
	 */
	public Node<E> getPrevNode(E data) {
		Node<E> node = head;
		while(node != null && node.next.element != data) {
			node = node.next;
			if(node.next == null) {return null;}
		}
		return node;
	}
	
	//Insert first element
	public void insertFirst(E ele) {
		head = new Node(ele,head);
		if(size == 0) 
			tail = head;
		size++;
	}
	
	//Insert last element
	public void insertLast(E ele) {
		Node newEle = new Node(ele,null);
		if(size == 0) {
			head = tail;
		}
		else {
			tail.next = newEle;		
		}	
		tail = newEle;
		size++;
	}
	
	//Following method will insert element at a particular index
	public void insertAtIndex(int index,E ele) {
		if(index == 0){
			insertFirst(ele);
			return;
		}
		if(index == size){
			insertLast(ele);
			return;
		}
		Node temp = getNode(index);
		Node node = new Node(ele,temp.next);
		temp.next =  node;
		size++;
	}
	
	public void deleteAtFirst(){
		head = head.next;
		if(head == null)
			tail = null;
		size--;
	}
	
	public void deleteAtLast() {
		if(size <= 1) {
			deleteAtFirst();
			return;
		}
		else {
			Node secondLast = getNode(size - 1);
			tail = secondLast;
			tail.next = null;
			size --;
		}
	}
	
	public void deleteAtIndex(int index) {
		if(index == 0) {
			deleteAtFirst();
			return;
		}
		if(index == size) {
			deleteAtLast();
			return;
		}
		Node prev = getNode(index - 1); 
		prev.next = prev.next.next;
	}
	
	public boolean swapNodes(E data1,E data2) {
		if(data1 == data2) {
			System.out.println("Nodes are same , Cannot Swap: Exiting...");
			return false;
			}
		Node<E> prev_data1 = null,prev_data2 = null;
		
		//Find Previous Node of Node having data1 and data2
		prev_data1 = getPrevNode(data1);
		prev_data2 = getPrevNode(data2);
		//Set Nodes having data1 and data2
		if(prev_data1 == null || prev_data2 == null) {
			System.out.printf("List is not having one of these members %s,%s, Cannot Swap: Exiting...",data1,data2);
			return false;
		}
		
		Node current_data1 = prev_data1.next;
		Node current_data2 = prev_data2.next;
		
		//If current_data1 not the head then make it as node2
		if(prev_data1 != null) {
			prev_data1.next = current_data2;
		}else {
			head = current_data2;
		}

		//If current_data2 is not the head then
		if(prev_data2 != null) {
			prev_data2.next = current_data1;
		}else {
			head = current_data1;
		}
		
		//Swap references
		Node temp;
		temp = current_data1.next;
		current_data1.next = current_data2.next;
		current_data2.next = temp;
		return true;
	}
	//Show elements
	@Override
	public String toString() {
		Node n = head;
		StringBuilder sb = new StringBuilder();
		sb.append("(");
		while (n != null) {
			sb.append(n.element);
			if(n.next != null) sb.append(",");
			n = n.next;
		}
		return(sb+")");
	}

	//Create main method
	public static void main(String[] args) {
		//Create List student
		SinglyLinkedList<String> student = new SinglyLinkedList<String>();
		student.insertFirst("Student 1");
		student.insertLast("Student 2");
		student.insertLast("Student 3"); 
		student.insertLast("Student 4");
		student.insertLast("Student 5");
		System.out.println("List before Swap : "+student);
		
		Boolean swapStatus = false;
		//Test 1 : Positive Scenario
		//Swap Student 2 data with Student 4 data
		swapStatus = student.swapNodes("Student 2", "Student 4");
		if(swapStatus) {
		System.out.println("List after swap : "+student);
		
		//Test 2 : Negative Scenario
		swapStatus = student.swapNodes("Student 10", "Student 11");
		if(swapStatus) {
		System.out.println("List after swap : "+student);
		}
	}
 }
}


