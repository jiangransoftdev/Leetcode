/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> res=new ArrayList<>();
        if(intervals.size()==0) return res;
        Collections.sort(intervals,new Comparator<Interval>(){
            public int compare(Interval a,Interval b){
                if(a.start!=b.start) return a.start-b.start;
                else return a.end-b.end;
            }
            });
        int i=1,start=intervals.get(0).start,end=intervals.get(0).end;
        while(i<intervals.size()){
            int tstart=intervals.get(i).start,tend=intervals.get(i).end;
            if(tstart>end){
                res.add(new Interval(start,end));
                start=tstart;
                end=tend;
            }
            else{
                if(tend>end)
                    end=tend;
            }
            i++;
        }
        res.add(new Interval(start,end));
        return res;
    }
}