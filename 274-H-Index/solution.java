public class Solution {
    public int hIndex(int[] citations) {
        int[] count=new int[citations.length+1];
        for(int i=0;i<citations.length;i++){
            if(citations[i]>=count.length-1) count[count.length-1]++;
            else count[citations[i]]++;
        }
        int total=0;
        for(int i=count.length-1;i>=0;i--){
            total+=count[i];
            if(i<=total) return i;
        }
        return 0;
    }
}