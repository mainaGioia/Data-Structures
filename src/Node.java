/**
 * Defines a simple basic node object
 * @author alessandra
 *
 */
public class Node {
	
	public int value;
	public Node next;
	
	
	public Node(int val) {
		value = val;
		next = null;
	}
	
	
	public boolean equals(Node n) {
		if(n == null)
			return false;
		return this.value == n.value;
	}

}
