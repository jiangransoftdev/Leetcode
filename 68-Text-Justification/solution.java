public class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res=new ArrayList<>();
        int n=words.length;
        int i=0;
        while(i<n){
            int len=words[i].length();
            int j=i+1;
            while(j<n&&len+words[j].length()+1<=maxWidth){
                len+=1+words[j].length();
                j++;
            }
            String line=words[i];
            if(j==n){
                for(int k=i+1;k<n;k++){
                    line+=" "+words[k];
                }
                while(line.length()<maxWidth)
                    line+=" ";
            }
            else{
                int extraWhite=maxWidth-len;
                int whiteNum=j-i-1;
                if(whiteNum==0){
                    while(line.length()<maxWidth)
                        line+=" ";
                }
                else{
                    for(int k=i+1;k<j;k++){
                        line+=" ";
                        for(int p=0;p<extraWhite/whiteNum;p++)
                            line+=" ";
                        if(k-i<=extraWhite%whiteNum)
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