class TrieNode{
    TrieNode[] child=new TrieNode[26];
    String word;

}

public class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> res=new ArrayList<>();
        int m=board.length;
        if(m==0) return res;
        int n=board[0].length;
        TrieNode root=buildTrie(words);
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                explore(board,i,j,root,res);
            }
        }
        return res;
    }
    public void explore(char[][] board,int i,int j,TrieNode p,List<String> res){
        char c=board[i][j];
        if(c=='#'||p.child[c-'a']==null) return;
        p=p.child[c-'a'];
        board[i][j]='#';
        if(p.word!=null){
            res.add(p.word);
            p.word=null;
        }
        if(i>0) explore(board,i-1,j,p,res);
        if(i<board.length-1) explore(board,i+1,j,p,res);
        if(j>0) explore(board,i,j-1,p,res);
        if(j<board[0].length-1) explore(board,i,j+1,p,res);
        board[i][j]=c;
        
    }
    public TrieNode buildTrie(String[] words){
        TrieNode root=new TrieNode();
        for(String word:words){
            TrieNode p=root;
            for(int i=0;i<word.length();i++){
                int k=word.charAt(i)-'a';
                if(p.child[k]==null)
                    p.child[k]=new TrieNode();
                p=p.child[k];
            }
            p.word=word;
        }
        return root;
    }
    
}