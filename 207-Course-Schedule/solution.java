public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List[] graph=new ArrayList[numCourses];
        boolean[] visit=new boolean[numCourses];
        for(int i=0;i<numCourses;i++)
        	graph[i]=new ArrayList();
        for(int i=0;i<prerequisites.length;i++)
        	graph[prerequisites[i][1]].add(prerequisites[i][0]);
        for(int i=0;i<numCourses;i++){
            if(!dfs(i,visit,graph))
                return false;
        }
        return true;
    }
    public boolean dfs(int course,boolean[] visit,List[] graph){
        if(visit[course]) return false;
        visit[course]=true;

        for(int i=0;i<graph[course].size();i++){
            if(!dfs((int)graph[course].get(i),visit,graph)) return false;
        }
        visit[course]=false;
        return true;
    }
}