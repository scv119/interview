package leetcode;

/**
 * Created with IntelliJ IDEA.
 * User: shenchen
 * Date: 12-10-29
 * Time: PM3:22
 * To change this template use File | Settings | File Templates.
 */
import java.util.*;
/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class MergeIntervals {

    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        Map<Integer,Integer> map = new HashMap<Integer, Integer>();
        ArrayList<Interval> ret = new ArrayList<Interval>();
        if(intervals.size() == 0)
            return ret;

        for(Interval it : intervals) {
            if(map.containsKey(it.start))
                map.put(it.start, map.get(it.start) + 1);
            else
                map.put(it.start, 1);

            if(map.containsKey(it.end))
                map.put(it.end, map.get(it.end) -1);
            else
                map.put(it.end, -1);
        }

        int[] arr = new int[map.size()];
        int idx1 = 0;
        for(Integer key : map.keySet()) {
            arr[idx1++] = key;
        }
        Arrays.sort(arr);

        Interval tmp = null;
        int count = 0;

        for(int idx : arr) {
            count += map.get(idx);
            if(count > 0 && tmp == null) {
                tmp = new Interval(idx, 0);
            } else if (count == 0 && tmp != null){
                tmp.end = idx;
                ret.add(tmp);
                tmp = null;
            } else if(count == 0 && tmp == null) {
                ret.add(new Interval(idx,idx));
            }
        }

        return ret;

    }
}