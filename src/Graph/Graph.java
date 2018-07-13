package Graph;

import java.util.LinkedList;

public class Graph {
	
	private final int V;
	
	private LinkedList<Integer> adj[];
	
	
	public Graph(int vertices) {
		V = vertices;
		adj = new LinkedList[V];
		for (int i = 0; i < V; i++) {
			adj[i] = new LinkedList<Integer>();
 		}
		
	}
	
	
	
	public void addEdge(int v, int u) {
		adj[v].add(u);
	}
	
	
	/**
	 * Creates the visited array (or map)
	 * and then calls the function for the traversal
	 * @param v
	 */
	public void DFS(int v) {
		// works if the vertices are in order [0,1,2,3,4]
		// otherwise use a map
		boolean[] visited = new boolean[V];
		DFStraversal(v, visited);
	}
	
	
	/**
	 * Traverses the graph taking a vertex from the adj[] if it has not been visited yet
	 * recursively iterates
	 * @param vertex
	 * @param visited
	 */
	void DFStraversal(int vertex, boolean visited[]) {
		visited[vertex] = true;
		System.out.print(vertex+ " ");
		
		for (int v : adj[vertex])
			if(!visited[v])
				DFStraversal(v, visited);
		
	}
	
	
	
	public void BFS(int v) {
		boolean visited[] = new boolean[V];
		
		LinkedList<Integer> queue = new LinkedList<Integer>();
		
		queue.add(v);
		visited[v] = true;

		while(!queue.isEmpty()) {
			
			v = queue.pop();
			System.out.print(v+ " ");
			 
			for (int vertex : adj[v]) {
				if(!visited[vertex]) {
					visited[vertex] = true;
					//System.out.println("adding to the queue "+ vertex);
					queue.add(vertex);
				}
			}
			
		}
				
	}
	
	
	
	public static void main(String args[])
    {
        Graph g = new Graph(4);
 
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
 
        System.out.println("Following is a Depth First Traversal "+
                           "(starting from vertex 2)");
 
        g.DFS(2);
        
        System.out.println("\nFollowing is Breadth First Traversal "+
                "(starting from vertex 2)");
        
        g.BFS(2);
    }

}
