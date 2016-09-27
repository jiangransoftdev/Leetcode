public class Solution {
    char[][] pairs={{'0','0'},{'1','1'},{'6','9'},{'8','8'},{'9','6'}};
    int count=0;
    public int strobogrammaticInRange(String low, String high) {
        for(int i=low.length();i<=high.length();i++)
            helper(low,high,new char[i],0,i-1);
        return count;
    }
    public void helper(String low,String high,char[] c,int l,int r){
        if(l>r){
            String s=new String(c);
            if((s.length()==low.length()&&s.compareTo(low)<0)||(s.length()==high.length()&&s.compareTo(high)>0)) return;
            count++;
            return;
        }
        for(char[] pair:pairs){
            c[l]=pair[0];
            c[r]=pair[1];
            if(c.length!=1&&c[0]=='0') continue;
            if(l<r||l==r&&pair[0]==pair[1]) helper(low,high,c,l+1,r-1);
        }
    }
}