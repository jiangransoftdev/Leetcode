public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List[] graph=new ArrayList[numCourses];
        for(int i=0;i<numCourses;i++)
        	graph[i]=new ArrayList();
        for(int i=0;i<prerequisites.length;i++)
        	graph[prerequisites[i][1]].add(prerequisites[i][0]);
        int[] visit=new int[numCourses];
        for(int i=0;i<numCourses;i++)
        	if(visit[i]==0&&dfs(graph,visit,i))
        		return false;
        return true;
    }
public boolean dfs(List[] graph,int[] visit,int i){
	visit[i]=-1;
	for(int j=0;j<graph[i].size();j++){
	    if(visit[(int)graph[i].get(j)]==-1) return true;
		if(visit[(int)graph[i].get(j)]==0&&dfs(graph,visit,(int)graph[i].get(j)))
			return true;
	}
	visit[i]=1;
	return false;
}
}