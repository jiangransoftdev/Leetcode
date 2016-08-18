class Sum{
    int row,col,val;
    public Sum(int val,int row,int col){
        this.val=val;
        this.row=row;
        this.col=col;
    }
}
public class Solution {
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<int[]> res=new ArrayList<>();
        if(nums1.length==0||nums2.length==0||k<=0) return res;
        PriorityQueue<Sum> pq=new PriorityQueue<>(new Comparator<Sum>(){
            public int compare(Sum a,Sum b){
                return a.val-b.val;
            }
        });
        for(int i=0;i<Math.min(nums1.length,k);i++){
            int row=i;
            int col=0;
            int val=nums1[row]+nums2[col];
            pq.offer(new Sum(val,row,col));
        }
        for(int i=0;i<Math.min(nums1.length*nums2.length,k);i++){
            Sum sum=pq.poll();
            int row=sum.row;
            int col=sum.col;
            int[] pair={nums1[row],nums2[col]};
            res.add(pair);
            if(col<nums2.length-1){
                int val=nums1[row]+nums2[col+1];
                pq.offer(new Sum(val,row,col+1));
            }
        }
        return res;
    }
}