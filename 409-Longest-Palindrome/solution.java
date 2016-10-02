public class Solution {
    public int longestPalindrome(String s) {
        int mid=0,len=0;
        int[] count=new int[256];
        for(int i=0;i<s.length();i++)
            count[s.charAt(i)]++;
        for(int i=0;i<count.length;i++){
            if(count[i]!=0){
                len+=(count[i]/2)*2;
                count[i]=count[i]%2;
                if(count[i]%2!=0)
                    mid=1;
            }
        }
        return len+mid;
    }
}