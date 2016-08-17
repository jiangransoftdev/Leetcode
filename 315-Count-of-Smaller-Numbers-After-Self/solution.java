public class Solution {
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> res=new ArrayList<>();
        if(nums.length==0) return res;
        int min=Integer.MAX_VALUE,max=Integer.MIN_VALUE;
        for(int num:nums)
            min=Math.min(min,num);
        int[] nums2=new int[nums.length];
        for(int i=0;i<nums.length;i++){
            nums2[i]=nums[i]-min+1;
            max=Math.max(max,nums2[i]);
        }
        int[] count=new int[max+1];
        for(int i=nums2.length-1;i>=0;i--){
            res.add(0,get(count,nums2[i]-1));
            update(count,nums2[i]);
        }
        return res;
    }
    public int get(int[] count,int i){
        int sum=0;
        while(i>0){
            sum+=count[i];
            i-=i&-i;
        }
        return sum;
    }
    public void update(int[] count,int i){
        while(i<count.length){
            count[i]+=1;
            i+=i&-i;
        }
    }
}