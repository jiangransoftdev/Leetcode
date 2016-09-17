public class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> res=new ArrayList<>();
        if(nums.length==0) return res;
        int[] len=new int[nums.length];
        // len[0]=1;
        int maxl=0;
        Arrays.sort(nums);
        for(int i=1;i<nums.length;i++){
            // int l=1;
            for(int j=0;j<i;j++){
                if(nums[i]%nums[j]==0) len[i]=Math.max(len[i],len[j]+1);
            }
            // len[i]=l;
            maxl=Math.max(len[i],maxl);
        }
        if(maxl+1==nums.length){
            for(int num:nums) res.add(num);
        }
        else{
            for(int i=nums.length-1;i>=0;i--){
            if(len[i]==maxl){
                res.add(nums[i]);
                maxl--;
            }
        }
        }
        return res;
    }
}