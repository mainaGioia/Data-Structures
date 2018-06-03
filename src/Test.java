public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SinglyLinkedList list = new SinglyLinkedList();
		
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
	}

}
