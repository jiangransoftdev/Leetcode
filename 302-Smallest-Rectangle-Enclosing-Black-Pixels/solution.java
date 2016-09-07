public class Solution {
    char[][] image;
    public int minArea(char[][] iImage, int x, int y) {
        image=iImage;
        int m=image.length,n=image[0].length;
        int left=search(0,y,0,m,true,false);
        int right=search(y+1,n,0,m,false,false);
        int top=search(0,x,left,right,true,true);
        int bottom=search(x+1,m,left,right,false,true);
        return (right-left)*(bottom-top);
    }
    public int search(int i,int j,int low,int high,boolean opt,boolean isRow){
        while(i!=j){
            int k=low,mid=(i+j)/2;
            while(k<high&&isWhite(mid,k,isRow))k++;
            if(k<high==opt)
                j=mid;
            else i=mid+1;
        }
        return i;
    }
    public boolean isWhite(int mid,int k,boolean isRow){
        return ((isRow) ? image[mid][k] : image[k][mid]) == '0';
    }
}