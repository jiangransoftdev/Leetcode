public class NumMatrix {
    int[][] tree;
    int[][] num;
    int m;
    int n;
    public NumMatrix(int[][] matrix) {
         m=matrix.length;
        if(m==0) return;
        n=matrix[0].length;
        tree=new int[m+1][n+1];
        num=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++)
                update(i,j,matrix[i][j]);
        }
    }
    
    public void update(int row, int col, int val) {
        int diff=val-num[row][col];
        num[row][col]=val;
        for(int i=row+1;i<=m;i+=i&-i){
            for(int j=col+1;j<=n;j+=j&-j)
                tree[i][j]+=diff;
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return getSum(row2+1,col2+1)+getSum(row1,col1)-getSum(row2+1,col1)-getSum(row1,col2+1);
    }
    public int getSum(int row,int col){
        int sum=0;
        for(int i=row;i>0;i-=i&-i){
            for(int j=col;j>0;j-=j&-j)
                sum+=tree[i][j];
        }
        return sum;
    }
}


// Your NumMatrix object will be instantiated and called as such:
// NumMatrix numMatrix = new NumMatrix(matrix);
// numMatrix.sumRegion(0, 1, 2, 3);
// numMatrix.update(1, 1, 10);
// numMatrix.sumRegion(1, 2, 3, 4);