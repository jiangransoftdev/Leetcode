public class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, Set<String> wordList) {
        List<List<String>> res=new ArrayList<>();
        Map<String,List<String>> neighbors=new HashMap<>();
        Map<String,Integer> distance=new HashMap<>();
        List<String> solu=new ArrayList<>();
        wordList.add(endWord);
        Bfs(beginWord,endWord,wordList,neighbors,distance);
        Dfs(beginWord,endWord,wordList,neighbors,distance,solu,res);
        return res; 
    }
    public void Bfs(String start, String end, Set<String> dict, Map<String, List<String>> nodeNeighbors, Map<String, Integer> distance){
        for(String str:dict)
            nodeNeighbors.put(str,new ArrayList<>());
        Queue<String> queue=new LinkedList<>();
        queue.offer(start);
        distance.put(start,0);
        while(!queue.isEmpty()){
            int count=queue.size();
            Boolean foundEnd=false;
            for(int i=0;i<count;i++){
                 String cur=queue.poll();
                 int curDistance=distance.get(cur);
                 List<String> neighbors=getNeighbors(cur,dict);
                 for(String neighbor:neighbors){
                     nodeNeighbors.get(cur).add(neighbor);
                     if(!distance.containsKey(neighbor)){
                         distance.put(neighbor,curDistance+1);
                         if(end.equals(neighbor))
                            foundEnd=true;
                         else queue.offer(neighbor);
                     }
                     
                 }
            }
            if(foundEnd) break;
        }
    }
    public void Dfs(String cur, String end, Set<String> dict,Map<String,List<String>> nodeNeighbors, Map<String, Integer> distance, List<String> solu, List<List<String>> res){
            solu.add(cur);
            if(end.equals(cur))
                res.add(new ArrayList<>(solu));
            else{
                List<String> neighbors=nodeNeighbors.get(cur);
                for(String neighbor:neighbors){
                    if(distance.get(neighbor)==distance.get(cur)+1)
                        Dfs(neighbor,end,dict,nodeNeighbors,distance,solu,res);
                }
            }
            solu.remove(solu.size()-1);
    }
    public List<String> getNeighbors(String cur,Set<String> dict){
        List<String> res=new ArrayList<>();
        char[] chs=cur.toCharArray();
        for(int i=0;i<chs.length;i++){
            for(char ch='a';ch<='z';ch++){
                if(chs[i]==ch) continue;
                char old=chs[i];
                chs[i]=ch;
                String another=new String(chs);
                if(dict.contains(another))
                    res.add(another);
                chs[i]=old;
            }
        }
        return res;
        
    }
}