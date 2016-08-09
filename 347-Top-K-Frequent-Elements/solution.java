public class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer>[] bucket=new List[nums.length+1];
        List<Integer> res=new ArrayList<>();
        Map<Integer,Integer> map=new HashMap<>();
        for(int num:nums){
            if(map.containsKey(num))
                map.put(num,map.get(num)+1);
            else map.put(num,1);
        }
        for(int key:map.keySet()){
            int f=map.get(key);
            if(bucket[f]==null){
                bucket[f]=new ArrayList<>();
            }
            bucket[f].add(key);
        }
        for(int i=bucket.length-1;i>=0&&res.size()<k;i--){
            if(bucket[i]!=null)
                res.addAll(bucket[i]);
        }
        return res;
    }
}