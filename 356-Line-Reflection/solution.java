public class Solution {
    public boolean isReflected(int[][] points) {
        int minx=Integer.MAX_VALUE,maxx=Integer.MIN_VALUE;
        HashSet<String> set=new HashSet<>();
        for(int i=0;i<points.length;i++){
            minx=Math.min(points[i][0],minx);
            maxx=Math.max(points[i][0],maxx);
            String str=points[i][0]+"a"+points[i][1];
            set.add(str);
        }
        int sum=minx+maxx;
        for(int[] point:points){
            String str=(sum-point[0])+"a"+point[1];
            if(!set.contains(str)) return false;
        }
        return true;
    }
}