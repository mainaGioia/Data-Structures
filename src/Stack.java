
/**
 * LIFO last in first out structure
 * @author alessandra
 *
 * @param <E>
 */
public class Stack<E> {
	
	public Node<E> top;
	public SinglyLinkedList<E> list;
	
	public Stack() {
		list = new SinglyLinkedList<E>();
	}
	
	
	public void push(E el) {
		top = new Node<E>(el, null);
		list.addFirst(el);
	}
	
	public E peek() {
		if(top != null)
			return top.value;
		System.out.println("Empty stack");
		return null;
	}
	
	public E pop() {
		if(top!=null) {
			E element = peek();
			list.delete(element);
			if(list.head == null)
				top = null;
			else top = list.head;
			return element;
		}
		System.out.println("Empty stack");
		return null;		
	}
	
	
	public static void main(String[] args) {
		
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(5);
		//peek: 5
		//stack: [5]
		System.out.println("peek: "+stack.peek());
		System.out.println("stack: "+stack.list);

		stack.push(4);
		//peek: 4
		//stack: [ 4 5 ]
		System.out.println("peek: "+stack.peek());
		System.out.println("stack: "+stack.list);

		stack.push(3);
		//peek: 3
		//Stack: [ 3 4 5 ]
		System.out.println("peek: "+stack.peek());
		System.out.println("stack: "+stack.list);
		
		stack.push(2);
		//peek: 2
		//stack: [ 2 3 4 5 ]
		System.out.println("peek: "+stack.peek());
		System.out.println("stack: "+stack.list);
		
		stack.push(1);
		//peek: 1
		//stack: [ 1 2 3 4 5 ]
		System.out.println("peek: "+stack.peek());
		System.out.println("stack: "+stack.list);
		
		System.out.println("Expected 1: "+stack.pop());
		System.out.println("stack: "+stack.list);

		System.out.println("peek(2): "+stack.peek());
		System.out.println("Expected 2: "+stack.pop());
		System.out.println("stack: "+stack.list);

		System.out.println("peek(3): "+stack.peek());
		System.out.println("Expected 3: "+stack.pop());
		System.out.println("stack: "+stack.list);

		System.out.println("peek(4): "+stack.peek());
		System.out.println("Expected 4: "+stack.pop());
		System.out.println("stack: "+stack.list);

		System.out.println("peek(5): "+stack.peek());
		System.out.println("Expected 5: "+stack.pop());
		System.out.println("stack: "+stack.list);

		System.out.println("peek(null): "+stack.peek());
		System.out.println("Expected null: "+stack.pop());
		
	
	}

}






