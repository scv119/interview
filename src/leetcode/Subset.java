package leetcode;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: shenchen
 * Date: 11/10/12
 * Time: 2:52 PM
 * To change this template use File | Settings | File Templates.
 */
public class Subset {
    public ArrayList<ArrayList<Integer>> subsets(int[] S) {
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();

        if (S.length == 0)
            return ret;
        Arrays.sort(S);
        long max = (long) Math.pow(2, S.length);

        for (long x = 0; x < max; x ++) {
            ArrayList<Integer> list = new ArrayList<Integer>();
            long tmp = x;
            for (int i = 0; i < S.length; i ++) {
                if (tmp == 0)
                    break;
                if (tmp % 2 == 1) list.add(S[i]);
                tmp = tmp / 2;
            }
            ret.add(list);
        }

        return ret;
    }
}
