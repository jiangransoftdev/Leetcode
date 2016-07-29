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
        int m=points.length,res=0;
        for(int i=0;i<m;i++){
            int count=0;
            int dup=0;
            Point p=points[i];
            for(int j=i+1;j<m;j++){
                Point q=points[j];
                if(p.x==q.x&&p.y==q.y){
                    dup++;
                    res=Math.max(res,dup+1);
                    continue;
                }
                count=1;
                for(int k=j+1;k<m;k++){
                    Point r=points[k];
                    count+=(isColinear(p,q,r))?1:0;
                }
                res=Math.max(res,count+dup+1);
            }
        }
        return res;
    }
    public boolean isColinear(Point p,Point q,Point r){
        return (p.y-q.y)*(q.x-r.x)==(p.x-q.x)*(q.y-r.y);
    }
}