public class Solution {
    public String convert(String s, int numRows) {
        char[] str=s.toCharArray();
        StringBuilder[] sb=new StringBuilder[numRows];
        for(int i=0;i<numRows;i++) sb[i]=new StringBuilder();
        int i=0;
        while(i<s.length()){
            for(int index=0;index<numRows&&i<s.length();index++)
                sb[index].append(str[i++]);
            for(int index=numRows-2;index>=1&&i<s.length();index--)
                sb[index].append(str[i++]);
        }
        for(int j=1;j<numRows;j++)
            sb[0].append(sb[j]);
        return sb[0].toString();
    }
}