public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List[] list=new ArrayList[numCourses];
        for(int i=0;i<numCourses;i++)
            list[i]=new ArrayList();
        for(int i=0;i<prerequisites.length;i++){
            list[prerequisites[i][0]].add(prerequisites[i][1]);
        }
        boolean[] visit=new boolean[numCourses];
        for(int i=0;i<numCourses;i++){
            if(!helper(list,i,visit))
                return false;
        }
        return true;
    }
    public boolean helper(List[] list,int course,boolean[] visit){
        if(visit[course]) return false;
        visit[course]=true;
        for(int j=0;j<list[course].size();j++){
            if(!helper(list,(int)list[course].get(j),visit)) return false;
        }
        visit[course]=false;
        return true;
    }
}