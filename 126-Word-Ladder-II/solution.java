class Node{
    String word;
    int dist;
    List<Node> prev;
    public Node(int dist,String s){
        this.word=s;
        this.dist=dist;
        prev=new ArrayList<>();
    }
}
public class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, Set<String> wordList) {
        List<List<String>> res=new ArrayList<>();
        Map<String,Node> map=new HashMap<>();
        Queue<String> q=new LinkedList<>();
        wordList.add(endWord);
        q.offer(beginWord);
        Node root=new Node(1,beginWord);
        map.put(beginWord,root);
        while(!q.isEmpty()){
            int size=q.size();
            String str=q.poll();
            if(str.equals(endWord)){
                getPath(map.get(endWord),map,new ArrayList<String>(),res);
                return res;
            }
            char[] newchar=str.toCharArray();
            for(int i=0;i<newchar.length;i++){
                char old=newchar[i];
                for(char c='a';c<='z';c++){
                    newchar[i]=c;
                    String newstr=new String(newchar);
                    if(wordList.contains(newstr)){
                        if(!map.containsKey(newstr)){
                            Node node=map.get(str);
                            Node newnode=new Node(node.dist+1,newstr);
                            newnode.prev.add(node);
                            map.put(newstr,newnode);
                            q.offer(newstr);
                        }
                        else{
                            Node node=map.get(str);
                            Node newnode=map.get(newstr);
                            if(node.dist+1==newnode.dist){
                                newnode.prev.add(node);
                            }
                        }
                    }
                }
                newchar[i]=old;
            }
        }
        return res;
    }
    public void getPath(Node node,Map<String,Node> map,List<String> solu,List<List<String>> res){
        if(node==null){
            res.add(solu);
            return;
        }
        solu.add(0,node.word);
        if(!node.prev.isEmpty()){
            for(Node prev:node.prev)
                getPath(prev,map,new ArrayList(solu),res);
        }
        else getPath(null,map,new ArrayList(solu),res);
    }
}