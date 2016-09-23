class Item{
    int row,col,sum;
    public Item(int row,int col,int sum){
        this.row=row;
        this.col=col;
        this.sum=sum;
    }
}
public class Solution {
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<int[]> res=new ArrayList<>();
        if(nums1.length==0||nums2.length==0) return res;
        PriorityQueue<Item> pq=new PriorityQueue<>(new Comparator<Item>(){
            public int compare(Item a,Item b){
                return a.sum-b.sum;
            }
        });
        for(int i=0;i<nums1.length;i++)
            pq.offer(new Item(i,0,nums2[0]+nums1[i]));
        while(res.size()<k&&!pq.isEmpty()){
            Item cur=pq.poll();
            int row=cur.row,col=cur.col;
            int[] sub=new int[2];
            sub[0]=nums1[row];
            sub[1]=nums2[col];
            res.add(sub);
            if(col+1<nums2.length) pq.offer(new Item(row,col+1,nums1[row]+nums2[col+1]));
        }
        return res;
    }
}