package leetcode;

/**
 * Created with IntelliJ IDEA.
 * User: shenchen
 * Date: 12-10-30
 * Time: PM5:30
 * To change this template use File | Settings | File Templates.
 */
public class MultiplyStrings {
    int RADIX = 10000;
    public String multiply(String num1, String num2) {
        int[] rev = new int[(num1.length() + num2.length())/4 + 1];
        for(int i = num1.length() - 1; i >= 0; i -= 4)
            for(int j = num2.length() - 1; j >= 0; j -= 4) {
                int idx = ((num1.length() - 1) - i + (num2.length() - 1) - j)/4;
                int value1 = Integer.parseInt(num1.substring(Math.max(0, i - 3), i + 1));
                int value2 = Integer.parseInt(num2.substring(Math.max(0, j - 3), j + 1));
                int ret    = value1 * value2;
                add(rev, idx, ret);
            }
        StringBuffer sb = new StringBuffer();
        boolean start = false;
        for(int i = rev.length - 1; i >= 0; i --) {
            if(!start && rev[i] == 0)
                continue;
            else if(!start) {
                start = true;
                sb.append(rev[i]);
            } else {
                String s = rev[i] + "";
                for(int j = 0; j + s.length() < 4; j ++)
                    sb.append("0");
                sb.append(s);
            }
        }
        if(sb.length() == 0)
            sb.append("0");
        return sb.toString();
    }

    void add(int[] rev, int idx, int value) {
        while(value != 0) {
            value = value + rev[idx];
            rev[idx] = value%RADIX;
            value = value/RADIX;
            idx ++;
        }
    }
}
