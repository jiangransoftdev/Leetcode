public class Solution {
    public int[] getModifiedArray(int length, int[][] updates) {
        int[] res=new int[length];
        for(int[] update:updates){
            int start=update[0],end=update[1],num=update[2];
            res[start]+=num;
            if(end+1<length) res[end+1]+=-num;
        }
        for(int i=1;i<length;i++)
            res[i]+=res[i-1];
        return res;
    }
}