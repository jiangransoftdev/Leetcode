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
        for(Interval i:intervals){
            if(i.end<newInterval.start)
                res.add(i);
            else if(i.start>newInterval.end){
                res.add(newInterval);
                newInterval=i;
            }
            else{
                if(i.start<=newInterval.end||i.end>=newInterval.start){
                    newInterval=new Interval(Math.min(i.start,newInterval.start),Math.max(i.end,newInterval.end));
                }
            }
        }
        res.add(newInterval);
        return res;
    }
}