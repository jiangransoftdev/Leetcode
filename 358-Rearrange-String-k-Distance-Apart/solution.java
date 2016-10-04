public class Solution {
    public String rearrangeString(String str, int k) {
        int[] valid=new int[26],count=new int[26];
        int n=str.length();
        for(int i=0;i<n;i++)
            count[str.charAt(i)-'a']++;
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<n;i++){
            int candidate=findValidMax(count,i,valid);
            if(candidate==-1) return "";
            count[candidate]--;
            valid[candidate]=i+k;
            sb.append((char)('a'+candidate));
        }
        return sb.toString();
    }
    public int findValidMax(int[] count,int index,int[] valid){
        int candidate=-1;
        int max=Integer.MIN_VALUE;
        for(int i=0;i<count.length;i++){
            if(count[i]>0&&count[i]>max&&index>=valid[i]){
                max=count[i];
                candidate=i;
            }
        }
        return candidate;
    }
}