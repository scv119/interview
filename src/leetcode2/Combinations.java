package leetcode2;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: shenchen
 * Date: 12-11-15
 * Time: PM9:54
 * To change this template use File | Settings | File Templates.
 */
public class Combinations {
    public ArrayList<ArrayList<Integer>> combine(int n, int k) {
        assert(k <= n);
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>> ();
        int arr[] = new int[k];
        solve(arr, 0, 1, n, ret);
        return ret;
    }

    private void solve(int arr[], int idx, int cur, int n, ArrayList<ArrayList<Integer>>ret) {
        if(idx == arr.length) {
            ArrayList<Integer> list = new ArrayList<Integer>();
            for (int x : arr)
                list.add(x);
            ret.add(list);
            return;
        }

        int len = arr.length - idx - 1;

        for (int value = cur; value <= n - len; value ++) {
            arr[idx] = value;
            solve(arr, idx + 1, value + 1, n, ret);
        }

        return;
    }
}
