public class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer,Integer> map=new HashMap<>();
        List<Integer> list=new ArrayList<>();
        for(int num:nums1){
            if(!map.containsKey(num))
                map.put(num,1);
            else map.put(num,map.get(num)+1);
        }
        for(int num:nums2){
            if(map.containsKey(num)&&map.get(num)>0){
                list.add(num);
                map.put(num,map.get(num)-1);
            }
        }
        int[] res=new int[list.size()];
        for(int i=0;i<res.length;i++)
            res[i]=list.get(i);
        return res;
    }
}