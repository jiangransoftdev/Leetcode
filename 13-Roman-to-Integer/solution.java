public class Solution {
    public int romanToInt(String s) {
        int res=0,pre=0;
        for(int i=s.length()-1;i>=0;i--){
            char num=s.charAt(i);
            int cur=0;
            switch(num){
                case 'I':cur=1;break;
                case 'V':cur=5;break;
                case 'X':cur=10;break;
                case 'L':cur=50;break;
                case 'C':cur=100;break;
                case 'D':cur=500;break;
                case 'M':cur=1000;break;
                default:
            }
            if(cur<pre) res-=cur;
            else res+=cur;
            pre=cur;
        }
        return res;
    }
}