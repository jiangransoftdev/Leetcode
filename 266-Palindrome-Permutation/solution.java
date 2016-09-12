public class Solution {
    public boolean canPermutePalindrome(String s) {
        int[] hash=new int[256];
        for(int i=0;i<s.length();i++)
            hash[s.charAt(i)]++;
        int count=0;
        for(int i=0;i<hash.length;i++){
            if(s.length()%2==0){
                if(hash[i]%2!=0) return false;
            }
            else{
                if(hash[i]%2!=0) count++;
            }
        }
        if(s.length()%2!=0&&count!=1) return false;
        return true;
    }
}