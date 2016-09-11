public class Solution {
    public int compareVersion(String version1, String version2) {
        String[] strv1=version1.split("\\.");
        String[] strv2=version2.split("\\.");
        int i=0;
        int j=0;
        int a,b;
        while(i<strv1.length||j<strv2.length){
            a=(i<strv1.length)?Integer.parseInt(strv1[i++]):0;
                b=(j<strv2.length)?Integer.parseInt(strv2[j++]):0;
            if(a==b) continue;
            else if(a>b) return 1;
            else return -1;
        }
        return 0;
    }
}