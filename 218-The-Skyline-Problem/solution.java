class Point{
    int val,height,flag;
    public Point(int val,int height,int flag){
        this.val=val;
        this.height=height;
        this.flag=flag;
    }
}
public class Solution {
    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> res=new ArrayList<>();
        List<Point> points=new ArrayList<>();
        for(int[] b:buildings){
            points.add(new Point(b[0],b[2],0));
            points.add(new Point(b[1],b[2],1));
        }
        Collections.sort(points,new Comparator<Point>(){
            public int compare(Point a,Point b){
                if(a.val!=b.val) return a.val-b.val;
                else if(a.flag!=b.flag) return a.flag-b.flag;
                else if(a.flag==0) return b.height-a.height;
                else return a.height-b.height;
            }
        });
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        for(Point point:points){
            if(point.flag==0){
                if(pq.isEmpty()||point.height>pq.peek()){
                    int[] ans={point.val,point.height};
                    res.add(ans);
                }
                pq.offer(point.height);
            }
            else{
                pq.remove(point.height);
                if(pq.isEmpty()||point.height>pq.peek()){
                    int[] ans={point.val,pq.isEmpty()?0:pq.peek()};
                    res.add(ans);
                }
            }
        }
        return res;
    }
}