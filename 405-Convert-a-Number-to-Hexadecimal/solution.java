public class Solution {
    String[] d={"0","1","2","3","4","5","6","7","8","9","a","b","c","d","e","f"};
    public String toHex(int num) {
        long another=num;
        if(another==0) return "0";
        if(another<0) another=(long)Math.pow(2,32)+num;
        StringBuilder sb=new StringBuilder();
        while(another>0){
            long digit=another%16;
            sb.insert(0,d[(int)digit]);
            another/=16;
        }
        return sb.toString();
    }
}