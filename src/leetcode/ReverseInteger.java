package leetcode;

/**
 * Created with IntelliJ IDEA.
 * User: shenchen
 * Date: 12-11-6
 * Time: AM10:24
 * To change this template use File | Settings | File Templates.
 */
public class ReverseInteger {
    public int reverse(int x) {
        int sign = 1;
        if (x < 0)
            sign = -1;
        x = Math.abs(x);
        int ret = 0;

        while (x != 0) {
            int tmp = x % 10;
            x = x/10;
            ret = ret * 10 + tmp;
        }

        return ret * sign;
    }
}
