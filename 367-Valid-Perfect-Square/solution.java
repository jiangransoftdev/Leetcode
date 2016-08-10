public class Solution {
    public boolean isPerfectSquare(int num) {
        return sqrt(num)*sqrt(num)==num;
    }
    public int sqrt(int num){
        if(num==0) return 0;
        int low=1,high=num;
        while(low<high){
            int mid=low+(high-low)/2+1;
            if(num/mid==mid) return mid;
            else if(num/mid>mid) low=mid;
            else high=mid-1;
        }
        return high;
    }
}