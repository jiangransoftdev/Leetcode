public class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        int sign=1,index=0;
        if((numerator<0)^(denominator<0)) sign=-1;
        long anumerator=Math.abs((long)numerator),adenominator=Math.abs((long)denominator);
        long point=anumerator%adenominator,r=0;
        String res=((sign==-1&&!(anumerator/adenominator==0&&point==0))?"-":"")+anumerator/adenominator+"";
        if(point==0) return res;
        Map<Long,Integer> map=new HashMap<>();
        StringBuilder sb=new StringBuilder();
        point*=10;
        while(!map.containsKey(point)){
            map.put(point,index++);
            r=point/adenominator;
            sb.append(r);
            point=point%adenominator;
            if(point==0) return res+"."+sb.toString();
            point*=10;
        }
        return res+"."+sb.insert(map.get(point),"(").toString()+")";
    }
}