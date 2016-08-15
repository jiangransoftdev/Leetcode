public class Solution {
    public int getSum(int a, int b) {
        if(a==0) return b;
        if(b==0) return a;
        int indexa=0,indexb=0,res=0,index=0,add=0;
        while(index<32){
            int digita=a&1;
            int digitb=b&1;
            int digit=0;
            if((digita&digitb)==1){
                digit=add;
                add=1;
            }
            else{
                if(add==1){
                    if((digita|digitb)==1){
                        digit=0;
                        add=1;
                    }
                    else{
                        digit=1;
                        add=0;
                    }
                }
                else{
                    add=0;
                    if((digita|digitb)==1)
                        digit=1;
                    else digit=0;
                }
            }
            res+=digit<<index;
            index++;
            a=a>>1;
            b=b>>1;
        }
        return res;
    }
}