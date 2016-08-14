public class Solution {
    public int compareVersion(String version1, String version2) {
        String[] s1=version1.split("\\.");
        String[] s2=version2.split("\\.");
        int i=0,j=0,a=0,b=0;
        while(i<s1.length||j<s2.length){
            a=i<s1.length?Integer.parseInt(s1[i++]):0;
            b=j<s2.length?Integer.parseInt(s2[j++]):0;
            if(a>b) return 1;
            if(b>a) return -1;
        }
        return 0;
    }
}