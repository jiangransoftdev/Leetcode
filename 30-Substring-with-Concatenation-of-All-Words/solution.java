public class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res=new ArrayList<>();
        Map<String,Integer> need=new HashMap<>();
        for(String word:words){
            if(need.containsKey(word)){
                need.put(word,need.get(word)+1);
            }
            else need.put(word,1);
        }
        for(int i=0;i<words[0].length();i++){
            int left=i,count=0;
            Map<String,Integer> curmap=new HashMap<>();
            for(int j=i;j+words[0].length()<=s.length();j+=words[0].length()){
                String str=s.substring(j,j+words[0].length());
                if(need.containsKey(str)){
                    if(curmap.containsKey(str))
                        curmap.put(str,curmap.get(str)+1);
                    else curmap.put(str,1);
                    if(curmap.get(str)<=need.get(str)) count++;
                    else{
                        while(curmap.get(str)>need.get(str)){
                            String tmp=s.substring(left,left+words[0].length());
                            curmap.put(tmp,curmap.get(tmp)-1);
                            if(curmap.get(tmp)<need.get(tmp)) count--;
                            left+=words[0].length();
                        }
                    }
                    if(count==words.length){
                            res.add(left);
                            String tmp=s.substring(left,left+words[0].length());
                            curmap.put(tmp,curmap.get(tmp)-1);
                            count--;
                            left+=words[0].length();
                        }
                }
                else{
                    curmap.clear();
                    left=j+words[0].length();
                    count=0;
                }
            }
            
        }
        return res;
    }
}