public class Solution {
    public int romanToInt(String s) {
        int last=0,cur=0,res=0;
        for(int i=s.length()-1;i>=0;i--){
            char c=s.charAt(i);
            switch(c){
                case 'I':cur=1;break;
                case 'V':cur=5;break;
                case 'X':cur=10;break;
                case 'L':cur=50;break;
                case 'C':cur=100;break;
                case 'D':cur=500;break;
                case 'M':cur=1000;break;
                default:
            }
            if(cur<last) res-=cur;
            else res+=cur;
            last=cur;
        }
        return res;
    }
}