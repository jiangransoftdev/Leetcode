public class Solution {
    public String convert(String s, int numRows) {
        if(s.length()==0) return "";
        if(numRows==1) return s;
        StringBuffer[] sb=new StringBuffer[numRows];
        for(int i=0;i<numRows;i++) sb[i]=new StringBuffer();
        for(int i=0;i<s.length();i++){
            int index=i%(numRows*2-2);
            if(index<numRows)
                sb[index].append(s.charAt(i));
            else
                sb[2*numRows-2-index].append(s.charAt(i));
        }
        for(int k=1;k<sb.length;k++){
        	sb[0].append(sb[k]);
        }
        return sb[0].toString();
    }
}