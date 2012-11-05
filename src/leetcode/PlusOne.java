package leetcode;

/**
 * Created with IntelliJ IDEA.
 * User: shenchen
 * Date: 12-11-5
 * Time: AM9:34
 * To change this template use File | Settings | File Templates.
 */
public class PlusOne {
    public int[] plusOne(int[] digits) {
        int carry = 1;
        for (int i = digits.length - 1; i >= 0; i --) {
            int tmp = digits[i] + carry;
            digits[i] = tmp % 10;
            carry     = tmp / 10;
        }

        int[] ret = digits;

        if (carry > 0) {
            ret = new int[digits.length + 1];
            ret[0] = carry;
            for (int i = 0; i < digits.length; i ++) {
                ret[i+1] = digits[i];
            }
        }

        return ret;
    }
}
