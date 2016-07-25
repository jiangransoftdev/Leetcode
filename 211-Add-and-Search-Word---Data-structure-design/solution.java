class TrieNode{
    TrieNode[] child;
    boolean isEnd;
    public TrieNode(){
        this.child=new TrieNode[26];
        isEnd=false;
    }
}
public class WordDictionary {
    TrieNode root;
    boolean res;
    public WordDictionary(){
        root=new TrieNode();
        res=false;
    }
    // Adds a word into the data structure.
    public void addWord(String word) {
        TrieNode p=root;
        for(int i=0;i<word.length();i++){
            int k=word.charAt(i)-'a';
            if(p.child[k]==null){
                p.child[k]=new TrieNode();
            }
            p=p.child[k];
        }
        p.isEnd=true;
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        TrieNode p=root;
        return searchNode(word,0,p);
    }
    public boolean searchNode(String word,int index,TrieNode p){
        if(index==word.length()){
            if(p!=null)
                if(p.isEnd) return true;
            return false;
        }
        if(p==null) return false;
        if(word.charAt(index)=='.'){
            for(int i=0;i<26;i++){
                res=searchNode(word,index+1,p.child[i]);
                if(res) return res;
            }
        }
        else{
            int k=word.charAt(index)-'a';
            if(p.child[k]!=null)
                res=searchNode(word,index+1,p.child[k]);
            else return false;
        }
        return res;
    }
}

// Your WordDictionary object will be instantiated and called as such:
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("word");
// wordDictionary.search("pattern");