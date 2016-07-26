public class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res=new ArrayList<>();
        if(nums.length==0) return res;
        int counta=0,countb=0,a=0,b=1;
        for(int i:nums){
            if(i==a){
                counta++;
            }
            else if(i==b){
                countb++;
            }
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
        if(counta>=(nums.length/3+1)) res.add(a);
        if(countb>=(nums.length/3+1)) res.add(b);
        return res;
    }
}