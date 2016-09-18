public class Solution {
    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        int len=1;
        Queue<String> q=new LinkedList<>();
        q.offer(beginWord);
        wordList.add(endWord);
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                String s=q.poll();
                if(s.equals(endWord)) return len;
                char[] schar=s.toCharArray();
                for(int j=0;j<schar.length;j++){
                    char old=schar[j];
                    for(char c='a';c<='z';c++){
                        schar[j]=c;
                        String ss=new String(schar);
                        if(wordList.contains(ss)){
                            q.offer(ss);
                            wordList.remove(ss);
                        } 
                    }
                    schar[j]=old;
                }
            }
            len++;
        }
        return 0;
    }
}