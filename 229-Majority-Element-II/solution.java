public class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res=new ArrayList<>();
        int a=0,b=1,counta=0,countb=0;
        for(int i:nums){
            if(a==i)
                counta++;
            else if(b==i)
                countb++;
            else if(counta==0){
                a=i;
                counta=1;
            }
            else if(countb==0){
                b=i;
                countb=1;
            }
            else{
                counta--;
                countb--;
            }
        }
        counta=0;
        countb=0;
        for(int i:nums){
            if(i==a) counta++;
            if(i==b) countb++;
        }
        if(counta>nums.length/3) res.add(a);
        if(countb>nums.length/3) res.add(b);
        return res;
    }
}