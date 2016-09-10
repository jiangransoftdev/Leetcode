public class Solution {
    public boolean isRectangleCover(int[][] rectangles) {
        Set<String> set=new HashSet<>();
        int area=0,minx=Integer.MAX_VALUE,maxx=Integer.MIN_VALUE,miny=Integer.MAX_VALUE,maxy=Integer.MIN_VALUE;
        for(int[] rect:rectangles){
            minx=Math.min(minx,rect[0]);
            maxx=Math.max(maxx,rect[2]);
            miny=Math.min(miny,rect[1]);
            maxy=Math.max(maxy,rect[3]);
            area+=(rect[2]-rect[0])*(rect[3]-rect[1]);
            String t1=rect[0]+","+rect[1];
            String t2=rect[2]+","+rect[1];
            String t3=rect[0]+","+rect[3];
            String t4=rect[2]+","+rect[3];
            if(set.contains(t1)) set.remove(t1);
            else set.add(t1);
            if(set.contains(t2)) set.remove(t2);
            else set.add(t2);
            if(set.contains(t3)) set.remove(t3);
            else set.add(t3);
            if(set.contains(t4)) set.remove(t4);
            else set.add(t4);
        }
        String t1=minx+","+miny;
        String t2=minx+","+maxy;
        String t3=maxx+","+miny;
        String t4=maxx+","+maxy;
        if(!set.contains(t1)||!set.contains(t2)||!set.contains(t3)||!set.contains(t4)||set.size()!=4) return false;
        return (maxx-minx)*(maxy-miny)==area;
    }
}