public class Solution {
    public int trap(int[] height) {
        int[] maxl=new int[height.length],maxr=new int[height.length];
        int max=0;
        for(int i=1;i<height.length;i++){
            if(max<height[i-1])
                max=height[i-1];
            maxl[i]=max;
        }
        max=0;
        for(int i=height.length-2;i>=0;i--){
            if(max<height[i+1])
                max=height[i+1];
            maxr[i]=max;
        }
        int res=0;
        for(int i=0;i<height.length;i++){
            res+=(Math.min(maxl[i],maxr[i])-height[i])>0?(Math.min(maxl[i],maxr[i])-height[i]):0;
        }
        return res;
    }
}