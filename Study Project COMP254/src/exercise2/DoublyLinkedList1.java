package exercise2;

public class DoublyLinkedList1<T> {
    
    // Doubly linked list implementation details
    
    // Node class for a doubly linked list
    private static class Node<T> {
        private T data;
        private Node<T> prev;
        private Node<T> next;
        
        public Node(T data, Node<T> prev, Node<T> next) {
            this.data = data;
            this.prev = prev;
            this.next = next;
        }
    }
    
    private Node<T> head;
    private Node<T> tail;
    private int size;
    
    // Constructor
    public DoublyLinkedList1() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }
    
    public void addLast(T data) {
        Node<T> newNode = new Node<>(data, tail, null);
        if (tail != null) {
            tail.next = newNode;
        } else {
            head = newNode;
        }
        tail = newNode;
        size++;
    }
    
    // Other methods for adding, removing, and accessing nodes in the list
    
    // Method to reverse the doubly linked list
    
    public void reverseList() {
        Node<T> current = head;
        Node<T> temp = null;
        
        // Swap the prev and next pointers for all nodes of the doubly linked list
        while (current != null) {
            temp = current.prev;
            current.prev = current.next;
            current.next = temp;
            current = current.prev;
        }
        
        // Swap the head and tail pointers of the doubly linked list
        temp = head;
        head = tail;
        tail = temp;
    }
 // Method to print all the elements of the doubly linked list
    public void printList() {
        Node<T> current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    
    // Other methods for printing and traversing the list
    
    public static void main(String[] args) {
        DoublyLinkedList1<Integer> list = new DoublyLinkedList1<>();
        
        // Add some elements to the list
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        
        // Print the original list
        System.out.println("Original list:");
        list.printList(); // Output: 1 2 3 4
        
        // Reverse the list
        list.reverseList();
        
        // Print the reversed list
        System.out.println("Reversed list:");
        list.printList(); // Output: 4 3 2 1
    }

    
}
