public class Solution {
    public int hIndex(int[] citations) {
        int n=citations.length;
        int low=0,high=n-1,res=0;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(citations[mid]>=n-mid){
                res=Math.max(res,n-mid);
                high=mid-1;
            }
                
            else low=mid+1;
        }
        return res;
    }
}