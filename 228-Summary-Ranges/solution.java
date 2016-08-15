public class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> res=new ArrayList<>();
        if(nums.length==0) return res;
        int start=0,slow=0,fast=1;
        while(fast<nums.length){
            if(nums[slow]+1==nums[fast]){
                slow++;
                fast++;
            }
            else{
                if(start==slow){
                    res.add(nums[start]+"");
                }
                else{
                    res.add(nums[start]+"->"+nums[slow]);
                }
                start=fast;
                slow=start;
                fast++;
            }
        }
        if(start==slow){
                    res.add(nums[start]+"");
                }
                else{
                    res.add(nums[start]+"->"+nums[slow]);
                }
        return res;
    }
}