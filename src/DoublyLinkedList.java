
/**
 * Doubly linked list implementation
 * e.g.  1 -> <- 2 -> <- 3 
 * insert O(1) delete O(n)
 * delete is O(1) in case you delete nodes (head.next) so no need to search
 * @author alessandra
 *
 */
public class DoublyLinkedList implements List{
	
	/**
	 * Contains a value (integer), a pointer to the previous node
	 * and a pointer to the next one
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
	
	
	//reference to the first node
	public Node head;	
	
	/**
	 * Adds an integer at the beginning of the list
	 * @param val
	 */
	public void addFirst(int val) {
		Node node = new Node(null, head, val);
		if(head != null)
			head.prev = node;
		head = node;
	}
	
	/**
	 * Appends an integer at the end of the list
	 * @param val
	 */
	public void addLast(int val) {
		Node n = head;
		if(n == null) {
			head = new Node(null, null, val);
			return;
		}
		while(n.next != null)
			n = n.next;
		n.next = new Node(n, null, val);
	}
	
	
	/**
	 * Deletes all the elements with value specified
	 * @param val
	 */
	public void delete(int val) {
		Node n = head;
		if(head == null) {
			System.out.println("empty list. Insert something first");
			return;
		}
		int found = 0;
		while(n != null) {
			if(n.value == val) {
				found = 1;
				if(n.prev != null)
					n.prev.next = n.next;
				else { //i am deleting the first node
					head = n.next;
					n = head;
					continue;
				}
				//setting the prev pointer of the next node
				if(n.prev.next != null) //check if it is not the last
					n.prev.next.prev = n.prev;
				n = n.prev;
			}
			n = n.next;
		}
		if (found == 0)
			System.out.print("No "+val+" in the list\n");			
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
	
	
	
	public static void main(String[] args) { 
		DoublyLinkedList dlist = new DoublyLinkedList();
		
		// error - linked list empty
		dlist.delete(1);
		
		//[ 3 ]
		dlist.addLast(3);
		System.out.println(dlist);
		
		//[ 2 3 ]
		dlist.addFirst(2);
		System.out.println(dlist);
		
		//[ 1 2 3 ]
		dlist.addFirst(1);
		System.out.println(dlist);
		
		//[ 1 2 3 4 ]
		dlist.addLast(4);
		System.out.println(dlist);
	
		//[ 1 2 3 ]
		dlist.delete(4);
		System.out.println(dlist);
				
		//[ 1 3 ]
		dlist.delete(2);
		System.out.println(dlist);
				
		// error - there is no such an element in the list
		//[ 1 3 ]
		dlist.delete(5);
		System.out.println(dlist);
		
		//[ 3 ]
		dlist.delete(1);
		System.out.println(dlist);
	}

}
