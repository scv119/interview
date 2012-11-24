package leetcode2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: shenchen
 * Date: 12-11-20
 * Time: AM12:40
 * To change this template use File | Settings | File Templates.
 */
public class CombinationSum2 {
    public ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target) {
        assert num != null;
        Arrays.sort(num);
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
        solve(num, 0, target, new ArrayList<Integer>(), ret);
        return ret;
    }

    private void solve(int[] num, int idx, int target, List<Integer> list, ArrayList<ArrayList<Integer>> ret) {
        if (target == 0) {
            ArrayList<Integer> tmp = new ArrayList<Integer>();
            tmp.addAll(list);
            ret.add(tmp);
            return ;
        }

        if (idx == num.length || num[idx] > target)
            return;

        int count = 1;

        while (idx + count < num.length && num[idx + count] == num[idx])
            count ++;

        int size = list.size();

        solve(num, idx + count, target, list, ret);

        for (int i = 0; i < count; i ++) {
            if (target < num[idx])
                break;
            target = target - num[idx];
            list.add(num[idx]);
            solve(num, idx + count, target, list, ret);
        }

        while (list.size() > size)
            list.remove(list.size() - 1);

        return;
    }
}
