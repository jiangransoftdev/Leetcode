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
        if(words.length==0) return res;
        TrieNode root=new TrieNode();
        for(int i=0;i<words.length;i++)
            addNode(words,i,root);
        for(int i=0;i<words.length;i++)
            searchNode(words,i,root,res);
        return res;
    }
    public void addNode(String[] words,int index,TrieNode root){
        for(int i=words[index].length()-1;i>=0;i--){
            int idx=words[index].charAt(i)-'a';
            if(root.child[idx]==null)
                root.child[idx]=new TrieNode();
            if(isPanlindrome(words[index],0,i))
                root.list.add(index);
            root=root.child[idx];
        }
        root.index=index;
        root.list.add(index);
    }
    public void searchNode(String[] words,int index,TrieNode root,List<List<Integer>> res){
        for(int i=0;i<words[index].length();i++){
            if(root.index>=0&&root.index!=index&&isPanlindrome(words[index],i,words[index].length()-1))
                res.add(Arrays.asList(index,root.index));
            root=root.child[words[index].charAt(i)-'a'];
            if(root==null) return;
        }
        for(int i:root.list){
            if(i==index) continue;
            res.add(Arrays.asList(index,i));
        }
    }
    public boolean isPanlindrome(String s,int i,int j){
        while(i<=j){
            if(s.charAt(i++)!=s.charAt(j--))
                return false;
        }
        return true;
    }
}