/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
public class Solution {
    public int maxPoints(Point[] points) {
        if(points.length<=2) return points.length;
        int res=0;
        for(int i=0;i<points.length;i++){
            Point p=points[i];
            int count=0,dup=0;
            for(int j=i+1;j<points.length;j++){
                Point q=points[j];
                if(p.x==q.x&&p.y==q.y){
                    dup++;
                    res=Math.max(res,dup+1);
                    continue;
                }
                count=1;
                for(int k=j+1;k<points.length;k++){
                    Point r=points[k];
                    if(isColinear(p,q,r))
                        count++;
                }
                res=Math.max(res,count+dup+1);
            }
        }
        return res;
    }
    public boolean isColinear(Point p,Point q,Point r){
        int val=(q.y-r.y)*(p.x-q.x)-(q.x-r.x)*(p.y-q.y);
        return val==0;
    }
}