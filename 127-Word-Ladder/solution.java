public class Solution {
    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        Queue<String> q=new LinkedList<>();
        int distance=1;
        q.offer(beginWord);
        wordList.remove(beginWord);
        wordList.add(endWord);
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                String cur=q.poll();
                if(cur.equals(endWord)) return distance;
                List<String> neighbor=find(cur,wordList);
                for(String s:neighbor)
                    q.offer(s);
            }
            distance++;
        }
        return 0;
    }
    public List<String> find(String cur,Set<String> wordList){
        List<String> res=new ArrayList<>();
        for(int i=0;i<cur.length();i++){
            char[] c=cur.toCharArray();
            for(char x='a';x<='z';x++){
                c[i]=x;
                String another=new String(c);
                if(wordList.contains(another)){
                    res.add(another);
                    wordList.remove(another);
                }
            }
        }
        return res;
    }
}