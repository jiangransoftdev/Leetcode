public class Solution {
    char[][] pairs={{'0','0'},{'1','1'},{'6','9'},{'8','8'},{'9','6'}};
    int count=0;
    public int strobogrammaticInRange(String low, String high) {
        for(int len=low.length();len<=high.length();len++)
            helper(low,high,new char[len],0,len-1);
        return count;
    }
    public void helper(String low,String high,char[] c,int left,int right){
        if(left>right){
            String s=new String(c);
            if((s.length()==low.length()&&s.compareTo(low)<0)||(s.length()==high.length()&&s.compareTo(high)>0)) return;
            count++;
            return;
        }
        for(char[] pair:pairs){
            c[left]=pair[0];
            c[right]=pair[1];
            if(c.length!=1&&c[0]=='0') continue;
            if(left<right||left==right&&pair[0]==pair[1]) helper(low,high,c,left+1,right-1);
        }
    }
}