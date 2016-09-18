public class Solution {
    public boolean canCross(int[] stones) {
        if(stones[1]>1) return false;
        if(stones.length==2) return true;
        return helper(stones,1,1);
    }
    public boolean helper(int[] stones,int i,int speed){
        boolean res=false;
        if(i==stones.length-1) return true;
        for(int j=i+1;j<stones.length;j++){
            if(stones[j]<=stones[i]+speed+1&&stones[j]>=stones[i]+speed-1)
                res=res||helper(stones,j,stones[j]-stones[i]);
        }
        return res;
    }
}