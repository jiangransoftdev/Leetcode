public class Solution {
    public int mySqrt(int x) {
        if(x==0) return 0;
        int low=1,high=x;
        while(low+1<=high){
            int mid=low+(high-low)/2+1;
            if(x/mid==mid) return mid;
            else if(x/mid>mid) low=mid;
            else high=mid-1;
        }
        return high;
    }
}