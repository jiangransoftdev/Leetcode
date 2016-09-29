public class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> res=new ArrayList<>();
        Map<String,Integer> map=new HashMap<>();
        for(int i=0;i<words.length;i++)
            map.put(words[i],i);
        for(int i=0;i<words.length;i++){
            int l=0,r=0;
            while(l<=r){
                String s=words[i].substring(l,r);
                Integer j=map.get(new StringBuilder(s).reverse().toString());
                if(j!=null&&i!=j&&isPalindrome(words[i].substring(l==0?r:0,l==0?words[i].length():l)))
                    res.add(Arrays.asList(l==0?new Integer[]{i,j}:new Integer[]{j,i}));
                if(r<words[i].length())
                    r++;
                else l++;
            }
        }
        return res;
    }
    public boolean isPalindrome(String s){
        int i=0,j=s.length()-1;
        while(i<j){
            if(s.charAt(i++)!=s.charAt(j--)) return false;
        }
        return true;
    }
}