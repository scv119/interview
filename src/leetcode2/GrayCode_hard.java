package leetcode2;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: shenchen
 * Date: 12-11-14
 * Time: PM10:50
 * To change this template use File | Settings | File Templates.
 */
public class GrayCode_hard {
    public ArrayList<Integer> grayCode(int n) {
        ArrayList<Integer> ret = new ArrayList<Integer>();

        int limit = (int)Math.pow(2, n);
        for (int i = 0; i < limit; i ++) {
            int size = 4;
            int value = 0;
            for (int j = 0; j < n; j ++) {
                int tmp = i % size;
                if (tmp >= size/4 && tmp < size/4 * 3)
                    value += size/4;
                size = size * 2;
            }
            ret.add(value);
        }

        return ret;
    }
}
