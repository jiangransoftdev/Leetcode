public class Solution {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder sb=new StringBuilder();
        if(strs.length!=0){
            Arrays.sort(strs);
            char[] c1=strs[0].toCharArray();
            char[] c2=strs[strs.length-1].toCharArray();
            for(int i=0;i<c1.length;i++){
                if(c2.length>i&&c1[i]==c2[i])
                    sb.append(c1[i]);
                else return sb.toString();
            }
        }
        return sb.toString();
    }
}