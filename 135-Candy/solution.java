public class Solution {
    public int candy(int[] ratings) {
        if(ratings.length==0) return 0;
        int n=ratings.length;
        int total=n,increase=1,index=0;
        while(index<n){
            int i=index;
            if(i+1==n) break;
            int count=1;
            if(i+1<n&&ratings[i+1]<ratings[i]){
                while(i+1<n&&ratings[i+1]<ratings[i]){
                    i++;
                    count++;
                }
                if(increase<count)
                    total+=count-increase;
                increase=1;
                total+=(count-2)*(count-1)/2;
                index=i;
            }
            else if(i+1<n&&ratings[i+1]>ratings[i]){
                total+=increase;
                increase++;
                index++;
            }
            else if(i+1<n&&ratings[i+1]==ratings[i]){
                increase=1;
                index++;
            }
        }
        return total;
    }
}