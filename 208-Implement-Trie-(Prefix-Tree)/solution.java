class TrieNode {
    // Initialize your data structure here.
    TrieNode[] child;
    boolean isEnd;
    public TrieNode() {
        this.child=new TrieNode[26];
        isEnd=false;
    }
}

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        TrieNode p=root;
        for(int i=0;i<word.length();i++){
            int k=word.charAt(i)-'a';
            if(p.child[k]==null){
                TrieNode tmp=new TrieNode();
                p.child[k]=tmp;
            }
            p=p.child[k];
        }
        p.isEnd=true;
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode p=searchNode(word);
        if(p!=null){
            if(p.isEnd)
                return true;
        }
        return false;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        TrieNode p=searchNode(prefix);
        if(p!=null)
            return true;
        return false;
    }
    public TrieNode searchNode(String word){
        TrieNode p=root;
        for(int i=0;i<word.length();i++){
            int k=word.charAt(i)-'a';
            if(p.child[k]!=null)
                p=p.child[k];
            else return null;
        }
        if(p==root) return null;
        return p;
    }
}

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");