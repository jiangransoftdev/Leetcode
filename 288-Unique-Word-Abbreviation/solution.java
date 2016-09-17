public class ValidWordAbbr {
    Map<String,String> map;
    public ValidWordAbbr(String[] dictionary) {
        map=new HashMap<>();
        for(String word:dictionary){
            String s=generate(word);
            if(map.containsKey(s)){
                if(!map.get(s).equals(word))
                    map.put(s,"");
            }
            else map.put(s,word);
        }
    }

    public boolean isUnique(String word) {
        return !map.containsKey(generate(word))||map.get(generate(word)).equals(word);
    }
    public String generate(String s){
        if(s.length()<=2) return s;
        else{
                String a=s.substring(0,1)+(s.length()-2)+s.substring(s.length()-1,s.length());
                return a;
        }
    }
}


// Your ValidWordAbbr object will be instantiated and called as such:
// ValidWordAbbr vwa = new ValidWordAbbr(dictionary);
// vwa.isUnique("Word");
// vwa.isUnique("anotherWord");