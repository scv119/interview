package leetcode;

/**
 * Created with IntelliJ IDEA.
 * User: shenchen
 * Date: 12-10-27
 * Time: PM9:42
 * To change this template use File | Settings | File Templates.
 */
public class Divide {
    public int divide(int dividend, int divisor) {
        long a = dividend;
        long b = divisor;

        boolean positive = true;

        if(b == 0)
            throw new RuntimeException();

        if(a < 0 && b > 0 || a > 0 && b < 0)
            positive = false;

        long ret = 0;

        a = a < 0 ? -a : a;
        b = b < 0 ? -b : b;

        long base = 1;

        while(b < a) {
            b = b << 1;
            base = base << 1;
        }

        while(base >= 1) {
            if(a >= b) {
                a = a - b;
                ret += base;
            } else {
                b = b >> 1;
                base = base >> 1;
            }
        }


        if (!positive)
            ret = -ret;

        return (int)ret;
    }
}
