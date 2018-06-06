package Hierarchical;

public class Node<E> {

	public E value;
	public Node<E> left;
	public Node<E> right;
	
	
	public Node(E v) {
		value = v;
	}
}
