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
        if (num.length < 4)
            return ret;
        Arrays.sort(num);
        for (int i1 = 0; i1 < num.length - 3; i1 ++) {
            if (i1 != 0 && num[i1] == num[i1 - 1])
                continue;
            int target1 = target - num[i1];
            for (int i2 = i1 + 1; i2 < num.length -2; i2 ++) {
                if (i2 != i1 + 1 && num[i2] == num[i2 - 1])
                    continue;

                int target2 = target1 - num[i2];

                int i3 = i2 + 1;
                int i4 = num.length - 1;
                while (i3 < i4) {
                    boolean m3 = false;
                    boolean m4 = false;
                    int val = num[i3] + num[i4];
                    if (val == target2) {
                        ArrayList<Integer>list = new ArrayList<Integer>();
                        list.add(num[i1]); list.add(num[i2]); list.add(num[i3]); list.add(num[i4]);
                        ret.add(list);
                        m3 = true;
                        m4 = true;
                    } else if (val < target2)
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

    public static void main(String args[]) {
        Sum4_hard s4 = new Sum4_hard();
        s4.fourSum(new int[] {-497,-480,-477,-470,-452,-448,-440,-412,-390,-381,-372,-372,-369,-366,-355,-346,-340,-337,-322,-321,-311,-296,-258,-249,-248,-232,-215,-199,-174,-154,-128,-122,-122,-117,-115,-113,-110,-89,-86,-84,-78,-71,-69,-53,-49,-35,-25,-21,-7,3,7,21,25,30,47,52,81,84,87,91,96,157,161,167,178,184,210,217,228,236,274,277,283,286,290,301,302,341,352,354,361,367,384,390,412,421,458,468,483,484,486,487,490,491}, 8377);
    }
}
