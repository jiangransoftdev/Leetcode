public class Solution {
    public int divide(int dividend, int divisor) {
        int sign=1;
        if(dividend==0) return 0;
        if((dividend<0&&divisor>0)||(dividend>0&&divisor<0)) sign=-1;
        long dvd=Math.abs((long)dividend);
        long div=Math.abs((long)divisor);
        int step=0;
        long anotherdiv=div;
        while(anotherdiv<dvd){
            anotherdiv=anotherdiv<<1;
            step++;
        }
        long res=0;
        while(dvd>=div){
            if(anotherdiv<=dvd){
                dvd-=anotherdiv;
                res+=(long)1<<step;
            }
            step--;
            anotherdiv=anotherdiv>>1;
        }
        int ans=0;
        if(res>Integer.MAX_VALUE)
            ans=(sign==1)?Integer.MAX_VALUE:Integer.MIN_VALUE;
        else
            ans=(sign==1)?(int)res:(~(int)res+1);
        return ans;
    }
}