/**
 * Defines a single linked list using nodes
 * @author alessandra
 *
 */
public class SingleLinkedList {
	
	//head represents the first node of the list 
	public Node head;
	
	
	/** Default constructor */
	public SingleLinkedList() {
		head = null;
	}
	
	
	public void addFirst(Node n) {
		n.next = head;
		head = n;
	}
	
	
	// do not forget to setNext(n) for linking the node to the list
	//otherwise you just have a single node that is not linked to anything
	//while(last != null)
	//    last = last.getNext();
	//last = n;  does not work cause i should assign last(-1).next = n
	public void addLast(Node n) {
		if(head == null) {
			head = n;
			return;
		}
		Node last = head;
		while(last.next != null)
			last = last.next;
		last.next = n;
	}
	
	
	public void delete(Node n) {
		if(head == null) {
			System.err.println("Linked list empty! Add something first and then you can delete\n");
			return;
		}
		Node nodeToDelete = head;
		Node previousNode = null;
		while(nodeToDelete != null && !nodeToDelete.equals(n)) {
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
