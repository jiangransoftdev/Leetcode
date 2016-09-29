public class Solution {
    public void wiggleSort(int[] nums) {
        int m=getKth(nums,0,nums.length-1,nums.length/2);
        int mid=nums[m];
        int i=0,j=0,k=nums.length-1;
        while(j<=k){
            if(nums[j]>mid)
                swap(nums,i++,j++);
            else if(nums[j]<mid)
                swap(nums,j,k--);
            else j++;
        }
    }
    public int getKth(int[] nums,int low,int high,int k){
        int l=low,h=high;
        int pivot=nums[l];
        while(l<h){
            while(l<h&&nums[h]>=pivot)
                h--;
            nums[l]=nums[h];
            while(l<h&&nums[l]<=pivot)
                l++;
            nums[h]=num[l];
        }
        nums[l]=pivot;
        int m=l-low+1;
        if(m==k) return m;
        else if(m>k) return getKth(nums,low,l-1,k);
        else return getKth(nums,l+1,high,k-m);
    }
}