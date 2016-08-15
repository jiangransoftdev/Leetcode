public class Solution {
    public int hIndex(int[] citations) {
        int n=citations.length;
        if(n==0) return 0;
        int start=0,end=n-1,res=0;
        while(start<=end){
            int mid=start+(end-start)/2;
            if(citations[mid]>=n-mid){
                res=Math.max(res,n-mid);
                end=mid-1;
            }
            else
                start=mid+1;
        }
        return res;
    }
}