public class Solution {
    final String[] Less20={"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
	    final String[] Tens={"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
	    final String[] Thousand={"","Thousand","Million","Billion"};
    public String numberToWords(int num) {
        if(num==0) return "Zero";
        String word="";
        int i=0;
        while(num>0){
            if(num%1000!=0)
                word=helper(num%1000)+Thousand[i]+" "+word;
            num/=1000;
            i++;
        }
        return word.trim();
    }
    public String helper(int num){
        if(num==0) return "";
        if(num<20) return Less20[num]+" ";
        if(num<100) return Tens[num/10]+" "+helper(num%10);
        return Less20[num/100]+" Hundred "+helper(num%100);
        
    }
}