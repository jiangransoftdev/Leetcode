public class Solution {
    public int shortestWordDistance(String[] words, String word1, String word2) {
        int index=-1,res=words.length;
        for(int i=0;i<words.length;i++){
            if(words[i].equals(word1)||words[i].equals(word2)){
                if(index!=-1&&(word1.equals(word2)||!words[index].equals(words[i])))
                    res=Math.min(i-index,res);
                index=i;
            }
            
        }
        return res;
    }
}