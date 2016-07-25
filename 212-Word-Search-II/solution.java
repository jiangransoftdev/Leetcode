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
                helper(board,i,j,root,res);
            }
        }
        return res;
    }
    public void helper(char[][] board,int i,int j,TrieNode root,List<String> res){
		char c=board[i][j];
		if(c=='#'||root.child[c-'a']==null) return;
		root=root.child[c-'a'];
		board[i][j]='#';
		if(root.word!=null){
			res.add(root.word);
			root.word=null;
		}
		if(i>0) helper(board,i-1,j,root,res);
		if(j>0) helper(board,i,j-1,root,res);
		if(i<board.length-1) helper(board,i+1,j,root,res);
		if(j<board[0].length-1) helper(board,i,j+1,root,res);
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