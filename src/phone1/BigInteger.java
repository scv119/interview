package phone1;

/**
 * Created with IntelliJ IDEA.
 * User: shenchen
 * Date: 12-10-27
 * Time: PM3:09
 * To change this template use File | Settings | File Templates.
 */
public class BigInteger {
    public String add_number(String num1, String num2) {
        int[] arr1 = new int[num1.length()];
        int[] arr2 = new int[num2.length()];
        int[] rev  = new int[Math.max(num1.length(), num2.length()) + 1];
        //reverse them first
        for(int i = 0 ; i < arr1.length; i ++) {
            arr1[i] = num1.charAt(arr1.length - 1 - i) - '0';
        }

        for(int i = 0 ; i < arr2.length; i ++) {
            arr2[i] = num2.charAt(arr2.length - 1 - i) - '0';
        }

        int carry = 0;
        int idx   = 0;
        while(carry != 0 || idx < arr1.length || idx < arr2.length ) {
            int v1 = 0;
            int v2 = 0;

            if(idx < arr1.length)
                v1 = arr1[idx];

            if(idx < arr2.length)
                v2 = arr2[idx];

            int tmp = v1 + v2 + carry;
            rev[idx] = tmp%2;
            carry = tmp/2;

            idx ++;
        }

        int zeroLen = 0;
        for(int i = rev.length - 1; i >= 0 ; i --) {
            if(rev[i] != 0)
                break;
            else
                zeroLen ++;
        }

        StringBuffer ret = new StringBuffer();

        for(int i = rev.length - 1 - zeroLen; i >= 0 ; i--) {
            ret.append(rev[i] + "");
        }


        return ret.toString();
    }

    public static void main(String args[]) {
        BigInteger bi = new BigInteger();
        System.out.println(bi.add_number("1110", "10"));
    }
}