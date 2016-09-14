
class TrieNode {
    TrieNode[] child;
    boolean isEnd;
    // Initialize your data structure here.
    public TrieNode() {
        child=new TrieNode[26];
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
            int index=word.charAt(i)-'a';
            if(p.child[index]==null)
                p.child[index]=new TrieNode();
            p=p.child[index];
        }
        p.isEnd=true;
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode p=searchNode(word,root);
        if(p!=null){
            if(p.isEnd)
                return true;
        }
        return false;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        TrieNode p=searchNode(prefix,root);
        return p!=null;
    }
    public TrieNode searchNode(String word,TrieNode p){
        for(int i=0;i<word.length();i++){
            int index=word.charAt(i)-'a';
            if(p.child[index]==null) return null;
            p=p.child[index];
        }
        return p;
    }
}

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");