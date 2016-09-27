public class Solution {
    public int candy(int[] ratings) {
        int n=ratings.length,i=0,total=n;
        while(i<n){
            if(i+1<n&&ratings[i]!=ratings[i+1]){
                int increase=1;
                while(i+1<n&&ratings[i]<ratings[i+1]){
                    total+=increase;
                    increase++;
                    i++;
                }
                int decrease=1;
                while(i+1<n&&ratings[i]>ratings[i+1]){
                    decrease++;
                    i++;
                }
                if(decrease>increase) total+=decrease-increase;
                total+=(decrease-2)*(decrease-1)/2;
            }
            else i++;
        }
        return total;
    }
}