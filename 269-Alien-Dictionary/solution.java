public class Solution {
    public String alienOrder(String[] words) {
        int[] visit=new int[26];
        boolean[][] adj=new boolean[26][26];
        StringBuilder sb=new StringBuilder();
        build(words,visit,adj);
        for(int i=0;i<26;i++){
            if(visit[i]==0&&!helper(adj,visit,sb,i)) return "";
        }
        return sb.toString();
    }
    public boolean helper(boolean[][] adj,int[] visit,StringBuilder sb,int i){
        if(visit[i]==1) return false;
        visit[i]=1;
        for(int j=0;j<26;j++){
            if(adj[i][j]){
                if(visit[j]==1) return false;
                if(visit[j]==0&&!helper(adj,visit,sb,j)) return false;
            }
        }
        visit[i]=2;
        sb.insert(0,(char)('a'+i));
        return true;
    }
    
    public void build(String[] words,int[] visit,boolean[][] adj){
        Arrays.fill(visit,-1);
        for(int i=0;i<words.length;i++){
            for(int j=0;j<words[i].length();j++) visit[words[i].charAt(j)-'a']=0;
            if(i>0){
                String w1=words[i-1],w2=words[i];
                int len=Math.min(w1.length(),w2.length());
                for(int j=0;j<len;j++){
                    char c1=w1.charAt(j),c2=w2.charAt(j);
                    if(c1!=c2){
                        adj[c1-'a'][c2-'a']=true;
                        break;
                    }
                }
            }
        }
    }
}