public class Solution {
    public int divide(int dividend, int divisor) {
        int sign=1;
        long divd=Math.abs((long)dividend),div=Math.abs((long)divisor);
        sign=((dividend>0&&divisor<0)||(dividend<0&&divisor>0))?-1:1;
        if(divd==0) return 0;
        int step=0;
        long anodiv=div;
        while(anodiv<divd){
            anodiv=anodiv<<1;
            step++;
        }
        long ans=0;
        while(divd>=div){
            if(divd>=anodiv){
                ans+=(long)1<<step;
                divd-=anodiv;
            }
            anodiv=anodiv>>1;
            step--;
        }
        if(ans>Integer.MAX_VALUE) return sign==-1?Integer.MIN_VALUE:Integer.MAX_VALUE;
        return sign==-1?(~(int)ans+1):(int)ans;
    }
}