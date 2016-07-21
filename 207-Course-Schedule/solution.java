public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List[] graph=new ArrayList[numCourses];
        for(int i=0;i<numCourses;i++)
        	graph[i]=new ArrayList();
        for(int i=0;i<prerequisites.length;i++)
        	graph[prerequisites[i][1]].add(prerequisites[i][0]);
        boolean[] visit=new boolean[numCourses];
        for(int i=0;i<numCourses;i++)
        	if(!dfs(graph,visit,i))
        		return false;
        return true;
    }
public boolean dfs(List[] graph,boolean[] visit,int i){
	if(visit[i])
		return false;
	else
		visit[i]=true;
	for(int j=0;j<graph[i].size();j++){
		if(!dfs(graph,visit,(int)graph[i].get(j)))
			return false;
	}
	visit[i]=false;
	return true;
}
}