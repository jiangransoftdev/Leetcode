public class Solution {
    public boolean isHappy(int n) {
        Set<Integer> set=new HashSet<>();
        while(!set.contains(n)){
            set.add(n);
            int num=0;
            while(n>0){
                int digit=n%10;
                num+=digit*digit;
                n/=10;
            }
            n=num;
        }
        return n==1;
    }
}