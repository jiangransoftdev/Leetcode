public class Solution {
    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        Queue<String> q=new LinkedList<>();
        if(beginWord.equals(endWord)) return 0;
        int length=1;
        wordList.add(endWord);
        wordList.remove(beginWord);
        q.offer(beginWord);
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                String s=q.poll();
                if(s.equals(endWord)) return length;
                char[] cs=s.toCharArray();
                for(int l=0;l<s.length();l++){
                    char c=cs[l];
                    for(char cc='a';cc<='z';cc++){
                        cs[l]=cc;
                        String another=new String(cs);
                        if(wordList.contains(another)){
                            q.offer(another);
                            wordList.remove(another);
                        }
                    }
                    cs[l]=c;
                }
            }
            length++;
        }
        return 0;
    }
}