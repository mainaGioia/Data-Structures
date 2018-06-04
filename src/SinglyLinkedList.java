/**
 * Defines a singly linked list using nodes
 * e.g.  1 -> 2 -> 3 -> 4 -> 5
 * @author alessandra
 * 
 */
public class SinglyLinkedList<E> implements List<E>{
	
	
	//reference to the first node of the list 
	public Node head;
	
	
	
	public void addFirst(E n) {
		head = new Node(n, head);
	}
	
	
	// do not forget to setNext(n) for linking the node to the list
	//otherwise you just have a single node that is not linked to anything
	//while(last != null)
	//    last = last.getNext();
	//last = n;  does not work cause i should assign last(-1).next = n
	public void addLast(E n) {
		if(head == null) {
			head = new Node(n, null);
			return;
		}
		Node last = head;
		while(last.next != null)
			last = last.next;
		last.next = new Node(n,null);
	}
	
	
	public void delete(E n) {
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
		else {
			if (previousNode != null)
				previousNode.next = nodeToDelete.next;
			else 
				head = nodeToDelete.next;
		}
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
		// TODO Auto-generated method stub
		SinglyLinkedList<Integer> list = new SinglyLinkedList<Integer>();
		
		// error - linked list empty
		list.delete(1);
		
		//[ 3 ]
		list.addLast(3);
		System.out.println(list);
		
		//[ 2 3 ]
		list.addFirst(2);
		System.out.println(list);
		
		//[ 1 2 3 ]
		list.addFirst(1);
		System.out.println(list);
		
		//[ 1 2 3 4 ]
		list.addLast(4);
		System.out.println(list);
		
		//[ 1 2 3 ]
		list.delete(4);
		System.out.println(list);
		
		//[ 1 3 ]
		list.delete(2);
		System.out.println(list);
		
		// error - there is no such an element in the list
		//[ 1 3 ]
		list.delete(5);
		System.out.println(list);
		
		list.delete(1);
		System.out.println(list);

	}	
		
	
	
	

}




