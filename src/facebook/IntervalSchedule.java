package facebook;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: shenchen
 * Date: 10/26/12
 * Time: 6:04 PM
 * To change this template use File | Settings | File Templates.
 */
public class IntervalSchedule {
    public static class Interval implements Comparable {
        int start;
        int end;

        @Override
        public int compareTo(Object o) {
            return this.end - ((Interval)o).end;
        }
    }

    public int max(int start[], int end[]) {
        Interval[] intvs = new Interval[start.length];

        for(int i = 0 ; i < start.length; i ++) {
            intvs[i] = new Interval();
            intvs[i].start = start[i];
            intvs[i].end   = end[i];
        }

        Arrays.sort(intvs);

        int now = Integer.MIN_VALUE;
        int ret = 0;

        for(int i = 0 ; i < start.length; i ++) {
            if(intvs[i].start < now)
                continue;
            else {
                now = intvs[i].end;
                ret ++;
            }
        }

        return ret;
    }

    public static void main(String args[]) {
        IntervalSchedule is = new IntervalSchedule();
        System.out.println(is.max(new int[]{1,2,3,0}, new int[]{2,3,4,6}));
    }
}
