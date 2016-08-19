class Point{
    int val;
    int height;
    int flag;
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
        for(int i=0;i<buildings.length;i++){
            points.add(new Point(buildings[i][0],buildings[i][2],0));
            points.add(new Point(buildings[i][1],buildings[i][2],1));
        }
        Collections.sort(points,new Comparator<Point>(){
            public int compare(Point a,Point b){
                if(a.val!=b.val) return a.val-b.val;
                if(a.flag!=b.flag) return a.flag-b.flag;
                if(a.flag==0&&b.flag==0) return b.height-a.height;
                return a.height-b.height;
            }
        });
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        for(Point point:points){
            if(point.flag==0){
                if(pq.isEmpty()||point.height>pq.peek()){
                    int[] key={point.val,point.height};
                    res.add(key);
                }
                pq.offer(point.height);
            }
            else{
                if(point.height==pq.peek()){
                    pq.poll();
                    if(pq.isEmpty()||point.height>pq.peek()){
                        int[] keyPoint = new int[2];
	                    keyPoint[0] = point.val;
	                    keyPoint[1] = pq.isEmpty() ? 0 : pq.peek();
	                    res.add(keyPoint);
                    }
                    
                }
                else
                    pq.remove(point.height);
            }
            
        }
        return res;
    }
}