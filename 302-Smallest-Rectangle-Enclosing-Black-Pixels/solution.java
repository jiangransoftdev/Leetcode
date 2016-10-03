public class Solution {
    char[][] Image;
    public int minArea(char[][] image, int x, int y) {
        Image=image;
        int m=Image.length,n=Image[0].length;
        int left=binarySearch(0,y,0,m,true,false);
        int right=binarySearch(y+1,n,0,m,false,false);
        int top=binarySearch(0,x,left,right,true,true);
        int bottom=binarySearch(x+1,m,left,right,false,true);
        return (bottom-top)*(right-left);
    }
    public int binarySearch(int i,int j,int low,int high,boolean opt,boolean row){
        while(i!=j){
            int k=low,mid=(i+j)/2;
            while(k<high&&isWhite(mid,k,row)) k++;
            if(k<high==opt)
                j=mid;
            else i=mid+1;
        }
        return i;
    }
    public boolean isWhite(int mid,int k,boolean row){
        return (row?Image[mid][k]:Image[k][mid])=='0';
    }
}