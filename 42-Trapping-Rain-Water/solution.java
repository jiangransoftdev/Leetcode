public class Solution {
    public int trap(int[] height) {
        if(height.length==0) return 0;
        int[] maxl=new int[height.length],maxr=new int[height.length];
        int max=0,res=0;
        for(int i=0;i<height.length;i++){
            maxl[i]=max;
            max=Math.max(height[i],max);
        }
        max=0;
        for(int i=height.length-1;i>=0;i--){
            maxr[i]=max;
            max=Math.max(height[i],max);
        }
        for(int i=0;i<height.length;i++){
            int tap=Math.min(maxl[i],maxr[i])-height[i];
            if(tap>0)
                res+=tap;
        }
        return res;
    }
}