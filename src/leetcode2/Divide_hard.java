package leetcode2;

/**
 * Created with IntelliJ IDEA.
 * User: shenchen
 * Date: 12-11-14
 * Time: AM12:43
 * To change this template use File | Settings | File Templates.
 */
public class Divide_hard {
    public int divide(int d1, int d2) {
        assert d2 != 0;
        int sign = d1 < 0 && d2 > 0 || d1 > 0 && d2 < 0 ? -1 : 1;
        long l1 = Math.abs(1l * d1);
        long l2 = Math.abs(1l * d2);

        long bit  = 1;
        long ret  = 0;

        while (l2 < l1) {
            l2 = l2 << 1;
            bit = bit << 1;
        }

        while (bit != 0) {
            if (l1 >= l2) {
                l1 -= l2;
                ret += bit;
            }
            l2 = l2 >> 1;
            bit = bit >> 1;
        }

        return (int)(ret * sign);
    }
}
