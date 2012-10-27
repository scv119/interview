package leetcode;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: shenchen
 * Date: 12-10-27
 * Time: PM11:09
 * To change this template use File | Settings | File Templates.
 */
public class GrayCode {
    public ArrayList<Integer> grayCode(int n) {

        int length = (int)Math.pow(2, n);
        ArrayList<Integer> ret = new ArrayList<Integer>(length);
        for(int i = 0 ; i < length; i ++) {
            int value = 0;
            int mask  = 4;
            for(int bit = 0; bit < n; bit ++) {
                int tmp = i % mask;
                if(tmp >= mask/4 && tmp < 3 * mask / 4) {
                    value = value | (mask/4);
                }
                mask = mask << 1;
            }
            ret.add(value);
        }
        return ret;

    }
}
