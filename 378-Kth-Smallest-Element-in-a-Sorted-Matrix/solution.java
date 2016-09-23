class Item{
    int row,col,val;
    public Item(int row,int col,int val){
        this.row=row;
        this.col=col;
        this.val=val;
    }
}
public class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Item> pq=new PriorityQueue<>(new Comparator<Item>(){
            public int compare(Item a,Item b){
                return a.val-b.val;
            }
        });
        for(int i=0;i<matrix[0].length;i++)
            pq.offer(new Item(0,i,matrix[0][i]));
        while(--k>0){
            Item cur=pq.poll();
            int row=cur.row,col=cur.col;
            if(row+1<matrix.length) pq.offer(new Item(row+1,col,matrix[row+1][col]));
        }
        return pq.peek().val;
    }
}