public class Solution {
    int index;
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] res=new int[numCourses],visit=new int[numCourses];
        index=numCourses-1;
        Map<Integer,List<Integer>> map=new HashMap<>();
        for(int i=0;i<numCourses;i++) map.put(i,new ArrayList<>());
        for(int i=0;i<prerequisites.length;i++) map.get(prerequisites[i][1]).add(prerequisites[i][0]);
        for(int i=0;i<numCourses;i++){
            if(visit[i]==0&&!helper(i,visit,map,res)) return new int[0];
        }
        return res;
    }
    public boolean helper(int course,int[] visit,Map<Integer,List<Integer>> map,int[] res){
        if(visit[course]==-1) return false;
        visit[course]=-1;
        List<Integer> list=map.get(course);
        for(int c:list){
            if(visit[c]==-1) return false;
            if(visit[c]==0&&!helper(c,visit,map,res)) return false;
        }
        visit[course]=1;
        res[index--]=course;
        return true;
    }
}