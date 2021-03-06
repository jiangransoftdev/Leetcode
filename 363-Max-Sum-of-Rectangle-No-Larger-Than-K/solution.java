public class Solution {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int m=matrix.length;
        if(m==0) return 0;
        int n=matrix[0].length;
        int M=Math.max(m,n),N=Math.min(m,n);
        int res=Integer.MIN_VALUE;
        for(int i=0;i<N;i++){
            int[] sum=new int[M];
            for(int j=i;j<N;j++){
                for(int z=0;z<M;z++) sum[z]+=m>n?matrix[z][j]:matrix[j][z];
                TreeSet<Integer> set=new TreeSet<>();
                set.add(0);
                int num=0;
                for(int z=0;z<M;z++){
                    num+=sum[z];
                    Integer x=set.ceiling(num-k);
                    if(x!=null)
                        res=Math.max(res,num-x);
                    set.add(num);
                }
            }
        }
        return res;
    }
}