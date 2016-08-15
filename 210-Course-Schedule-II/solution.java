public class Solution {
    int index;
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        index=numCourses-1;
        int[] visit=new int[numCourses];
        List<List<Integer>> graph=new ArrayList<>();
        for(int i=0;i<numCourses;i++)
            graph.add(new ArrayList<>());
        for(int i=0;i<prerequisites.length;i++)
            graph.get(prerequisites[i][1]).add(prerequisites[i][0]);
        int[] res=new int[numCourses];
        for(int i=0;i<numCourses;i++)
            if(visit[i]==0&&dfs(i,graph,visit,res)) return new int[0];
        return res;
    }
    public boolean dfs(int courses,List<List<Integer>> graph,int[] visit,int[] res){
        visit[courses]=-1;
        for(int course:graph.get(courses)){
            if(visit[course]==-1) return true;
            else if(visit[course]==0&&dfs(course,graph,visit,res)) return true;
        }
        visit[courses]=1;
        res[index--]=courses;
        return false;
    }
}