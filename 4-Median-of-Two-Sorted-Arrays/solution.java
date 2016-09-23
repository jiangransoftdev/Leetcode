public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m=nums1.length,n=nums2.length;
        int l=(m+n+1)/2,r=(m+n+2)/2;
        return (getKth(nums1,0,nums2,0,l)+getKth(nums1,0,nums2,0,r))/2.0;
    }
    public int getKth(int[] nums1,int astart,int[] nums2,int bstart,int k){
        if(astart>nums1.length-1) return nums2[bstart+k-1];
        if(bstart>nums2.length-1) return nums1[astart+k-1];
        if(k==1) return Math.min(nums1[astart],nums2[bstart]);
        int amid=Integer.MAX_VALUE,bmid=Integer.MAX_VALUE;
        if(astart+k/2-1<nums1.length) amid=nums1[astart+k/2-1];
        if(bstart+k/2-1<nums2.length) bmid=nums2[bstart+k/2-1];
        if(amid>bmid)
            return getKth(nums1,astart,nums2,bstart+k/2,k-k/2);
        else return getKth(nums1,astart+k/2,nums2,bstart,k-k/2);
    }
}