public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        if(nums1.length==0||nums2.length==0) return new int[0];
        Set<Integer> set=new HashSet<>();
        Set<Integer> set2=new HashSet<>();
        for(int num:nums1)
            set.add(num);
        for(int num:nums2){
            if(set.contains(num))
                set2.add(num);
        }
        int[] res=new int[set2.size()];
        int i=0;
        for(int num:set2){
            res[i]=num;
            i++;
        }
        return res;
    }
}