public class Solution {
    int order;
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        order=numCourses;
        int[] res=new int[numCourses];
        List[] graph=new ArrayList[numCourses];
        int[] visit=new int[numCourses];
        for(int i=0;i<numCourses;i++)
            graph[i]=new ArrayList<>();
        for(int i=0;i<prerequisites.length;i++)
            graph[prerequisites[i][1]].add(prerequisites[i][0]);
        for(int i=0;i<numCourses;i++){
            if(visit[i]==0&&dfs(graph,i,visit,res)) return new int[0];
        }
        return res;
    }
    public boolean dfs(List[] graph,int course,int[] visit,int[] res){
        visit[course]=-1;
        for(int j=0;j<graph[course].size();j++){
            int c=(int)graph[course].get(j);
            if(visit[c]==-1) return true;
            else if(visit[c]==0&&dfs(graph,c,visit,res)) return true;
        }
        visit[course]=1;
        res[--order]=course;
        return false;
    }
}