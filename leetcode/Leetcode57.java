import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class Leetcode57 {
    class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }

    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> res = new LinkedList<>();
        if (intervals.size()==0){
            res.add(newInterval);
        }
        int position=0;
        for (int i = 0; i < intervals.size(); i++) {
            Interval interval = intervals.get(i);
            if (interval.start>newInterval.end){
                res.add(interval);
            }else if (interval.end<newInterval.start){
                res.add(interval);
                i++;
            }else {
                newInterval.start = Math.min(interval.start,newInterval.start);
                newInterval.end = Math.max(interval.end,newInterval.end);
            }
        }
        res.add(position,newInterval);
        return res;

    }


}
