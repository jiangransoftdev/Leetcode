class Node{
    String str;
    LinkedList<Node> prev;
    int dist;
    public Node(String str,int dist){
        this.str=str;
        this.dist=dist;
        this.prev=new LinkedList<>();
    }
}
public class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, Set<String> wordList) {
        List<List<String>> res=new ArrayList<>();
        Map<String,Node> map=new HashMap<>();
        Queue<String> q=new LinkedList<>();
        wordList.add(endWord);
        Node startnode=new Node(beginWord,1);
        map.put(beginWord,startnode);
        q.offer(beginWord);
        while(!q.isEmpty()){
            String str=q.poll();
            if(str.equals(endWord)){
                getPath(map.get(endWord),new ArrayList<>(),res);
                return res;
            }
            char[] newchar=str.toCharArray();
            for(int i=0;i<str.length();i++){
                char old=newchar[i];
                for(char c='a';c<='z';c++){
                    newchar[i]=c;
                    String newstr=new String(newchar);
                    if(wordList.contains(newstr)){
                        if(!map.containsKey(newstr)){
                            Node node=map.get(str);
                            Node newnode=new Node(newstr,node.dist+1);
                            newnode.prev.add(node);
                            map.put(newstr,newnode);
                            q.offer(newstr);
                        }
                        else{
                            Node node=map.get(str);
                            Node newnode=map.get(newstr);
                            if(newnode.dist==node.dist+1)
                                newnode.prev.add(node);
                        }
                    }
                }
                newchar[i]=old;
            }
        }
        return res;
    }
    public void getPath(Node end,List<String> curpath,List<List<String>> res){
        if(end==null){
            res.add(curpath);
            return;
        }
        curpath.add(0,end.str);
        if(!end.prev.isEmpty()){
            for(Node node:end.prev)
                getPath(node,new ArrayList<>(curpath),res);
        }
        else getPath(null,new ArrayList<>(curpath),res);
    }
}