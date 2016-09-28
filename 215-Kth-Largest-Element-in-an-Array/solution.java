public class Solution {
    public int findKthLargest(int[] nums, int k) {
        int n=nums.length;
        int p=quickSelect(nums,0,n-1,n-k+1);
        return nums[p];
    }
    public int quickSelect(int[] num,int low,int high,int k){
        int l=low;
		int h=high;
		int pavot=num[low];
		while(l<h){
			while(pavot<=num[h]&&l<h){
				h--;
			}
			num[l]=num[h];
			while(pavot>=num[l]&&l<h){
				l++;
			}
			num[h]=num[l];
		}
		num[l]=pavot;
        int m=l-low+1;
        if(m==k) return l;
        else if(m>k) return quickSelect(num,low,l-1,k);
        else return quickSelect(num,l+1,high,k-m);
    }
}