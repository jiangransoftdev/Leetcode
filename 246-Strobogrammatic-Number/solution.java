public class Solution {
    public boolean isStrobogrammatic(String num) {
        Map<Character,Character> map=new HashMap<>();
        map.put('6','9');
        map.put('9','6');
        map.put('1','1');
        map.put('8','8');
        map.put('0','0');
        for(int i=0;i<(num.length()+1)/2;i++){
            char c=num.charAt(i);
            char cc=num.charAt(num.length()-1-i);
            if(!map.containsKey(c)||map.get(c)!=cc) return false;
        }
        return true;
    }
}