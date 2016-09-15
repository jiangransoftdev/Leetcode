public class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> res=new ArrayList<>();
        if(nums.length==0) return res;
        int index=0,slow=0,fast=1;
        while(fast<nums.length){
            if(nums[slow]+1==nums[fast]){
                slow++;
            }
            else{
                String s="";
                if(slow==index){
                    s=nums[slow]+"";
                }
                else
                    s=nums[index]+"->"+nums[slow];
                res.add(s);
                slow=fast;
                index=slow;
            }
            fast++;
        }
        String s="";
        if(slow==index){
            s=nums[slow]+"";
        }
        else
            s=nums[index]+"->"+nums[slow];
        res.add(s);
        return res;
    }
}