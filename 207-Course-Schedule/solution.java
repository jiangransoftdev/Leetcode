public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(numCourses<=1) return true;
        List[] graph=new ArrayList[numCourses];
        for(int i=0;i<numCourses;i++)
        	graph[i]=new ArrayList();
        for(int i=0;i<prerequisites.length;i++)
        	graph[prerequisites[i][1]].add(prerequisites[i][0]);
        boolean[] visit=new boolean[numCourses];
        for(int i=0;i<numCourses;i++){
            if(!helper(i,visit,graph)) return false; 
        }
        return true;
    }
    public boolean helper(int course,boolean[] visit,List[] graph){
        if(visit[course]) return false;
        visit[course]=true;
        for(int i=0;i<graph[course].size();i++){
            if(!helper((int)graph[course].get(i),visit,graph)) return false;
        }
        visit[course]=false;
        return true;
    }
}