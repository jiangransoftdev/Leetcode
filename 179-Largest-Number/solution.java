public class Solution {
    public String largestNumber(int[] nums) {
       if(nums.length==0) return "";
		String[] str = new String[nums.length];
		for(int i=0;i<nums.length;i++){
			str[i]=nums[i]+"";
		}
		Comparator<String> comp=new Comparator<String>(){
			public int compare(String s1,String s2){
				String t1=s1+s2;
				String t2=s2+s1;
				return t1.compareTo(t2);
			}
		};
		Arrays.sort(str,comp);
		if(str[str.length-1].charAt(0)=='0')
			return "0";
		StringBuilder sb=new StringBuilder();
		for(String s:str){
			sb.insert(0, s);
		}
		return sb.toString();
    }
}