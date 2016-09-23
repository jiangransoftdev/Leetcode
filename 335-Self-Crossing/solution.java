public class Solution {
    public boolean isSelfCrossing(int[] x) {
        if(x.length==0) return false;
        for(int i=3;i<x.length;i++){
            if(x[i]>=x[i-2]&&x[i-3]>=x[i-1]) return true;
            if(i>3&&(x[i]+x[i-4]>=x[i-2])&&x[i-1]==x[i-3]&&x[i-2]>=x[i-4]) return true;
            if(i>4&&(x[i-4]+x[i]>=x[i-2])&&x[i-2]>=x[i-4]&&(x[i-5]+x[i-1]>=x[i-3])&&x[i-3]>=x[i-1]) return true;
        }
        return false;
    }
}