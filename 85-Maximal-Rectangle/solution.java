public class Solution {
    public int maximalRectangle(char[][] matrix) {
        int m=matrix.length;
        if(m==0) return 0;
        int n=matrix[0].length,max=0;
        int[] height=new int[n];
        int[] left=new int[n];
        int[] right=new int[n];
        Arrays.fill(right,n);
        for(int i=0;i<m;i++){
            int curleft=0,curright=n;
            for(int j=0;j<n;j++){
                if(matrix[i][j]=='1'){
                    height[j]++;
                    left[j]=Math.max(left[j],curleft);
                }
                else{
                    left[j]=0;
                    curleft=j+1;
                    height[j]=0;
                }
            }
            for(int j=n-1;j>=0;j--){
                if(matrix[i][j]=='1'){
                    right[j]=Math.min(right[j],curright);
                }
                else{
                    right[j]=n;
                    curright=j;
                }
            }
            for(int j=0;j<n;j++)
                max=Math.max(max,height[j]*(right[j]-left[j]));
        }
        return max;
    }
}