public class Solution {
    public void wiggleSort(int[] nums) {
        int m=getKth(nums,0,nums.length-1,(nums.length+1)/2);
        int mid=nums[m];
        int n=nums.length;
	    int i = 0, j = 0, k = n - 1;
        while (j <= k) {
            if (nums[vitualIndex(j,n)] > mid)
                swap(nums,vitualIndex(i++,n), vitualIndex(j++,n));
            else if (nums[vitualIndex(j,n)] < mid)
                swap(nums,vitualIndex(j,n), vitualIndex(k--,n));
            else
                j++;
        }
    }
    public int vitualIndex(int i,int n){
	    return (1+2*i)%(n|1);
    }
    public void swap(int[] nums,int i,int j){
	int tmp=nums[i];
	nums[i]=nums[j];
	nums[j]=tmp;
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
            nums[h]=nums[l];
        }
        nums[l]=pivot;
        int m=l-low+1;
        if(m==k) return l;
        else if(m>k) return getKth(nums,low,l-1,k);
        else return getKth(nums,l+1,high,k-m);
    }
}