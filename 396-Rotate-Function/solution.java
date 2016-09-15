public class Solution {
    public int maxRotateFunction(int[] A) {
        if(A.length==0) return 0;
        int sum=0,res=Integer.MIN_VALUE,total=0;
        for(int i=0;i<A.length;i++){
            total+=A[i]*i;
            sum+=A[i];
        }
        res=total;
        for(int i=A.length-1;i>0;i--){
            total=total+sum-A.length*A[i];
            res=Math.max(res,total);
        }
        return res;
    }
}