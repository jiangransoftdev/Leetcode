class TrieNode{
    TrieNode[] child;
    boolean isEnd;
    public TrieNode(){
        child=new TrieNode[26];
        isEnd=false;
    }
}
public class WordDictionary {
    private TrieNode root;
    public WordDictionary(){
        root=new TrieNode();
    }
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
        TrieNode p=root;
        return helper(word,0,p);
    }
    public boolean helper(String word,int index,TrieNode p){
        boolean res=false;
        if(p==null) return false;
        if(index==word.length()){
            if(p.isEnd) return true;
            else return false;
        }
        if(word.charAt(index)=='.'){
            for(int i=0;i<26;i++)
                res|=helper(word,index+1,p.child[i]);
        }
        else
            res|=helper(word,index+1,p.child[word.charAt(index)-'a']);
        return res;
    }
}

// Your WordDictionary object will be instantiated and called as such:
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("word");
// wordDictionary.search("pattern");