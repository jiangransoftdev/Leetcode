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
                else return a.height-b.height;
            }
        });
        PriorityQueue<Integer> heights=new PriorityQueue<>(Collections.reverseOrder());
        for(Point p:points){
            if(p.flag==0){
                if(heights.isEmpty()||p.height>heights.peek()){
                    int[] keyPoint=new int[2];
                    keyPoint[0]=p.val;
                    keyPoint[1]=p.height;
                    res.add(keyPoint);
                }
                heights.add(p.height);
            }
            else{
                if(p.height==heights.peek()){
                    heights.poll();
                    if(heights.isEmpty()||p.height>heights.peek()){
                        int[] keyPoint=new int[2];
                    keyPoint[0]=p.val;
                    keyPoint[1]=heights.isEmpty()?0:heights.peek();
                    res.add(keyPoint);
                    }
                }
                else
                    heights.remove(p.height);
            }
        }
        return res;
    }
    
}