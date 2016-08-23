public class Solution {
    public int maximumGap(int[] nums) {
        if(nums.length<2) return 0;
        int max=Integer.MIN_VALUE,res=Integer.MIN_VALUE;
        for(int i:nums)
            max=Math.max(max,i);
        int[] another=new int[nums.length];
        int exp=1;
        while(max/exp>0){
            int[] count=new int[10];
            for(int i=0;i<nums.length;i++)
                count[(nums[i]/exp)%10]++;
            for(int i=1;i<10;i++)
                count[i]+=count[i-1];
            for(int i=nums.length-1;i>=0;i--)
                another[--count[(nums[i]/exp)%10]]=nums[i];
            for(int i=0;i<nums.length;i++)
                nums[i]=another[i];
            exp*=10;
        }
        for(int i=1;i<nums.length;i++)
            res=Math.max(res,nums[i]-nums[i-1]);
        return res;
    }
}