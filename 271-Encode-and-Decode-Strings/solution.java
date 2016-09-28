public class Codec {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder sb=new StringBuilder();
        for(String str:strs){
            int len=str.length();
            sb.append(len+"");
            sb.append("#"+str+"#");
        }
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> res=new ArrayList<>();
        int i=0;
        while(i<s.length()){
            int num=0;
            while(s.charAt(i)!='#'){
                num=num*10+s.charAt(i)-'0';
                i++;
            }
            String sub=s.substring(i+1,i+1+num);
            res.add(sub);
            i=i+2+num;
        }
        return res;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));