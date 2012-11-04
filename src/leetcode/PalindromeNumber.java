package leetcode;

/**
 * Created with IntelliJ IDEA.
 * User: shenchen
 * Date: 12-11-4
 * Time: PM10:37
 * To change this template use File | Settings | File Templates.
 */
public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        if (x < 0)
            return false;

        long len = 0;
        long tmp = x;
        long radix = 1;

        while (tmp != 0) {
            tmp = tmp/10;
            len ++;
            radix *= 10;
        }

        long low = 1;
        long high  = len;
        long x1 = x;
        long x2 = x;

        boolean ret = true;
        while (low < high) {
            radix = radix / 10;
            long hv = x1/radix;
            long lv = x2%10;

            if (hv != lv) {
                ret = false;
                break;
            }

            x1 = x1%radix;
            x2 = x2/10;

            low ++;
            high --;
        }

        return ret;
    }
}
