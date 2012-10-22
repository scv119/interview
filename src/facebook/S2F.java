package facebook;

/**
 * Created with IntelliJ IDEA.
 * User: shenchen
 * Date: 12-10-22
 * Time: AM10:17
 * To change this template use File | Settings | File Templates.
 */
/*
String to float
*/

public class S2F {

    public static double solve(String s) {
        double ret = 0f;
        int eRet = 0;
        int sign = 1;
        int eSign = 1;
        int len = 0;
        int state = 0; //0 stands for integer, 1 stands for decimal, 2 stands for E
        double decimal = 0.1f;
        for(int i = 0; i < s.length(); i ++) {
            char c = s.charAt(i);
            if(c >= '0' && c <='9') {

                if(state == 0) {
                    if(len == 1 && ret == 0)
                        throw new RuntimeException("0 is illegal");
                    ret = ret * 10 + c - '0';
                } else if (state == 1) {
                    ret = ret + (c - '0') * decimal;
                    decimal /= 10;
                } else {
                    if(len == 1 && eRet == 0)
                        throw new RuntimeException("0 is illegal");
                    eRet = eRet * 10 + c - '0';
                }
                len ++ ;
            } else if (c == '-' ) {
                if(state == 0 && len == 0 && sign == 1) {
                    sign = -1;
                } else if(state == 2 && len == 0 && eSign == 1) {
                    eSign = -1;
                } else {
                    throw new RuntimeException("- is illegal");
                }
            } else if (c == '.') {
                if(state == 0 && len > 0) {
                    state = 1;
                    len = 0;
                } else {
                    throw new RuntimeException(". is illegal");
                }
            } else if(c == 'E') {
                if(state == 0 && len > 0 || state == 1 && len > 0) {
                    state = 2;
                    len = 0;
                } else {
                    throw new RuntimeException("E is illegal");
                }
            }
        }

        if(len == 0)
            throw new RuntimeException("... is illegal");

        ret = ret * sign;

        if(eRet > 0) {
            if(eSign == 1)
                ret = ret * Math.pow(10, eRet);
            else
                ret = ret / Math.pow(10, eRet);
        }

        return ret;
    }

    static void showResult(String s) {
        System.out.print(s + ":");
        try {
            System.out.println(solve(s));
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String args[]) {
        showResult("-3.14E-23");
        showResult("-30.001400E-203");
        showResult("--3.14E-23");
        showResult("-3..14E-23");
        showResult("0.14E-23");
        showResult("-32.140E-0");
        showResult("0.14EE-23");
        showResult("0.14E");
        showResult("0.14E-");
        showResult("0.14E--");
        showResult("0.14E3.14");
    }
}