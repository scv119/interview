package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: shenchen
 * Date: 11/10/12
 * Time: 3:18 PM
 * To change this template use File | Settings | File Templates.
 */
public class Subset2 {
    public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
        if (num.length == 0)
            return ret;
        Arrays.sort(num);
        solve(num, 0, new ArrayList<Integer>(), ret);
        return ret;
    }

    void solve(int[] num, int idx, List<Integer> list, ArrayList<ArrayList<Integer>> ret) {
        int len = num.length;
        if (idx == len) {
            ArrayList<Integer> tmp = new ArrayList<Integer>();
            tmp.addAll(list);
            ret.add(tmp);
            return;
        }

        int value = num[idx];
        len   = 0;
        for (int i = idx; i < num.length; i ++) {
            if (num[i] == value)
                len ++;
            else
                break;
        }

        int next = idx + len;

        int len1= list.size();

        for (int i = 0; i <= len; i ++) {
            solve(num, next, list, ret);
            list.add(value);
        }

        while (list.size() > len1)
            list.remove(list.size() - 1);

        return;
    }

    public static void main(String args[]) {
        Subset2 ss = new Subset2();
        ss.subsetsWithDup(new int[]{0});
    }
}
