public class Solution {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int m=nums1.length,n=nums2.length;
        int[] res=new int[k];
        for(int i=Math.max(0,k-n);i<=k&&i<=m;i++){
            int[] sub=merge(maxArray(nums1,i),maxArray(nums2,k-i),k);
            res=greater(sub,0,res,0)?sub:res;
        }
        return res;
    }
    public int[] maxArray(int[] nums,int k){
        int n=nums.length;
        int[] res=new int[k];
        for(int i=0,j=0;i<n;i++){
            while(n-i>k-j&&j>0&&nums[i]>res[j-1]) j--;
            if(j<k) res[j++]=nums[i];
        }
        return res;
    }
    public boolean greater(int[] nums1,int i,int[] nums2,int j){
        while(i<nums1.length&&j<nums2.length&&nums1[i]==nums2[j]){
            i++;
            j++;
        }
        return j==nums2.length||(i<nums1.length&&nums1[i]>nums2[j]);
    }
    public int[] merge(int[] nums1,int[] nums2,int k){
        int[] ans=new int[k];
        for(int i=0,j=0,r=0;r<k;r++)
            ans[r]=greater(nums1,i,nums2,j)?nums1[i++]:nums2[j++];
        return ans;
    }
}