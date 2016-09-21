public class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        Map<String,Integer> need=new HashMap<>();
        List<Integer> res=new ArrayList<>();
        for(String word:words){
            if(!need.containsKey(word))
                need.put(word,1);
            else need.put(word,need.get(word)+1);
        }
        int len=words[0].length();
        for(int i=0;i<len;i++){
            int left=i;
            int count=0;
            Map<String,Integer> found=new HashMap<>();
            for(int j=i;j+len<=s.length();j+=len){
                String sub=s.substring(j,j+len);
                if(need.containsKey(sub)){
                    if(!found.containsKey(sub))
                        found.put(sub,1);
                    else found.put(sub,found.get(sub)+1);
                    if(found.get(sub)<=need.get(sub))
                        count++;
                    else{
                        while(found.get(sub)>need.get(sub)){
                            String start=s.substring(left,left+len);
                            found.put(start,found.get(start)-1);
                            if(found.get(start)<need.get(sub)) count--;
                            left+=len;
                        }
                    }
                    if(count==words.length){
                        res.add(left);
                        String temp=s.substring(left,left+len);
						found.put(temp, found.get(temp)-1);
						count--;
						left+=len;
                    }
                }
                else{
                    found.clear();
                    count=0;
                    left=j+len;
                }
            }
        }
        return res;
    }
}