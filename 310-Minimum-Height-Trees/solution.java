public class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> res=new ArrayList<>();
        if(edges.length==0) {
            res.add(0);
            return res;
        }
        boolean[] visit=new boolean[n];
        int[] d=new int[n];
        List[] graph=new ArrayList[n];
        for(int i=0;i<n;i++)
            graph[i]=new ArrayList();
        for(int i=0;i<edges.length;i++){
        	graph[edges[i][0]].add(edges[i][1]);
        	graph[edges[i][1]].add(edges[i][0]);
        	d[edges[i][0]]++;
        	d[edges[i][1]]++;
        }
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<d.length;i++){
            if(d[i]==1) {
                q.offer(i);
                visit[i]=true;
            }
        }
        while(!q.isEmpty()){
            int size=q.size();            
            res.clear();
            for(int i=0;i<size;i++){
            	int node=q.poll();
            	res.add(node);
            	for(int j=0;j<graph[node].size();j++){
            		if(!visit[(int)graph[node].get(j)]){
            			d[(int)graph[node].get(j)]--;
            			if(d[(int)graph[node].get(j)]==1){
            				q.offer((int)graph[node].get(j));
            				visit[(int)graph[node].get(j)]=true;
            			}
            		}
            	}
            }
        }
        return res;
    }
}