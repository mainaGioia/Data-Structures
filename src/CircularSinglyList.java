
/**
 * Circular linked list implementation
 * e.g. 1 -> 2 -> 3 -> back to 1
 * @author alessandra
 *
 */
public class CircularSinglyList implements List{
	
	public Node last;


	@Override
	public void addFirst(int n) {
		Node node = new Node(null, n);
		if(last != null) {
			node.next = last.next;
			last.next = node;
			return;
		}
		last = node;
		node.next = node;		
	}



	@Override
	public void addLast(int n) {
		Node node = new Node(null, n);
		if(last != null) {
			node.next = last.next;  //the current node will point to the first one
			last.next = node;		//change the pointer to next for the previous last node
			last = node;			//reassign pointer to last 
			return;
		}
		node.next = node;
		last = node;
	}



	@Override
	public void delete(int n) {
		if(last == null) {
			System.out.println("Empty list! Insert something first!");
			return;
		}
		Node node = last.next; //first element
		Node prev = last;
		int found = 0;
		//at the beginning node == last.next therefore i use the do-while, to test the condition when "node" is already updated
		if(node != prev) {	//there are at least 2 elements in the list
			do {
				if(node.value == n) {
					found = 1;
					prev.next = node.next;
					if(node == last)
						if(prev != last)  
							last = prev;
				}
				prev = node;
				node = node.next;
			}
			while(node != last.next);	
			

			if(found == 0)
				System.out.println("there is no "+n+" in the list");
		}
		else 		// if there is just 1 element, node == last.next
			if(node.value == n)
				last = null;	
			else
				System.out.println("there is no "+n+" in the list");
	}
		
	
	
	
	public String toString() {			
		String s = ("[");
		if(last != null) {
			Node n = last.next; //first element
			do {
				s += " "+n.value;
				n = n.next;
			}
			while(n != last.next) ;
		}
		s += (" ]");
		return s;		
	}
	
	
	
	class Node{
		public Node next;
		public int value;
		
		public Node(Node n, int val) {
			next = n;
			value = val;
		}
	}
	
	
	
	public static void main(String[] args) { 
		CircularSinglyList list = new CircularSinglyList();
		
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
				
		// error - there is no 5 in the list
		//[ 1 3 ]
		list.delete(5);
		System.out.println(list);
		
		//[ 3 ]
		list.delete(1);
		System.out.println(list);
		
		//[ ]
		list.delete(3);
		System.out.println(list);
		
		//empty list
		list.delete(3);
		System.out.println(list);

	}

	

}
