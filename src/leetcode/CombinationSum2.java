package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: shenchen
 * Date: 12-10-27
 * Time: PM7:30
 * To change this template use File | Settings | File Templates.
 */
public class CombinationSum2 {
    public ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target) {
        List<Integer> num1 = new ArrayList<Integer>();
        List<Integer> count = new ArrayList<Integer>();

        Arrays.sort(num);

        for(int i:num) {
            if(num1.size() == 0 || num1.get(num1.size() - 1) != i) {
                num1.add(i);
                count.add(1);
            } else {
                int value = count.get(count.size() - 1);
                count.remove(count.size() - 1);
                count.add(value + 1);
            }
        }

        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();

        List<Integer> list = new ArrayList<Integer>();

        solve(ret, list, num1, count, 0, target);

        return ret;

    }

    private void solve(ArrayList<ArrayList<Integer>> save, List<Integer> list, List<Integer> num, List<Integer> count, int idx, int target) {
        if(target == 0) {
            ArrayList<Integer> tmp = new ArrayList<Integer>();
            tmp.addAll(list);
            save.add(tmp);
            return;
        }

        if(idx >= num.size())
            return;

        if(num.get(idx) > target)
            return;

        int curSize = list.size();
        int value   = num.get(idx);

        for(int i = 0 ; i <= count.get(idx); i ++) {
            solve(save, list, num, count, idx + 1, target);
            target = target - value;
            if(target < 0)
                break;
            list.add(value);
        }

        while(list.size() > curSize)
            list.remove(list.size() - 1);

        return;
    }
}
