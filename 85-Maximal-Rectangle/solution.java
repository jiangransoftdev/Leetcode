public class Solution {
    public int maximalRectangle(char[][] matrix) {
        int m=matrix.length;
        if(m==0) return 0;
        int n=matrix[0].length;
        int[] left=new int[n],right=new int[n],height=new int[n];
        int res=0;
        Arrays.fill(right,n);
        for(int i=0;i<m;i++){
            int curleft=0,curright=n;
            for(int j=0;j<n;j++){
                if(matrix[i][j]=='1'){
                    height[j]++;
                    left[j]=Math.max(curleft,left[j]);
                }
                else{
                    height[j]=0;
                    left[j]=0;
                    curleft=j+1;
                }
            }
            for(int j=n-1;j>=0;j--){
                if(matrix[i][j]=='1'){
                    right[j]=Math.min(curright,right[j]);
                }
                else{
                    right[j]=n;
                    curright=j;
                }
            }
            for(int j=0;j<n;j++)
                res=Math.max(res,height[j]*(right[j]-left[j]));
        }
        return res;
    }
}