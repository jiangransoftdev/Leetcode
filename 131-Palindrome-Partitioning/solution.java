public class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res=new ArrayList<>();
        if(s.length()==0) return res;
        helper(s,new ArrayList<>(),res);
        return res;
    }
    public void helper(String s,List<String> solu,List<List<String>> res){
        if(s.length()==0){
            res.add(new ArrayList<>(solu));
            return;
        }
        for(int i=1;i<=s.length();i++){
            String sub=s.substring(0,i);
            if(isPalindrome(sub)){
                solu.add(sub);
                helper(s.substring(i),solu,res);
                solu.remove(solu.size()-1);
            }
        }
    }
    public boolean isPalindrome(String s){
        int i=0,j=s.length()-1;
        while(i<j){
            if(s.charAt(i++)!=s.charAt(j--)) return false;
        }
        return true;
    }
}