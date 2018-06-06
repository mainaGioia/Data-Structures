package Linear;

/**
 * Class node 
 * Contains a value (integer) and a pointer to the next node
 * @author alessandra
 *
 */
public class Node<E>{
	public E value;
	public Node<E> next;
	
	public Node(E val, Node<E> n) {
		value = val;
		next = n;
	}
}