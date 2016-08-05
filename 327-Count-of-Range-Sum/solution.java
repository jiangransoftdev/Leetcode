public class Solution {
    public int countRangeSum(int[] nums, int lower, int upper) {
        List<Long> cand=new ArrayList<>();
        cand.add(Long.MIN_VALUE);
        cand.add(0l);
        long[] sum=new long[nums.length+1];
        for(int i=1;i<sum.length;i++){
            sum[i]=sum[i-1]+nums[i-1];
            cand.add(sum[i]);
            cand.add(sum[i-1]+lower-1);
            cand.add(sum[i-1]+upper);
        }
        Collections.sort(cand);
        int[] bit=new int[cand.size()];
        for(int i=0;i<sum.length;i++) plus(bit,Collections.binarySearch(cand,sum[i]),1);
        int ans=0;
        for(int i=1;i<sum.length;i++){
            plus(bit,Collections.binarySearch(cand,sum[i-1]),-1);
            ans+=get(bit,Collections.binarySearch(cand,sum[i-1]+upper));
            ans-=get(bit,Collections.binarySearch(cand,sum[i-1]+lower-1));
        }
        return ans;
    }
    public void plus(int[] bit,int i,int val){
        while(i<bit.length){
            bit[i]+=val;
            i+=i&-i;
        }
    }
    public int get(int[] bit,int i){
        int sum=0;
        while(i>0){
            sum+=bit[i];
            i-=i&-i;
        }
        return sum;
    }
}