public class Solution {
    public int maximumGap(int[] nums) {
        int exp=1;
        int max=Integer.MIN_VALUE,res=0;
        for(int num:nums)
            max=Math.max(max,num);
        int[] another=new int[nums.length];
        while(max/exp>0){
            int[] count=new int[10];
            for(int num:nums)
                count[(num/exp)%10]++;
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