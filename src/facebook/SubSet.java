package facebook;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: shenchen
 * Date: 12-10-23
 * Time: AM12:39
 * To change this template use File | Settings | File Templates.
 */
public class SubSet{
    public static void solve(int[] arr) {
        BigInteger integer = new BigInteger(arr.length);
        while(true) {
            int count = 0;
            for(int i = 0; i < integer.len; i ++) {
                if(integer.arr[i]) {
                    count ++;
                    System.out.print(arr[i] + " ");
                }
            }
            System.out.println();
            if(count == arr.length)
                break;
            integer.increment();
        }
    }

    static class BigInteger {
        boolean arr[];
        int len;
        public BigInteger(int len) {
            this.len = len;
            this.arr = new boolean[len];
            Arrays.fill(this.arr, false);
        }

        public void increment(){
            if(arr[0] == false)
                arr[0] = true;
            else {
                int i = 0;
                while(arr[i]) {
                    arr[i] = false;
                    i ++;
                }
                arr[i] = true;
            }
        }
    }

    public static void main(String args[]) {
        solve(new int[]{1,2,3,4});
    }
}