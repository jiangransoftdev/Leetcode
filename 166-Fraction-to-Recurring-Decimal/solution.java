public class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if(numerator==0) return "0";
        int sign=1,i=0;
        if((numerator>0&&denominator<0)||(numerator<0&&denominator>0)) sign=-1;
        long num=Math.abs((long)numerator),denom=Math.abs((long)denominator);
        Map<Long,Integer> map=new HashMap<>();
        if(num%denom==0) return (sign==-1?"-":"")+String.valueOf((num/denom));
        StringBuilder sb=new StringBuilder();
        long residue=num%denom;
        while(!map.containsKey(residue)){
            map.put(residue,i);
            long digit=residue*10/denom;
            sb.append(digit);
            residue=residue*10-denom*digit;
            if(residue==0) return (sign==-1?"-":"")+String.valueOf((num/denom))+"."+sb.toString();
            i++;
        }
        sb.insert(map.get(residue),"(");
        return (sign==-1?"-":"")+String.valueOf((num/denom))+"."+sb.toString()+")";
    }
}