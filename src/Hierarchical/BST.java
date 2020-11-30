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
		return printTree(root);
	}
	
	
	public String printTree(Node n) {
		String s = "";
		if(n == null) //on all the leaves
			return " ";
		s += printTree(n.left);
		s += n.value;
		s += printTree(n.right);
		return s;
		
	}
	
	
	public String preorder() {
		return preorderTraversal(root);
	}
	
	
	private String preorderTraversal(Node n) {
		String s = "";
		if(n == null)
			return "";
		s += n.value;
		s += preorderTraversal(n.left);
		s += preorderTraversal(n.right);
		return s;
	}
	
	
	public String inorder() {
		return inorderTraversal(root);
	}
	
	
	private String inorderTraversal(Node n) {
		String s = "";
		if(n == null)
			return "";
		s += inorderTraversal(n.left);
		s += n.value;
		s += inorderTraversal(n.right);
		return s;		
	}
	
	
	public String postorder() {
		return postorderTraversal(root);
	}
	
	
	private String postorderTraversal(Node n) {
		String s = "";
		if(n == null)
			return "";
		s += postorderTraversal(n.left);
		s += postorderTraversal(n.right);
		s += n.value;
		return s;
	}
	
	
	
	public static void main(String[] args) {
		BST bst = new BST();
		bst.add(3);
		bst.add(4);
		bst.add(5);
		bst.add(6);
		System.out.println("bst (3 4 5 6) : "+bst.toString());
		System.out.println("root (3): "+bst.root.value );
		System.out.println("preorder (3 4 5 6): "+bst.preorder() );
		System.out.println("inorder (3 4 5 6): "+bst.inorder() );
		System.out.println("postorder (3 4 5 6): "+bst.postorder() );
	}
	

}
