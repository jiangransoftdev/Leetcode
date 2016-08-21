class TrieNode{
    TrieNode[] next;
    int index;
    List<Integer> list;
    public TrieNode(){
        next=new TrieNode[26];
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
        for(int j=words[i].length()-1;j>=0;j--){
            int index=words[i].charAt(j)-'a';
            if(root.next[index]==null)
                root.next[index]=new TrieNode();
            if(isPanlindrome(words[i],0,j))
                root.list.add(i);
            root=root.next[index];
        }
        root.index=i;
        root.list.add(i);
    }
    public boolean isPanlindrome(String word,int i,int j){
        while(i<=j){
            if(word.charAt(i++)!=word.charAt(j--))
                return false;
        }
        return true;
    }
    public void searchNode(String[] words,int index,TrieNode root,List<List<Integer>> res){
        for(int i=0;i<words[index].length();i++){
            if(root.index>=0&&root.index!=index&&isPanlindrome(words[index],i,words[index].length()-1))
                res.add(Arrays.asList(index,root.index));
            root=root.next[words[index].charAt(i)-'a'];
            if(root==null) return;
        }
        for(int i:root.list){
            if(i==index) continue;
            res.add(Arrays.asList(index,i));
        }
    }
}