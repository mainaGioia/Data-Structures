
public class Queue<E> {
	
	public CircularSinglyList<E> list;
	public Node<E> rear;
	
	public Queue(){
		list = new CircularSinglyList<E>();
	}
	
	public void enqueue(E el) {
		if(list.last == null)
			rear = new Node(el, null);
		list.addFirst(el);
	}
	
	public E dequeue() {
		E val = rear.value;
		list.delete(rear.value);
		rear = list.last;
		return val;
	}
	
	
	public static void main(String[] args) {
		
		Queue<Integer> queue = new Queue<Integer>();
		
		queue.enqueue(5);
		System.out.println("queue [5]: "+queue.list);
		System.out.println("rear [5]: "+queue.rear.value);
		queue.enqueue(4);
		System.out.println("queue [4 5]: "+queue.list);
		System.out.println("rear [5]: "+queue.rear.value);
		queue.enqueue(3);
		System.out.println("queue [3 4 5]: "+queue.list);
		queue.enqueue(2);
		System.out.println("queue [2 3 4 5]: "+queue.list);
		queue.enqueue(1);
		System.out.println("queue [1 2 3 4 5]: "+queue.list);

		System.out.println("dequeue (5): "+queue.dequeue());
		System.out.println("queue [1 2 3 4]: "+queue.list);
		System.out.println("rear [4]: "+queue.rear.value);

		System.out.println("dequeue (4): "+queue.dequeue());
		System.out.println("queue [1 2 3]: "+queue.list);
		System.out.println("rear [3]: "+queue.rear.value);

		System.out.println("dequeue (3): "+queue.dequeue());
		System.out.println("queue [1 2]: "+queue.list);
		System.out.println("rear [2]: "+queue.rear.value);

		System.out.println("dequeue (2): "+queue.dequeue());
		System.out.println("queue [1]: "+queue.list);
		System.out.println("rear [1]: "+queue.rear.value);
		
		System.out.println("dequeue (1): "+queue.dequeue());
		System.out.println("queue []: "+queue.list);
		System.out.println("rear null: "+queue.rear);


		
	}

}
