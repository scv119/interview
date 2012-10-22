package facebook;

/**
 * Created with IntelliJ IDEA.
 * User: shenchen
 * Date: 12-10-23
 * Time: AM1:14
 * To change this template use File | Settings | File Templates.
 */
public class Math1 {
    public static double log2(double value) {
        if(value == 1f) {
            return 0f;
        }
        int sign = 1;
        if(value < 1f) {
            value = 1f / value;
            sign = -1;
        }

        double ret;

        double start = 1;
        double v = 2;

        while(v < value) {
            start ++;
            v = v * 2;
        }

        ret = start - 1;
        value = value  *  2 / v;
        start = 1.0f;
        v = 2f;

        while(true) {
            v = Math.sqrt(v);
            start = start / 2;
            if(v <= value) {
                value = value / v;
                ret += start;
            }
            if(start < 0.000001f)
                break;
        }


        return ret * sign;
    }

    static double log22(double value) {
        return Math.log(value)/Math.log(2);
    }

    public static void main(String args[]) {
       System.out.println(log2(0.3f) + " " + log22(0.3f));
    }
}