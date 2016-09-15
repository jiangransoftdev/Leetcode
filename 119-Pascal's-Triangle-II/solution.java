public class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> ans=new ArrayList<>();
        int[] res=new int[rowIndex+1];
        for(int i=0;i<=rowIndex;i++){
            for(int j=i;j>=0;j--){
                if(j==0||j==i) res[j]=1;
                else res[j]=res[j]+res[j-1];
            }
        }
        for(int i=0;i<res.length;i++)
            ans.add(res[i]);
        return ans;
    }
}