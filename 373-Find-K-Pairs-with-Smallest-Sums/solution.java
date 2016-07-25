class Sum implements Comparable<Sum> {
    int val;
    int i;
    int j;
    
    public Sum(int val, int i, int j) {
        this.val = val;
        this.i = i;
        this.j = j;
    }
    
    public int compareTo(Sum o) {
        return this.val - o.val;
    }
}
public class Solution {
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<int[]> res=new ArrayList<>();
         if ((nums1 == null || nums1.length == 0) || (nums2 == null || nums2.length ==0) || k <= 0) {
        return res;
    }
        PriorityQueue<Sum> pq=new PriorityQueue<>();
        for(int i=0;i<Math.min(nums1.length,k);i++){
            int row=i;
            int col=0;
            int val=nums1[row]+nums2[col];
            pq.offer(new Sum(val,row,col));
        }
        for(int i=0;i<Math.min(nums1.length*nums2.length,k);i++){
            Sum sum=pq.poll();
            int row=sum.i;
            int col=sum.j;
            int[] pair={nums1[row],nums2[col]};
            if(col<nums2.length-1){
                int val=nums1[row]+nums2[col+1];
                pq.offer(new Sum(val,row,col+1));
            }
            res.add(pair);
            
        }
        return res;
    }
}