package leetcode2;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: shenchen
 * Date: 11/13/12
 * Time: 8:49 PM
 * To change this template use File | Settings | File Templates.
 */
public class Sum3 {
    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();

        Arrays.sort(num);


        for (int i1 = 0; i1 < num.length - 2; i1 ++) {
            if (i1 > 0 && num[i1] == num[i1 - 1])
                continue;
            if (num[i1] > 0)
                break;
            int target = 0 - num[i1];

            int i2 = i1 + 1;
            int i3 = num.length - 1;

            while (i2 < i3) {
                boolean m2 = false;
                boolean m3 = false;
                if (num[i2] + num[i3] == target) {
                    ArrayList<Integer> list = new ArrayList<Integer>();
                    list.add(num[i1]);
                    list.add(num[i2]);
                    list.add(num[i3]);
                    ret.add(list);
                    m2 = m3 = true;
                } else if (num[i2] + num[i3] < target) {
                    m2 = true;
                } else
                    m3 = true;

                while (m2 && i2 < i3) {
                    if (num[i2 + 1] != num[i2])
                        m2 = false;
                    i2 ++;
                }

                while (m3 && i2 < i3) {
                    if (num[i3 - 1] != num[i3])
                        m3 = false;
                    i3 --;
                }
            }
        }

        return ret;
    }
}
