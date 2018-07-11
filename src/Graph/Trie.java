package Graph;
/**
 * Also known as radix tree or prefix tree
 * Represented as a collection of TrieNodes,
 * each with its list of possible followers (tokens)
 * every level is made of a TrieNode[alpabeth_size] with sparse nodes
 * if (children[index] != null) that letter will be part of the key
 *       root
 *     /   |   \
 *    t    r    s
 *    |    |    |
 *    h    u    e
 *    |    |    |   \
 *    e($) n($)	a($) e($)
 *    |	   |
 *    i	   n...
 *    |
 *    r($)
 * @author alessandra
 */

public class Trie {
	
	static final int ALPABETH_SIZE = 26;
	TrieNode root = new TrieNode();
	

	class TrieNode{
	
		TrieNode[] children = new TrieNode[ALPABETH_SIZE];
		boolean isEndOfWord = false;
		
		
		public TrieNode() {
			for (int i = 0; i < ALPABETH_SIZE; i++)
				children[i] = null;
		}
	}
	
	
	/**
	 * Inserts a key into the trie. 
	 * Starting from the root, checks if that char is part of the trie,
	 * if not adds a new node in the corresponding position.
	 * @param key - word to add to the trie
	 */
	public void insert(String key) {
		TrieNode crawler = root;
		int length = key.length();
		
		for (int level = 0; level < length; level++) {
			
			int index = key.charAt(level) - 'a';
			
			if(crawler.children[index] == null) 
				crawler.children[index] = new TrieNode();
			
			crawler = crawler.children[index];
		}
		crawler.isEndOfWord = true;
	}
	
	
	public boolean search(String key) {
		TrieNode crawler = root;
		int length = key.length();
		
		for (int level = 0; level < length; level++) {
			int index = key.charAt(level) - 'a';
			if(crawler.children[index] == null)
				return false;
			crawler = crawler.children[index];
		}
		
		return crawler.isEndOfWord;
	}
	
	
	
	public static void main(String args[])
    {
        // Input keys (use only 'a' through 'z' and lower case)
        //String keys[] = {"the", "a", "there", "answer", "any", "by", "bye", "their"};
        String keys[] = {"a", "there", "answer", "any", "by", "bye", "their"};
      
        String output[] = {"Not present in trie", "Present in trie"};
      
      
      
        // Construct trie
        Trie t = new Trie();
        int i;
        for (i = 0; i < keys.length ; i++)
            t.insert(keys[i]);
      
        // Search for different keys
        if(t.search("the") == true)
            System.out.println("the --- " + output[1]); //not present in trie
        else System.out.println("the --- " + output[0]);
         
        if(t.search("these") == true)
            System.out.println("these --- " + output[1]);//not present in trie
        else System.out.println("these --- " + output[0]);
         
        if(t.search("their") == true)
            System.out.println("their --- " + output[1]);
        else System.out.println("their --- " + output[0]);//present in trie
         
        if(t.search("thaw") == true)
            System.out.println("thaw --- " + output[1]);//not present in trie
        else System.out.println("thaw --- " + output[0]);
        
        t.insert("the");
        if(t.search("the") == true)
            System.out.println("the --- " + output[1]); // present in trie
        else System.out.println("the --- " + output[0]);
         
        if(t.search("their") == true)
            System.out.println("these --- " + output[1]);//present in trie
        else System.out.println("these --- " + output[0]);
    }
	

}
