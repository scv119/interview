package leetcode;

/**
 * Created with IntelliJ IDEA.
 * User: shenchen
 * Date: 12-11-8
 * Time: AM7:36
 * To change this template use File | Settings | File Templates.
 */
public class IntSqrt {
    public int sqrt(int x) {
        assert(x >= 0);
        long  dest = x;
        long  start = 0;
        long  end   = x;

        if (x <= 1)
            return x;

        while (start < end - 1) {
            long mid = start + (end - start) / 2;
            long v   = mid * mid;

            if (v == dest)
                return (int)mid;
            if (v > dest)
                end = mid;
            else
                start = mid;
        }

        return (int)start;
    }
}
