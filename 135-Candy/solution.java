public class Solution {
    public int candy(int[] ratings) {
        int n=ratings.length;
        int index=0;
        int total=n;
        int increase=1;
        while(index<n){
            int i=index;
            if(i+1==n) break;
            if(i+1<n&&ratings[i]<ratings[i+1]){
                total+=increase;
                increase++;
                index++;
            }
            else if(i+1<n&&ratings[i]==ratings[i+1]){
                index++;
                increase=1;
            }
            else if(i+1<n&&ratings[i]>ratings[i+1]){
                int count=1;
                while(i+1<n&&ratings[i]>ratings[i+1]){
                    i++;
                    count++;
                }
                if(count>increase){
                    total+=count-increase;
                }
                increase=1;
                total+=(count-1)*(count-2)/2;
                index=i;
            }
        }
        return total;
    }
}