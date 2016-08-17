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
        Collections.sort(intervals, new Comparator<Interval>(){
        	public int compare(Interval a,Interval b){
        		return a.start-b.start;
        	}
        });
        List<Interval> res=new ArrayList<>();
        if(intervals.size()==0) return res;
        int start=intervals.get(0).start;
        int end=intervals.get(0).end;
        for(int i=1;i<intervals.size();i++){
            int tstart=intervals.get(i).start;
            int tend=intervals.get(i).end;
            if(tstart>end){
                res.add(new Interval(start,end));
                start=tstart;
                end=tend;
            }
            else if(tstart<=end&&tend>end){
                end=tend;
            }
        }
        res.add(new Interval(start,end));
        return res;
    }
}