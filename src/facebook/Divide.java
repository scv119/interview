package facebook;

/**
 * Created with IntelliJ IDEA.
 * User: shenchen
 * Date: 12-10-22
 * Time: PM6:07
 * To change this template use File | Settings | File Templates.
 */
public class Divide {

    public static int divide(int dividend, int divisor) {
        long a = dividend;
        long b = divisor;
        long sign = 1;

        if( b == 0 )
            throw new RuntimeException("divide by zero");

        if ( a > 0 && b < 0 || a < 0 && b > 0) {
            sign = -1;

        }

        a = a >= 0 ? a : -a;
        b = b >  0 ? b : -b;

        long ret = 0;
        long base = 1;

        long tmp = b;

        while ( a > tmp ) {
            tmp = tmp << 1;
            base = base << 1;
        }

        while(base >= 1) {
            if( a >= tmp) {
                a = a - tmp;
                ret = ret + base;
            } else {
                base = base >> 1;
                tmp = tmp >> 1;
            }
        }

        if(sign == -1)
            ret = -ret;
        return (int)(ret);

    }

    public static void main(String args[]) {
//        for(int i = 1; i < 10000; i ++)
//        {
//            int x = (int)(Math.random() * (Integer.MAX_VALUE - 1) + 1 );
//            int y = (int)(Math.random() * (Integer.MAX_VALUE - 1) + 1 );
//
//            if(divide(x, y)  != (x/y)) {
//                System.out.println(x + " " + y);
//            }
//        }
        divide(-1, -1);
    }

}