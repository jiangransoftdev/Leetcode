public class Solution {
    public int shortestWordDistance(String[] words, String word1, String word2) {
        int pos1=-1,pos2=-1,res=Integer.MAX_VALUE;
        for(int i=0;i<words.length;i++){
            if(word1.equals(word2)&&words[i].equals(word1)){
                if(pos1!=-1) res=Math.min(res,i-pos1);
                 pos1=i;
            }
            else{
                if(word1.equals(words[i])) pos1=i;
                if(word2.equals(words[i])) pos2=i;
                if(pos1!=-1&&pos2!=-1) res=Math.min(res,Math.abs(pos1-pos2));
            }
        }
        return res;
    }
}