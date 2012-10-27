package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: shenchen
 * Date: 12-10-27
 * Time: AM11:53
 * To change this template use File | Settings | File Templates.
 */
public class Combinations {
    public ArrayList<ArrayList<Integer>> combine(int n, int k) {
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
        solve(ret, new ArrayList<Integer>(), 1, k, n);
        return ret;
    }

    private void solve(ArrayList<ArrayList<Integer>> ret, List<Integer> list, int i, int k, int n) {
        if(k == 0) {
            ArrayList<Integer> tmp = new ArrayList<Integer>();
            tmp.addAll(list);
            ret.add(tmp);
            return;
        }

        for(int x = i ; x <= n - k + 1; x ++) {
            list.add(x);
            solve(ret, list, x + 1, k - 1, n);
            list.remove(list.size() - 1);
        }
    }
}
