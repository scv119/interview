import java.math.BigInteger;

/**
 * Created with IntelliJ IDEA.
 * User: shenchen
 * Date: 12-11-25
 * Time: PM3:47
 * To change this template use File | Settings | File Templates.
 */
public class LastNumberOfFactorial {
    public static int calc(int x, int y) {
        BigInteger bi = BigInteger.valueOf(1);
        for (int i = x; i <= y; i ++) {
            bi = bi.multiply(BigInteger.valueOf(i));
        }
        while (bi.mod(BigInteger.valueOf(10)).equals(BigInteger.valueOf(0)))
            bi = bi.divide(BigInteger.valueOf(10));

        return bi.mod(BigInteger.valueOf(10)).intValue();
    }

    public static void main(String args[]) {
        for (int i = 1; i <= 100; i ++) {
            System.out.print(calc(1, i) + " ");
        }

    }

}
