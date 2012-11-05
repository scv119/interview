package leetcode;

/**
 * Created with IntelliJ IDEA.
 * User: shenchen
 * Date: 12-11-5
 * Time: AM9:46
 * To change this template use File | Settings | File Templates.
 */
public class Power {
    public double pow(double x, int n) {
        if (n == 0)
            return 1;
        boolean rev = false;
        if (n < 0)
            rev = true;
        n = Math.abs(n);

        double ret = 1;
        double c = x;
        while (n != 0) {
            if (n % 2 == 1)
                ret = ret * c;
            n = n / 2;
            c = c * c;
        }

        if (rev)
            ret = 1/ret;
        return ret;
    }
}
