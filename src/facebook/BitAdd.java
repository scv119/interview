package facebook;

/**
 * Created with IntelliJ IDEA.
 * User: shenchen
 * Date: 10/24/12
 * Time: 4:57 PM
 * To change this template use File | Settings | File Templates.
 */
public class BitAdd {
    public static int solve(int a, int b) {
        int ret = 0;
        assert(a >= 0 && b >= 0);
        int carry = 0;
        int mask  = 1;
        while(a != 0 || b != 0 || carry != 0) {
            int abit = a & 1;
            int bbit = b & 1;
            if(abit == bbit && abit == carry) {
                if(abit == 1) {
                    carry = 1;
                    ret = ret | mask;
                } else {
                    carry = 0;
                }
            } else if( a == 1 && b == 0 && carry == 0 ||
                    a == 0 && b == 1 && carry == 0 ||
                    a == 0 && b == 0 && carry == 1 ) {
                carry = 0;
                ret = ret | mask;
            } else {
                carry = 1;
            }
            a    = a >> 1;
            b    = b >> 1;
            mask = mask << 1;
        }
        return ret;
    }

    public static void main(String args[]) {
        for(int a = 0 ; a < 10000; a ++)
            for(int b = 0; b < 10000; b ++) {
                assert(solve(a,b) == (a + b));
            }
    }
}