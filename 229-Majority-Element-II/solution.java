public class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int a=0,b=1;
        int counta=0,countb=0;
        List<Integer> res=new ArrayList<>();
        for(int num:nums){
            if(num==a)
                counta++;
            else if(num==b)
                countb++;
            else if(counta==0){
                counta=1;
                a=num;
            }
            else if(countb==0){
                countb=1;
                b=num;
            }
            else{
                counta--;
                countb--;
            }
        }
        counta=0;
        countb=0;
        for(int num:nums){
            if(a==num) counta++;
            if(b==num) countb++;
        }
        if(counta>nums.length/3) res.add(a);
        if(countb>nums.length/3) res.add(b);
        return res;
    }
}