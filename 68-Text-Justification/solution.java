public class Solution {
    public List<String> fullJustify(String[] words, int L) {
        List<String> ans = new ArrayList<String>();  
    
    int n = words.length;  
    int i = 0;  
    while (i < n) {  
        int len = words[i].length();  
        int j = i + 1;  
        while (j < n && len + 1 + words[j].length() <= L) {  
            len += 1 + words[j].length();  
            j++;  
        }  
          
        String line = words[i];  
        if (j == n) { // if this is the last line  
            for (int k = i + 1; k < n; k++) {  
                line += " " + words[k];  
            }  
            while (line.length() < L) {  
                line += " ";  
            }  
        } else {  
            int extraWhite = L - len;  
            int whiteNum = j - i - 1;  
              
            if (whiteNum == 0) { // if this line has only one word  
                while (line.length() < L) {  
                    line += " ";  
                }  
            } else {  
                for (int k = i + 1; k < j; k++) {  
                    line += " ";  
                    for (int p = 0; p < extraWhite/whiteNum; p++) {  
                        line += " ";  
                    }  
                    if (k - i <= extraWhite%whiteNum) {  
                        line += " ";  
                    }  
                    line += words[k];  
                }  
            }  
        }  
        ans.add(line);  
          
        i = j;  
    }  
      
    return ans;  
    }
}