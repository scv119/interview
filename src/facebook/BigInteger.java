package facebook;

/**
 * Created with IntelliJ IDEA.
 * User: shenchen
 * Date: 12-10-23
 * Time: PM5:29
 * To change this template use File | Settings | File Templates.
 */
public class BigInteger {
    final char[] arr;
    public BigInteger(String s) {
        arr = s.toCharArray();
    }

    public BigInteger(char[] source, int len) {
        arr = new char[len];
        int j = source.length - 1;
        for(int i = len - 1; i >= 0; i --) {
            arr[i] = source[j--];
        }
    }

    @Override
    public String toString() {
        return new String(arr);
    }

    public static BigInteger add(BigInteger b1, BigInteger b2) {
        char[] arr1 = b1.arr;
        char[] arr2 = b2.arr;
        char[] dest = new char[Math.max(arr1.length, arr2.length) + 1];
        int    pos  = dest.length - 1;

        int remain = 0;
        int idx1 = arr1.length - 1;
        int idx2 = arr2.length - 1;

        while(idx1 >= 0 || idx2 >= 0) {
            int tmp = 0;
            if(idx1 >= 0 && idx2 >=0)
                tmp = arr1[idx1] - '0' + arr2[idx2] - '0' + remain;
            else if(idx1 >=0)
                tmp = arr1[idx1] - '0' + remain;
            else
                tmp = arr2[idx2] - '0' + remain;
            remain = tmp/10;
            dest[pos --] = (char)(tmp%10 + '0');
            idx1 --;
            idx2 --;
        }

        if(remain > 0)
            dest[pos --] = (char)(remain + '0');

        int len = dest.length - pos - 1;           //tricky part 1
        return new BigInteger(dest, len);
    }

    public static void main(String args[]) {
        for(int i = 0 ; i < 10000; i ++) {
            long a = (long)(Math.random() * Long.MAX_VALUE / 3);
            long b = (long)(Math.random() * Long.MAX_VALUE / 3);
            if((a + b) != Long.parseLong(add( new BigInteger(a + ""), new BigInteger(b + "") ).toString()))
                System.out.println(a + " "+ b);
        }
    }

}