public class Solution {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int m=nums1.length;
        int n=nums2.length;
        int[] ans=new int[k];
        for(int i=Math.max(0,k-n);i<=k&&i<=m;i++){
            int[] sub=merge(maxArray(nums1,i),maxArray(nums2,k-i),k);
            if(greater(sub,0,ans,0)) ans=sub;
        }
        return ans;
    }
    public int[] maxArray(int[] nums,int k){
        int[] ans=new int[k];
        for(int i=0,j=0;i<nums.length;i++){
            while(nums.length-i>k-j&&j>0&&nums[i]>ans[j-1]) j--;
            if(j<k) ans[j++]=nums[i];
        }
        return ans;
    }
    public int[] merge(int[] nums1,int[] nums2,int k){
        int[] ans=new int[k];
        for(int p=0,q=0,r=0;r<k;r++){
            if(greater(nums1,p,nums2,q)) ans[r]=nums1[p++];
            else ans[r]=nums2[q++];
        }
        return ans;
    }
    public boolean greater(int[] nums1,int i,int[] nums2,int j){
        while(i<nums1.length&&j<nums2.length&&nums1[i]==nums2[j]){
            i++;
            j++;
        }
        return j==nums2.length||(i<nums1.length&&nums1[i]>nums2[j]);
    }
}