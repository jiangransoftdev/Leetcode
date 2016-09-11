public class Solution {
    public String largestNumber(int[] nums) {
        if(nums.length==0) return "";
        String[] str=new String[nums.length];
        for(int i=0;i<nums.length;i++)
            str[i]=nums[i]+"";
        Arrays.sort(str,new Comparator<String>(){
            public int compare(String a,String b){
                String t1=a+b;
                String t2=b+a;
                return t1.compareTo(t2);
            }
        });
        StringBuilder sb=new StringBuilder();
        if(str[str.length-1].charAt(0)=='0') return "0";
        for(String s:str)
            sb.insert(0,s);
        return sb.toString();
    }
}