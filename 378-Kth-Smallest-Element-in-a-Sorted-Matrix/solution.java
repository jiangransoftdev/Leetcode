public class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        if(matrix.length==0) return 0;
        PriorityQueue<int[]> pq=new PriorityQueue<>(new Comparator<int[]>(){
            public int compare(int[] a,int[] b){
                return a[0]-b[0];
            }
        });
        for(int i=0;i<matrix[0].length;i++)
            pq.offer(new int[]{matrix[0][i],0,i});
        int[] cur=new int[3];
        while(k>0&&!pq.isEmpty()){
            cur=pq.poll();
            int row=cur[1];
            int col=cur[2];
            if(row<matrix.length-1)
                pq.offer(new int[]{matrix[row+1][col],row+1,col});
            k--;
        }
        return cur[0];
    }
}