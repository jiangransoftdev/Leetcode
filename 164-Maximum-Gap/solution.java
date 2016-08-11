public class Solution {
    public int maximumGap(int[] nums) {
        if(nums.length<2) return 0;
        int m=Integer.MIN_VALUE,max=Integer.MIN_VALUE;
        for(int i:nums)
            m=Math.max(i,m);
        int[] another=new int[nums.length];
        int exp=1;
        while(m/exp>0){
            int[] count=new int[10];
            for(int i:nums)
                count[(i/exp)%10]++;
            for(int i=1;i<count.length;i++)
                count[i]+=count[i-1];
            for(int i=nums.length-1;i>=0;i--)
                another[--count[(nums[i]/exp)%10]]=nums[i];
            for(int i=0;i<nums.length;i++)
                nums[i]=another[i];
            exp*=10;
        }
        for(int i=1;i<nums.length;i++)
            max=Math.max(nums[i]-nums[i-1],max);
        return max;
    }   
}