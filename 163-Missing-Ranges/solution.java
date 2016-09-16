public class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> res=new ArrayList<>();
        int start=lower,end=upper;
        for(int num:nums){
            if(start==num) start++;
            else{
                String s="";
                if(num-1==start){
                    s=start+"";
                }
                else{
                    s=start+"->"+(num-1);
                }
                start=num+1;
                res.add(s);
            }
        }
        if(start==end) res.add(end+"");
        else if(start<end) res.add(start+"->"+end);
        return res;
        
    }
}