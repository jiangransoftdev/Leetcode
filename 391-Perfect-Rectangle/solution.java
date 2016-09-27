class Event{
    int time;
    int[] rect;
    public Event(int time,int[] rect){
        this.time=time;
        this.rect=rect;
    }
}
public class Solution {
    public boolean isRectangleCover(int[][] rectangles) {
        PriorityQueue<Event> pq=new PriorityQueue<>(new Comparator<Event>(){
            public int compare(Event a,Event b){
                if(a.time!=b.time) return a.time-b.time;
                return a.rect[0]-b.rect[0];
            }
        });
        int[] border={Integer.MAX_VALUE,Integer.MIN_VALUE};
        for(int[] rect:rectangles){
            Event a=new Event(rect[0],rect);
            Event b=new Event(rect[2],rect);
            pq.offer(a);
            pq.offer(b);
            if(rect[1]<border[0]) border[0]=rect[1];
            if(rect[3]>border[1]) border[1]=rect[3];
        }
        TreeSet<int[]> set=new TreeSet<>(new Comparator<int[]>(){
            public int compare(int[] a,int[] b){
                if(a[3]<=b[1]) return 1;
                else if(b[3]<=a[1]) return -1;
                else return 0;
            }
        }); 
        int y=0;
        while(!pq.isEmpty()){
            int time=pq.peek().time;
            while(!pq.isEmpty()&&pq.peek().time==time){
                Event e=pq.poll();
                int[] rect=e.rect;
                if(time==rect[2]){
                    set.remove(rect);
                    y-=rect[3]-rect[1];
                }
                else{
                    if(!set.add(rect)) return false;
                    y+=rect[3]-rect[1];
                }
            }
            if(!pq.isEmpty()&&y!=border[1]-border[0]) return false;
        }
        return true;
    }
}