public class Solution {
    public String getPermutation(int n, int k) {
        int fact=1;
        StringBuilder sb=new StringBuilder();
        List<Integer> res=new ArrayList<>();
        for(int i=1;i<=n;i++){
            fact*=i;
            res.add(i);
        }
            
        for(int i=n,l=k-1;i>0;i--){
            fact/=i;
            int index=l/fact;
            sb.append(res.remove(index));
            l-=index*fact;
        }
        return sb.toString();
    }
}