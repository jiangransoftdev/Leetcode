public class Solution {
    public String rearrangeString(String str, int k) {
        int length=str.length();
        int[] count=new int[26],valid=new int[26];
        for(int i=0;i<length;i++)
            count[str.charAt(i)-'a']++;
        StringBuilder sb=new StringBuilder();
        for(int index=0;index<length;index++){
            int pos=findValidMax(count,valid,index);
            if(pos==-1) return "";
            count[pos]--;
            valid[pos]=index+k;
            sb.append((char)('a'+pos));
        }
        return sb.toString();
    }
    public int findValidMax(int[] count,int[] valid,int index){
        int max=Integer.MIN_VALUE;
        int pos=-1;
        for(int i=0;i<count.length;i++){
            if(count[i]>0&&count[i]>max&&index>=valid[i]){
                max=count[i];
                pos=i;
            }
        }
        return pos;
    }
}