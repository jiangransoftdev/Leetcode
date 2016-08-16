public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int total=0,tmp=0,start=0;
        for(int i=0;i<gas.length;i++){
            if(tmp<=0){
                total+=tmp;
                tmp=0;
                start=i;
            }
            tmp+=gas[i]-cost[i];
        }
        if(tmp+total>=0){
            return start;
        }
        return -1;
    }
}