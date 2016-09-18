public class Solution {
    public int getSum(int a, int b) {
        int i=0,res=0,add=0,index=0;
        while(i<32){
            int digit=0;
            int digita=(a>>i)&1;
            int digitb=(b>>i)&1;
            if(add==1&&(digita==1||digitb==1)){
                add=1;
                if(digita==1&&digitb==1) digit=1;
                else digit=0;
            }
            else{
                if(add==0){
                    add=digita&digitb;
                    digit=digita^digitb;
                }
                else{
                    add=0;
                    digit=1;
                }
            }
            res|=digit<<index;
            index++;
            i++;
        }
        return res;
    }
}