class TrieNode{
    TrieNode[] child;
    int index;
    List<Integer> list;
    public TrieNode(){
        child=new TrieNode[26];
        index=-1;
        list=new ArrayList<>();
    }
}
public class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> res=new ArrayList<>();
        TrieNode root=new TrieNode();
        for(int i=0;i<words.length;i++)
            addNode(words,i,root);
        for(int i=0;i<words.length;i++)
            searchNode(words,i,root,res);
        return res;
    }
    public void addNode(String[] words,int i,TrieNode root){
        String word=words[i];
        for(int j=word.length()-1;j>=0;j--){
            int index=word.charAt(j)-'a';
            if(root.child[index]==null)
                root.child[index]=new TrieNode();
            if(isPalindrome(word,0,j))
                root.list.add(i);
            root=root.child[index];
        }
        root.index=i;
        root.list.add(i);
    }
    public boolean isPalindrome(String s,int i,int j){
        while(i<j){
            if(s.charAt(i++)!=s.charAt(j--)) return false;
        }
        return true;
    }
    public void searchNode(String[] words,int index,TrieNode root,List<List<Integer>> res){
        for(int i=0;i<words[index].length();i++){
            if(root.index>=0&&root.index!=index&&isPalindrome(words[index],i,words[index].length()-1))
                res.add(Arrays.asList(index,root.index));
            root=root.child[words[index].charAt(i)-'a'];
            if(root==null) return;
        }
        for(int j:root.list){
            if(index==j) continue;
            res.add(Arrays.asList(index,j));
        }
    }
    
}