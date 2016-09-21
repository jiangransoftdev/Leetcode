public class Solution {
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> res=new ArrayList<>();
        if(nums.length==0) return res;
        int[] nums2=new int[nums.length];
        int min=Integer.MAX_VALUE,max=Integer.MIN_VALUE;
        for(int num:nums){
            min=Math.min(num,min);
            max=Math.max(num,max);
        }
        int[] tree=new int[max-min+1];
        for(int i=0;i<nums.length;i++){
            nums2[i]=nums[i]-min+1;
        }
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