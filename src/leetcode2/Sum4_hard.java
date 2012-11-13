package leetcode2;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: shenchen
 * Date: 11/13/12
 * Time: 9:50 PM
 * To change this template use File | Settings | File Templates.
 */
public class Sum4_hard {
    public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();

        Arrays.sort(num);

        for (int i1 = 0; i1 < num.length - 3; i1 ++) {
            if (i1 > 0 && num[i1] == num[i1 - 1])
                continue;
            int target1 = target - num[i1];
            for (int i2 = i1 + 1; i2 < num.length -2; i2 ++) {
                if (i2 > i1 + 1 && num[i2] == num[i2 - 1])
                    continue;
                int target2 = target1 - num[i2];
                int i3 = i2 + 1;
                int i4 = num.length - 1;

                while (i3 < i4) {
                    boolean m3 = false;
                    boolean m4 = false;
                    if (num[i3] + num[i4] == target2) {
                        m3 = true;
                        m4 = true;
                        ArrayList<Integer> list = new ArrayList<Integer>();
                        list.add(num[i1]); list.add(num[i2]);
                        list.add(num[i3]); list.add(num[i4]);
                        ret.add(list);
                    } else if (num[i3] + num[i4] < target2)
                        m3 = true;
                    else
                        m4 = true;

                    while (m3 && i3 < i4) {
                        if (num[i3] != num[i3 + 1])
                            m3 = false;
                        i3 ++;
                    }

                    while (m4 && i3 < i4) {
                        if (num[i4] != num[i4 - 1])
                            m4 = false;
                        i4 --;
                    }
                }
            }
        }

        return ret;
    }
}
