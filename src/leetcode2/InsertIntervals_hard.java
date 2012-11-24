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
public class InsertIntervals_hard {
    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval nIt) {
        ArrayList<Interval> ret = new ArrayList<Interval>();

        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval i1, Interval i2) {
                return i1.start - i2.start;
            }
        });

        for (Interval it : intervals) {
            if (nIt != null) {
                if (it.end < nIt.start) {
                    ret.add(it);
                } else if (it.start > nIt.end) {
                    ret.add(nIt);
                    ret.add(it);
                    nIt = null;
                } else {
                    ret.add(it);
                    it.start = Math.min(it.start, nIt.start);
                    it.end   = Math.max(it.end, nIt.end);
                    nIt = null;
                }
            } else {
                if (ret.size() == 0 || ret.get(ret.size() - 1).end < it.start)
                    ret.add(it);
                else {
                    Interval tmp = ret.get(ret.size() - 1);
                    tmp.end = Math.max(tmp.end, it.end);
                }
            }
        }

        if (nIt != null)
            ret.add(nIt);

        return ret;
    }
}
