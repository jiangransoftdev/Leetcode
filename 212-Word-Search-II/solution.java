class TrieNode{
    TrieNode[] child;
    String word;
    public TrieNode(){
        child=new TrieNode[26];
    }
}
public class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> res=new ArrayList<>();
        int m=board.length;
        if(m==0) return res;
        int n=board[0].length;
        TrieNode p=build(words);
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                helper(board,i,j,p,res);
            }
        }
        return res;
    }
    public void helper(char[][] board,int i,int j,TrieNode p,List<String> res){
        char c=board[i][j];
        if(c=='#'||p.child[c-'a']==null) return;
        board[i][j]='#';
        p=p.child[c-'a'];
        if(p.word!=null){
            res.add(p.word);
            p.word=null;
        }
        if(i>0) helper(board,i-1,j,p,res);
        if(i<board.length-1) helper(board,i+1,j,p,res);
        if(j>0) helper(board,i,j-1,p,res);
        if(j<board[0].length-1) helper(board,i,j+1,p,res);
        board[i][j]=c;
    }
    public TrieNode build(String[] words){
        TrieNode root=new TrieNode();
        for(String str:words){
            TrieNode p=root;
            for(int i=0;i<str.length();i++){
            int index=str.charAt(i)-'a';
            if(p.child[index]==null){
                p.child[index]=new TrieNode();
            }
            p=p.child[index];
        }
        p.word=str;
        }
        return root;
    }
}