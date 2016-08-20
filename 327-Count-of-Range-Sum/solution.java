public class Solution {
    public int countRangeSum(int[] nums, int lower, int upper) {
        int n=nums.length;
        long[] sum=new long[n+1];
        for(int i=0;i<n;i++)
            sum[i+1]=nums[i]+sum[i];
        return countWhileMergeSort(sum,0,n+1,lower,upper);
    }
    public int countWhileMergeSort(long[] sum,int start,int end,int lower,int upper){
        if(end-start<=1) return 0;
        int mid=start+(end-start)/2;
        int count=countWhileMergeSort(sum,start,mid,lower,upper)+countWhileMergeSort(sum,mid,end,lower,upper);
        int j=mid,k=mid,t=mid;
        long[] cache=new long[end-start];
        for(int i=start,r=0;i<mid;i++,r++){
            while(j<end&&sum[j]-sum[i]<lower)j++;
            while(k<end&&sum[k]-sum[i]<=upper)k++;
            while(t<end&&sum[t]<sum[i])cache[r++]=sum[t++];
            cache[r]=sum[i];
            count+=k-j;
        }
        System.arraycopy(cache, 0, sum, start, t - start);
        return count;
    }
}