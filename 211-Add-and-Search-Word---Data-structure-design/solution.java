class TrieNode {
    TrieNode[] child;
    boolean isEnd;
    public TrieNode() {
        child=new TrieNode[26];
        isEnd=false;
    }
}
public class WordDictionary {
    TrieNode root=new TrieNode();
    // Adds a word into the data structure.
    public void addWord(String word) {
        TrieNode p=root;
        for(int i=0;i<word.length();i++){
            int index=word.charAt(i)-'a';
            if(p.child[index]==null)
                p.child[index]=new TrieNode();
            p=p.child[index];
        }
        p.isEnd=true;
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        return searchNode(word,root,0);
    }
    public boolean searchNode(String word,TrieNode p,int i){
        if(p==null) return false;
        if(i==word.length()){
            if(p.isEnd) return true;
            else return false;
        }
        char c=word.charAt(i);
        if(c=='.'){
            for(int j=0;j<26;j++)
                if(searchNode(word,p.child[j],i+1)) return true;
        }
        else if (searchNode(word,p.child[c-'a'],i+1)) return true;
        return false;
    }
}

// Your WordDictionary object will be instantiated and called as such:
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("word");
// wordDictionary.search("pattern");