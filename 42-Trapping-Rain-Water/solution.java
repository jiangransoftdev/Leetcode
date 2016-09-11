public class Solution {
    public int trap(int[] height) {
        int n=height.length,max=0;
        int[] maxl=new int[n];
        int[] maxr=new int[n];
        for(int i=0;i<n;i++){
            maxl[i]=max;
            max=Math.max(max,height[i]);
        }
        max=0;
        for(int i=n-1;i>=0;i--){
            maxr[i]=max;
            max=Math.max(max,height[i]);
        }
        int total=0;
        for(int i=0;i<n;i++){
            int tapping=Math.min(maxl[i],maxr[i])-height[i];
            if(tapping>0) total+=tapping; 
        }
        return total;
    }
}