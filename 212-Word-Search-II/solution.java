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
        if(words.length==0) return res;
        TrieNode root=build(words);
        int m=board.length,n=board[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++)
                helper(board,i,j,root,res);
        }
        return res;
    }
    public void helper(char[][] board,int i,int j,TrieNode root,List<String> res){
        if(i<0||j<0||i>=board.length||j>=board[0].length) return;
        char c=board[i][j];
        if(c=='#'||root.child[c-'a']==null) return;
        board[i][j]='#';
        root=root.child[c-'a'];
        if(root.word!=null){
            res.add(root.word);
            root.word=null;
        }
        helper(board,i-1,j,root,res);
        helper(board,i+1,j,root,res);
        helper(board,i,j-1,root,res);
        helper(board,i,j+1,root,res);
        board[i][j]=c;
    }
    public TrieNode build(String[] words){
        TrieNode root=new TrieNode();
        for(int i=0;i<words.length;i++){
            TrieNode p=root;
            String word=words[i];
            for(int j=0;j<word.length();j++){
                int index=word.charAt(j)-'a';
                if(p.child[index]==null)
                    p.child[index]=new TrieNode();
                p=p.child[index];
            }
            p.word=word;
        }
        return root;
    }
}