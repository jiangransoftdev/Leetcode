public class Solution {
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> res=new ArrayList<>();
        if(nums.length==0) return res;
        int max=Integer.MIN_VALUE,min=Integer.MAX_VALUE;
        for(int i:nums){
            min=Math.min(min,i);
        }
        int[] nums2=new int[nums.length];
        for(int i=0;i<nums.length;i++){
            nums2[i]=nums[i]-min+1;
            max=Math.max(nums2[i],max);
        }
        int[] tree=new int[max+1];
        for(int i=nums2.length-1;i>=0;i--){
            res.add(0,get(tree,nums2[i]-1));
            update(tree,nums2[i]);
        }
        return res;
    }
    public int get(int[] tree,int i){
        int sum=0;
        while(i>0){
            sum+=tree[i];
            i-=i&-i;
        }
        return sum;
    }
    public void update(int[] tree,int i){
        while(i<tree.length){
            tree[i]++;
            i+=i&-i;
        }
    }
}