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
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> res=new ArrayList<>();
        int l=0,h=intervals.size()-1;
        while(l<=h){
            int m=l+(h-l)/2;
            if(intervals.get(m).start>newInterval.start)
                h=m-1;
            else l=m+1;
        }
        intervals.add(l,newInterval);
        int start=intervals.get(0).start,end=intervals.get(0).end;
        for(int i=1;i<intervals.size();i++){
            int ts=intervals.get(i).start,te=intervals.get(i).end;
            if(ts<=end&&te>end){
                end=te;
            }
            else{
                if(ts>end){
                    res.add(new Interval(start,end));
                    start=ts;
                    end=te;
                }
            }
        }
        res.add(new Interval(start,end));
        return res;
    }
}