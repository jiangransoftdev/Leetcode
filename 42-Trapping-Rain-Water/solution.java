public class Solution {
    public int trap(int[] height) {
        if(height.length==0) return 0;
        int n=height.length;
        int[] maxl=new int[n];
        int[] maxr=new int[n];
        int max=0,total=0;
        for(int i=0;i<n;i++){
            maxl[i]=max;
            max=Math.max(height[i],max);
        }
        max=0;
        for(int i=n-1;i>=0;i--){
            maxr[i]=max;
            max=Math.max(height[i],max);
        }
        for(int i=0;i<n;i++){
            int tap=Math.min(maxl[i],maxr[i])-height[i];
            if(tap>0)
                total+=tap;
        }
        return total;
    }
}