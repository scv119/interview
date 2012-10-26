package leetcode;

/**
 * Created with IntelliJ IDEA.
 * User: shenchen
 * Date: 12-10-26
 * Time: PM9:26
 * To change this template use File | Settings | File Templates.
 */
public class AddBinary {
    public String addBinary(String a, String b) {
        //TODO care about 0, 0
        if(a.equals("0") && b.equals("0"))
            return "0";

        int[] rev = new int[Math.max(a.length(), b.length()) + 1];
        int carry = 0;
        int idx1 = a.length() - 1;
        int idx2 = b.length() - 1;
        int idx = 0;
        while(carry != 0 || idx1 >= 0 || idx2 >= 0) {
            int value1 = 0;
            int value2 = 0;
            if(idx1 >= 0)
                value1 = a.charAt(idx1) - '0';
            if(idx2 >= 0)
                value2 = b.charAt(idx2) - '0';
            int tmp = value1 + value2 + carry;
            rev[rev.length - idx - 1] = tmp%2;
            carry = tmp/2;

            idx ++;
            idx1 --;
            idx2 --;
        }

        StringBuilder sb = new StringBuilder();
        idx = 0;
        while(rev[idx] == 0)
            idx ++;
        for(;idx < rev.length; idx ++)
            sb.append(rev[idx] + "");

        return sb.toString();
    }
}
