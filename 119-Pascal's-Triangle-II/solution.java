public class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> res=new ArrayList<>();
        int[] nums=new int[rowIndex+1];
        for(int i=0;i<=rowIndex;i++){
            for(int j=i;j>=0;j--){
                if(j==i||j==0) nums[j]=1;
                else{
                    nums[j]+=nums[j-1];
                }
            }
        }
        for(int num:nums)
            res.add(num);
        return res;
    }
}