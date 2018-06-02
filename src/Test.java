
public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SingleLinkedList list = new SingleLinkedList();
		
		// error - linked list empty
		list.delete(new Node(1));
		
		//[ 3 ]
		list.addLast(new Node(3));
		System.out.println(list);
		
		//[ 2 3 ]
		list.addFirst(new Node(2));
		System.out.println(list);
		
		//[ 1 2 3 ]
		list.addFirst(new Node(1));
		System.out.println(list);
		
		//[ 1 2 3 4 ]
		list.addLast(new Node(4));
		System.out.println(list);
		
		//[ 1 2 3 ]
		list.delete(new Node(4));
		System.out.println(list);
		
		//[ 1 3 ]
		list.delete(new Node(2));
		System.out.println(list);
		
		// error - there is no such an element in the list
		list.delete(new Node(5));
		System.out.println(list);
	}

}
