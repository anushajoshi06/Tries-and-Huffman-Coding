/*Code: Search word in Trie

Implement the function SearchWord for the Trie class.
For a trie, write the function for searching a word. Return true if found successfully otherwise return false.
*/

class TrieNode{

	char data;
	boolean isTerminating;
	TrieNode children[];
	int childCount;

	public TrieNode(char data) {
		this.data = data;
		isTerminating = false;
		children = new TrieNode[26];
		childCount = 0;
	}
}


public class Trie {

	private TrieNode root;
	public int count;
	public Trie() {
		root = new TrieNode('\0');
		count = 0;
	}	

	private boolean add(TrieNode root, String word){
		if(word.length() == 0){
			if (!root.isTerminating) {
				root.isTerminating = true;
				return true;
			} else {
				return false;
			}
		}		
		int childIndex = word.charAt(0) - 'a';
		TrieNode child = root.children[childIndex];
		if(child == null){
			child = new TrieNode(word.charAt(0));
			root.children[childIndex] = child;
			root.childCount++;
		}
		return add(child, word.substring(1));

	}

	public void add(String word){
		if (add(root, word)) {
			this.count++;
		}
	}
     public boolean search(TrieNode root,String word){
       if (word.length()==0){
         return root.isTerminating;
       }
       int childIndex = word.charAt(0) - 'a';
		TrieNode child = root.children[childIndex];
		if(child == null){
          return false;
          
        }
    return search(child, word.substring(1));
     }
	public boolean search(String word){
		// add your code here
      return search(root,word);
	}

	
}

