package leetcode2;

import leetcode.Interval;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created with IntelliJ IDEA.
 * User: shenchen
 * Date: 12-11-14
 * Time: PM11:32
 * To change this template use File | Settings | File Templates.
 */
public class InsertIntervals {
    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        ArrayList<Interval> ret = new ArrayList<Interval>();
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval interval, Interval interval1) {
                return interval.start - interval1.start;
            }
        });

        for (Interval it : intervals) {
            if (newInterval != null) {
                int start = Math.max(it.start, newInterval.start);
                int end   = Math.min(it.end, newInterval.end);

                if (start <= end) {
                    ret.add(new Interval(Math.min(it.start, newInterval.start), Math.max(it.end, newInterval.end)));
                    newInterval = null;
                } else if (it.start > newInterval.end){
                    ret.add(newInterval);
                    ret.add(it);
                    newInterval = null;
                } else
                    ret.add(it);
            } else {
                Interval last = ret.get(ret.size() - 1);
                int start = Math.max(last.start, it.start);
                int end   = Math.min(last.end, it.end);
                if (start <= end) {
                    last.start = Math.min(last.start, it.start);
                    last.end = Math.max(last.end, it.end);
                } else {
                    ret.add(it);
                }
            }
        }

        if (newInterval != null)
            ret.add(newInterval);
        return ret;
    }
}
