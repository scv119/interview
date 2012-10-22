package facebook;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: shenchen
 * Date: 12-10-22
 * Time: AM3:08
 * To change this template use File | Settings | File Templates.
 */
/*

3-sum finding whether there are 3 numbers whos sum is K in an array arr[]

*/

public class Sum3 {
    public static boolean solve(int arr[], int k) {
        if(arr == null || arr.length < 3)
            return false;

        Arrays.sort(arr);
        boolean find = false;

        for(int i = 0; i < arr.length - 2; i ++ ) {
            if(arr[i] > k)
                break;
            int sum = k - arr[i];
            int start = i + 1;
            int end   = arr.length - 1;

            while(start < end) {
                int value = arr[start] + arr[end];
                if(value == sum) {
                    find = true;
                    break;
                } else if (value < sum) {
                    start ++;
                } else {
                    end --;
                }
            }

            if(find)
                break;
        }

        return find;
    }

    public static void main(String args[]) {
        System.out.println(solve(new int[]{3,9,2,-1,7,6,7}, 13 ));
        System.out.println(solve(new int[]{3,9,2,-1,7,6,7}, 17 ));
        System.out.println(solve(new int[]{3,9,2,-1,7,6,7}, 36 ));
    }
}