public class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> leaves=new ArrayList<>();
        if(n==1){
            leaves.add(0);
            return leaves;
        }
        List<Set<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++) adj.add(new HashSet<>());
        for(int i=0;i<edges.length;i++){
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }
        for(int i=0;i<n;i++)
            if(adj.get(i).size()==1) leaves.add(i);
        while(n>2){
            n-=leaves.size();
            List<Integer> another=new ArrayList<>();
            for(int i:leaves){
                int j=adj.get(i).iterator().next();
                adj.get(j).remove(i);
                if(adj.get(j).size()==1) another.add(j);
            }
            leaves=another;
        }
        return leaves;
    }
}