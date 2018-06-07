package Hierarchical;

public class BST {
	
	public Node root;
	
	public void add(int val) {
		root = insert(val, root);
	}
	
	public Node insert(int val, Node root) {
		if(root == null) {
			return new Node<Integer>(val);
		}
		
		else if(val < (int)root.value) 
			root.left = insert(val, root.left);
		
		else
			root.right = insert(val, root.right);
		
		return root;

	}
	
	public String toString() {
		return toString(root);
	}
	
	
	public String toString(Node n) {
		String s = "";
		if(n == null) //on all the leaves
			return " ";
		s += toString(n.left);
		s += n.value;
		s += toString(n.right);
		return s;
		
	}
	
	
	public static void main(String[] args) {
		BST bst = new BST();
		bst.add(3);
		bst.add(4);
		bst.add(5);
		bst.add(6);
		System.out.println("bst (3 4 5 6) : "+bst.toString());
	}
	

}
