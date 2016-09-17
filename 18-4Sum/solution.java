public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res=new ArrayList<>();
        if(nums.length==0) return res;
        Arrays.sort(nums);
        for(int i=0;i<nums.length-3;i++){
            if(i>0&&nums[i]==nums[i-1]) continue;
            for(int j=i+1;j<nums.length-2;j++){
                if(j>i+1&&nums[j]==nums[j-1]) continue;
                int m=j+1,n=nums.length-1;
                while(m<n){
                    int sum=nums[i]+nums[j]+nums[m]+nums[n];
                    if(sum==target){
                        res.add(Arrays.asList(nums[i],nums[j],nums[m],nums[n]));
                        while(m<n&&nums[m]==nums[m+1]) m++;
                        while(m<n&&nums[n]==nums[n-1]) n--;
                        m++;
                        n--;
                    }
                    else if(sum>target) n--;
                    else m++;
                }
            }
        }
        return res;
    }
}