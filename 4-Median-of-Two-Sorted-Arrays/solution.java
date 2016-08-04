public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m=nums1.length;
        int n=nums2.length;
        int l=(m+n+1)/2;
        int r=(m+n+2)/2;
        return (getKth(nums1,0,nums2,0,l)+getKth(nums1,0,nums2,0,r))/2.0;
    }
    public double getKth(int[] nums1,int starta,int[] nums2,int startb,int k){
        if(starta>nums1.length-1) return nums2[startb+k-1];
        if(startb>nums2.length-1) return nums1[starta+k-1];
        if(k==1) return Math.min(nums1[starta],nums2[startb]);
        int amid=Integer.MAX_VALUE,bmid=Integer.MAX_VALUE;
        if(starta+k/2-1<nums1.length) amid=nums1[starta+k/2-1];
        if(startb+k/2-1<nums2.length) bmid=nums2[startb+k/2-1];
        if(amid>bmid)
            return getKth(nums1,starta,nums2,startb+k/2,k-k/2);
        else return getKth(nums1,starta+k/2,nums2,startb,k-k/2);
    }
}