public class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res=new ArrayList<>();
        int n=words.length,i=0;
        while(i<n){
            int len=words[i].length();
            int j=i+1;
            while(j<n&&len+1+words[j].length()<=maxWidth){
                len+=1+words[j].length();
                j++;
            }
            String line=words[i];
            if(j==n){
                for(int k=i+1;k<n;k++)
                    line+=" "+words[k];
                while(line.length()<maxWidth)
                    line+=" ";
            }
            else{
                int extraspace=maxWidth-len;
                int spacenum=j-i-1;
                if(spacenum==0){
                    while(line.length()<maxWidth)
                        line+=" ";
                }
                else{
                    for(int k=i+1;k<j;k++){
                        line+=" ";
                        for(int p=0;p<extraspace/spacenum;p++)
                            line+=" ";
                        if(k-i<=extraspace%spacenum)
                            line+=" ";
                        line+=words[k];
                    }
                }
            }
            res.add(line);
            i=j;
        }
        return res;
    }
}