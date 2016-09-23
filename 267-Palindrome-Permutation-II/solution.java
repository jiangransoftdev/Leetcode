public class Solution {
    public List<String> generatePalindromes(String s) {
        List<String> res=new ArrayList<>();
        Map<Character,Integer> map=new HashMap<>();
        StringBuilder sb=new StringBuilder();
        String mid="";
        int odd=0;
        for(int i=0;i<s.length();i++){
            if(!map.containsKey(s.charAt(i)))
                map.put(s.charAt(i),1);
            else map.put(s.charAt(i),map.get(s.charAt(i))+1);
            odd+=(map.get(s.charAt(i))%2==0)?-1:1;
        }
        if(odd>1) return res;
        for(Map.Entry<Character,Integer> entry:map.entrySet()){
            char key=entry.getKey();
            int val=entry.getValue();
            if(val%2!=0) mid+=key;
            for(int i=0;i<val/2;i++)
                sb.append(key);
        }
        char[] c=sb.toString().toCharArray();
        helper(c,mid,0,res);
        return res;
    }
    public void helper(char[] c,String mid,int index,List<String> res){
        if(index==c.length){
            StringBuilder sb=new StringBuilder();
            for(int i=0;i<c.length;i++)
                sb.append(c[i]);
            res.add(sb.toString()+mid+sb.reverse().toString());
            sb.reverse();
            return;
        }
        for(int i=index;i<c.length;i++){
            if(isUsed(c,index,i)) continue;
            swap(c,index,i);
            helper(c,mid,index+1,res);
            swap(c,index,i);
        }
    }
    public boolean isUsed(char[] c,int i,int j){
        for(int a=i;a<j;a++)
            if(c[i]==c[j]) return true;
        return false;
    }
    public void swap(char[] c,int i,int j){
        char tmp=c[i];
        c[i]=c[j];
        c[j]=tmp;
    }
}