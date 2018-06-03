/**
 * Defines a singly linked list using nodes
 * e.g.  1 -> 2 -> 3 -> 4 -> 5
 * @author alessandra
 *
 */
public class SinglyLinkedList {
	
	/**
	 * Class node 
	 * Contains a value (integer) and a pointer to the next node
	 * @author alessandra
	 *
	 */
	class Node{
		public int value;
		public Node next;
		
		public Node(int val, Node n) {
			value = val;
			next = n;
		}
	}
	
	//reference to the first node of the list 
	public Node head;
	
	
	
	public void addFirst(int n) {
		head = new Node(n, head);
	}
	
	
	// do not forget to setNext(n) for linking the node to the list
	//otherwise you just have a single node that is not linked to anything
	//while(last != null)
	//    last = last.getNext();
	//last = n;  does not work cause i should assign last(-1).next = n
	public void addLast(int n) {
		if(head == null) {
			head = new Node(n, null);
			return;
		}
		Node last = head;
		while(last.next != null)
			last = last.next;
		last.next = new Node(n,null);
	}
	
	
	public void delete(int n) {
		if(head == null) {
			System.err.println("Linked list empty! Add something first and then you can delete\n");
			return;
		}
		Node nodeToDelete = head;
		Node previousNode = null;
		while(nodeToDelete != null && nodeToDelete.value != n) {
			previousNode = nodeToDelete;
			nodeToDelete = nodeToDelete.next;
		}
		if(nodeToDelete == null)
			System.err.println("There is no such an element in the list!");
		else 
			previousNode.next = nodeToDelete.next;		
	}
	
	
	public String toString() {
		String s = ("[");
		Node n = head;
		while(n != null) {
			s += " "+n.value;
			n = n.next;
		}
		s += (" ]");
		return s;		
	}
	
	
	

}
