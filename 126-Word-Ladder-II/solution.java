class Node{
    String word;
    int dist;
    LinkedList<Node> prev;
    public Node(String s,int dist){
        this.word=s;
        this.dist=dist;
        prev=new LinkedList<>();
    }
}
public class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, Set<String> wordList) {
        List<List<String>> res=new ArrayList<>();
        Map<String,Node> map=new HashMap<>();
        Queue<String> q=new LinkedList<>();
        Node startnode=new Node(beginWord,1);
        map.put(beginWord,startnode);
        q.offer(beginWord);
        while(!q.isEmpty()){
            String str=q.poll();
            if(str.equals(endWord)){
                getPath(map.get(str),new ArrayList<>(),res);
                return res;
            }
            char[] schar=str.toCharArray();
            for(int i=0;i<schar.length;i++){
                char old=schar[i];
                for(char c='a';c<='z';c++){
                    schar[i]=c;
                    String newstr=new String(schar);
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
                schar[i]=old;
            }
        }
        return res;
    }
    public void getPath(Node end,List<String> solu,List<List<String>> res){
        if(end==null){
            res.add(new ArrayList(solu));
            return;
        }
        solu.add(0,end.word);
        LinkedList<Node> list=end.prev;
        if(!list.isEmpty()){
            for(Node node:list){
                getPath(node,new ArrayList(solu),res);
            }
        }
        else
            getPath(null,new ArrayList(solu),res);
        
    }
}