public class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        if(nums1.length==0||nums2.length==0) return new int[0];
        Map<Integer,Integer> map=new HashMap<>();
        for(int num:nums1){
            if(map.containsKey(num))
                map.put(num,map.get(num)+1);
            else map.put(num,1);
        }
        List<Integer> res=new ArrayList<>();
        for(int num:nums2){
            if(map.containsKey(num)){
                if(map.get(num)!=0){
                    res.add(num);
                    map.put(num,map.get(num)-1);
                }
            }
        }
        int[] ans=new int[res.size()];
        for(int i=0;i<res.size();i++)
            ans[i]=res.get(i);
        return ans;
            
    }
}