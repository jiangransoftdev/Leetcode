public class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        char[] c1=ransomNote.toCharArray();
        char[] c2=magazine.toCharArray();
        Arrays.sort(c1);
        Arrays.sort(c2);
        int i=0,j=0;
        while(i<c1.length&&j<c2.length){
            if(c1[i]==c2[j]){
                i++;
                j++;
            }
            else if(c1[i]<c2[j]) return false;
            else if(c1[i]>c2[j]) j++;
        }
        return i==c1.length;
    }
}