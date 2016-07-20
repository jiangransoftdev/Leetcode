public class Solution {
    public int maximumGap(int[] nums) {
        int m=Integer.MAX_VALUE;
        for(int i:nums){
            m=Math.max(m,i);
        }
        int exp=1;
        int[] another=new int[nums.length];
        while(m/exp>0){
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
        int max=0;
        for(int i=1;i<nums.length;i++)
            max=Math.max(max,nums[i]-nums[i-1]);
        return max;
    }
}