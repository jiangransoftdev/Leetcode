
public class Solution {
    public boolean isReflected(int[][] points) {
        if(points.length==0) return true;
	    Set<String> set=new HashSet<>();
	    int maxx=Integer.MIN_VALUE,minx=Integer.MAX_VALUE;
        for(int[] point:points){
            maxx=Math.max(maxx,point[0]);
            minx=Math.min(minx,point[0]);
            String s=point[0]+"a"+point[1];
            set.add(s);
        }
        int sum=maxx+minx;
        for(int[] point:points){
            String s=(sum-point[0])+"a"+point[1];
            if(!set.contains(s)) return false;
        }
        return true;
    }
}