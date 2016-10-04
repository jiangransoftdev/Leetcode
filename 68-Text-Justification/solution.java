public class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res=new ArrayList<>();
        int i=0,n=words.length;
        while(i<n){
            int j=i+1,len=words[i].length();
            while(j<n&&len+1+words[j].length()<=maxWidth){
                len+=words[j].length()+1;
                j++;
                
            }
            String line=words[i];
            if(j==n){
                for(int k=i+1;k<j;k++)
                    line+=" "+words[k];
                while(line.length()<maxWidth)
                    line+=" ";
            }
            else{
                int whiteNum=j-i-1;
                int extraNum=maxWidth-len;
                if(whiteNum==0)
                    while(line.length()<maxWidth)
                        line+=" ";
                else{
                    for(int k=i+1;k<j;k++){
                        line+=" ";
                        for(int m=0;m<extraNum/whiteNum;m++)
                            line+=" ";
                        if(k-i<=extraNum%whiteNum) line+=" ";
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