package leetcode;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: shenchen
 * Date: 12-11-4
 * Time: PM10:50
 * To change this template use File | Settings | File Templates.
 */
public class PascalsTriangle {
    public ArrayList<ArrayList<Integer>> generate(int numRows) {
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();

        for (int i = 0; i < numRows; i ++) {
            ArrayList<Integer> cur = new ArrayList<Integer>();
            if (i == 0) {
                cur.add(1);
            } else {
                ArrayList<Integer> pre = ret.get(ret.size() - 1);
                cur.add(1);
                for (int j = 0; j < pre.size() - 1; j ++)
                    cur.add(pre.get(j) + pre.get(j+1));
                cur.add(1);
            }
            ret.add(cur);
        }

        return ret;
    }
}
