class TrieNode{
    TrieNode[] child;
    String word;
    public TrieNode(){
        child=new TrieNode[26];
        word=null;
    }
}
public class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> res=new ArrayList<>();
        if(board.length==0) return res;
        int m=board.length,n=board[0].length;
        TrieNode root=new TrieNode();
        build(root,words);
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                helper(board,i,j,root,res);
            }
        }
        return res;
    }
    public void helper(char[][] board,int i,int j,TrieNode p,List<String> res){
        if(i<0||i>=board.length||j<0||j>=board[0].length||p==null||board[i][j]=='#') return;
        char c=board[i][j];
        int index=c-'a';
        board[i][j]='#';
        p=p.child[index];
        if(p!=null){
            if(p.word!=null){
            res.add(p.word);
            p.word=null;
        }
        }
        helper(board,i-1,j,p,res);
        helper(board,i+1,j,p,res);
        helper(board,i,j-1,p,res);
        helper(board,i,j+1,p,res);
        board[i][j]=c;
    }
    public void build(TrieNode root,String[] words){
        for(String word:words){
            TrieNode p=root;
            for(int i=0;i<word.length();i++){
                int index=word.charAt(i)-'a';
                if(p.child[index]==null)
                    p.child[index]=new TrieNode();
                p=p.child[index];
            }
            p.word=word;
        }
    }
}