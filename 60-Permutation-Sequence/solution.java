public class Solution {
    public String getPermutation(int n, int k) {
        List<Integer> num=new ArrayList<>();
        StringBuilder sb=new StringBuilder();
        int fact=1;
        for(int i=1;i<=n;i++){
            fact*=i;
            num.add(i);
        }
            
        for(int i=n,l=k-1;i>0;i--){
            fact/=i;
            int index=l/fact;
            sb.append(num.remove(index));
            l-=index*fact;
        }
        return sb.toString();
    }
}