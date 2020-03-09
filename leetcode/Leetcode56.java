import sun.jvm.hotspot.utilities.Interval;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class Leetcode56 {

     class Interval {
      int start;
      int end;
      Interval() { start = 0; end = 0; }
      Interval(int s, int e) { start = s; end = e; }
  }
    public List<Interval> merge(List<Interval> intervals) {

        List<Interval> res = new LinkedList<>();
        if (intervals.size()==0)
            return res;
        sort(intervals);
        Interval start = intervals.get(0);
        for (int i = 1; i < intervals.size(); i++) {
            Interval temp = intervals.get(i);
            if (start.end<temp.start){
                res.add(start);
                start = temp;
            }else {
                start.end = Math.max(start.end,temp.end);
            }
        }
        res.add(start);
        return res;

    }

    private void sort(List<Interval> intervals) {

        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start<o2.start?-1:o1.start==o2.start?0:1;
            }
        });
    }
}
