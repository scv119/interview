package leetcode2;

/**
 * Created with IntelliJ IDEA.
 * User: shenchen
 * Date: 12-11-20
 * Time: AM12:59
 * To change this template use File | Settings | File Templates.
 */
public class MultiplyStr {
    public String multiply(String num1, String num2) {
        int[] ret = new int[num1.length() + num2.length()];

        for (int i = 0; i < num1.length(); i ++) {
            int carry = 0;
            for (int j = 0; j < num2.length() || carry != 0; j ++) {
                ret[i + j] += carry;
                if (j < num2.length())
                    ret[i + j] += (num1.charAt(num1.length() - 1 - i) - '0') * (num2.charAt(num2.length() - 1 - j) - '0');
                carry = ret[i + j] / 10;
                ret[i + j] = ret[i + j] % 10;
            }
        }

        StringBuilder sb = new StringBuilder();
        boolean start = false;
        for (int i = ret.length - 1; i >=0; i --) {
            if (!start && ret[i] == 0)
                continue;
            start = true;
            sb.append(ret[i]);
        }

        if (sb.length() == 0)
            sb.append(0);
        return sb.toString();
    }
}
