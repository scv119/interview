package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created with IntelliJ IDEA.
 * User: shenchen
 * Date: 12-10-28
 * Time: PM1:28
 * To change this template use File | Settings | File Templates.
 */
public class InsertIntervals {
    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval nit) {
        // Start typing your Java solution below
        // DO NOT write main() function
        Collections.sort(intervals, new MyComparator());

        ArrayList<Interval> ret = new ArrayList<Interval>();
        boolean add = false;
        for(Interval it : intervals) {
            if(it.end < nit.start) {
                ret.add(it);
            } else if (it.start > nit.end) {
                if(!add) {
                    ret.add(nit);
                    add = true;
                }

                ret.add(it);

            } else {
                nit = new Interval(Math.min(it.start, nit.start), Math.max(it.end, nit.end));
            }
        }

        if(!add)
            ret.add(nit);
        return ret;

    }

    public class MyComparator implements Comparator<Interval> {
        @Override
        public int compare(Interval a1, Interval a2) {
            return a1.start - a2.start;
        }
    }
}
