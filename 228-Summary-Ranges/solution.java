public class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> res=new ArrayList<>();
        if(nums.length==0) return res;
        if(nums.length==1){
            res.add(nums[0]+"");
            return res;
        }
        int start=0,low=0,high=1;
        while(high<nums.length){
            if(nums[low]+1==nums[high]){
                low++;
                high++;
            }
            else{
                String s="";
                if(start!=low){
                    s=nums[start]+"->"+nums[low];
                }
                else s=nums[start]+"";
                res.add(s);
                start=high;
                low=high;
                high++;
            }
        }
        String s="";
       if(start!=low){
        s=nums[start]+"->"+nums[low];
                }
                else s=nums[start]+"";
        res.add(s);
        return res;
    }
}