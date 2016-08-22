public class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res=new ArrayList<>();
        Map<String,Integer> map=new HashMap<>();
        for(int i=0;i<words.length;i++){
            if(!map.containsKey(words[i]))
                map.put(words[i],1);
            else map.put(words[i],map.get(words[i])+1);
        }
        for(int i=0;i<words[0].length();i++){
            int left=i;
            int count=0;
            Map<String,Integer> curmap=new HashMap<>();
            for(int j=i;j+words[0].length()<=s.length();j+=words[0].length()){
                String str=s.substring(j,j+words[0].length());
                if(map.containsKey(str)){
                    if(!curmap.containsKey(str))
                        curmap.put(str,1);
                    else curmap.put(str,curmap.get(str)+1);
                    if(curmap.get(str)<=map.get(str))
                        count++;
                    else{
                        while(curmap.get(str)>map.get(str)){
                            String tmp=s.substring(left,left+words[0].length());
                            curmap.put(tmp,curmap.get(tmp)-1);
                            if(curmap.get(tmp)<map.get(tmp))
                                count--;
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
                    count=0;
                    curmap.clear();
                    left=j+words[0].length();
                }
            }
        }
        return res;
    }
}