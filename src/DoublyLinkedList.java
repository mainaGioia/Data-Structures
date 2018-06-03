/**
 * Doubly linked list implementation
 * e.g. head -> <- 1 -> <- 2 -> <- 3 -> <- tail
 * @author alessandra
 *
 */
public class DoublyLinkedList {
	
	/**
	 * 
	 * @author alessandra
	 *
	 */
	class Node{
		
		public Node prev;
		public Node next;
		public int value;
		
		public Node(Node p, Node n, int val) {
			prev = p;
			next = n;
			value = val;
		}
	}
	
	
	public Node head;
	public Node tail;
	
	

}
