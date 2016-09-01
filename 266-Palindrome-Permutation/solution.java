public class Solution {
    public boolean canPermutePalindrome(String s) {
        int[] count=new int[256];
        for(int i=0;i<s.length();i++)
            count[s.charAt(i)]++;
        boolean even=(s.length()%2==0);
        if(even){
            for(int i=0;i<count.length;i++)
                if(count[i]%2!=0) return false;
        }
        else{
            int single=0;
            for(int i=0;i<count.length;i++){
                if(count[i]%2==1) single++;
                
            }
            if(single!=1) return false;
        }
        return true;
    }
}