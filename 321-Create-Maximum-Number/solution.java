public class Solution {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
     int n=nums1.length;
     int m=nums2.length;
     int[] ans=new int[k];
     for(int i=Math.max(0,k-m);i<=n&&i<=k;i++){
        int[] sub=merge(maxArray(nums1,i),maxArray(nums2,k-i),k);
        if(greater(sub,0,ans,0)) ans=sub;
        }
    return ans;
    }
    public int[] maxArray(int[] nums,int k){
        int n=nums.length;
        int[] ans=new int[k];
        for(int i=0,j=0;i<n;i++){
            while(j>0&&n-i>k-j&&nums[i]>ans[j-1]) j--;
            if(j<k) ans[j++]=nums[i];
        }
        return ans;
    }
    public boolean greater(int[] sub,int i,int[] num,int j){
        while(i<sub.length&&j<num.length&&sub[i]==num[j]){
            i++;
            j++;
        }
        return j==num.length||(i<sub.length&&sub[i]>num[j]);
    }
    public int[] merge(int[] nums1,int[] nums2,int k){
        int[] ans=new int[k];
        for(int i=0,j=0,r=0;r<k;r++)
            ans[r]=greater(nums1,i,nums2,j)?nums1[i++]:nums2[j++];
        return ans;
    }
}