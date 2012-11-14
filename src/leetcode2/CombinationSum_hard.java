package leetcode2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: shenchen
 * Date: 12-11-14
 * Time: PM9:45
 * To change this template use File | Settings | File Templates.
 */
public class CombinationSum_hard {
    public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
        Arrays.sort(candidates);
        solve(candidates, 0, target, new ArrayList<Integer>(), ret);
        return ret;
    }

    private void solve(int num[], int idx, int target, List<Integer> list, ArrayList<ArrayList<Integer>> ret) {
        if (target == 0) {
            ArrayList<Integer> tmp = new ArrayList<Integer> ();
            tmp.addAll(list);
            ret.add(tmp);
            return;
        }

        if (idx == num.length)
            return;

        if (num[idx] > target)
            return;

        int tmp = list.size();

        solve(num, idx + 1, target, list, ret);
        while (target >= num[idx]) {
            list.add(num[idx]);
            target -= num[idx];
            solve(num, idx + 1, target, list, ret);
        }

        while (list.size() > tmp)
            list.remove(list.size() - 1);

        return;
    }
}
