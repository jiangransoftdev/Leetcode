public class Solution {
    public int threeSumSmaller(int[] nums, int target) {
        int count=0;
        Arrays.sort(nums);
        for(int i=0;i<nums.length-2;i++){
            int l=i+1,h=nums.length-1;
            while(l<h){
                int sum=nums[i]+nums[l]+nums[h];
                if(sum<target){
                    count+=h-l;
                    l++;
                } 
                else
                    h--;
            }
        }
        return count;
    }
}