public class Solution {
    public String largestNumber(int[] nums) {
        if(nums.length==0) return "";
        String[] strs=new String[nums.length];
        for(int i=0;i<nums.length;i++)
            strs[i]=nums[i]+"";
        Arrays.sort(strs,new Comparator<String>(){
            public int compare(String s1,String s2){
                String t1=s1+s2;
                String t2=s2+s1;
                return t1.compareTo(t2);
            }
        });
        if(strs[strs.length-1].charAt(0)=='0') return "0";
        StringBuilder sb=new StringBuilder();
        for(String str:strs)
            sb.insert(0,str);
        return sb.toString();
    }
}