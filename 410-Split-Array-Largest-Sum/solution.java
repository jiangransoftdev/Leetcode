public class Solution {
    public int splitArray(int[] nums, int m) {
        long sum=0;
        long max=0;
        for(int num:nums){
            max=Math.max(num,max);
            sum+=num;
        }
        return (int) binarySearch(nums,m,max,sum);
    }
    public long binarySearch(int[] nums,int m,long low,long high){
        while(low<high){
            long mid=low+(high-low)/2;
            if(isValid(nums,m,mid))
                high=mid;
            else low=mid+1;
        }
        return low;
    }
    public boolean isValid(int[] nums,int m,long max){
        long cur=0;
        int count=1;
        for(int num:nums){
            cur+=num;
            if(cur>max){
                cur=num;
                count++;
                if(count>m)
                    return false;
            }
        }
        return true;
    }
}