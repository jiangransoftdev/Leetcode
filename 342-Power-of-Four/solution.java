public class Solution {
    public boolean isPowerOfFour(int num) {
        if(num<=0) return false;
        if(num==1) return true;
        return (1073741824%num==0)&&(num%10==4||num%10==6);
    }
}