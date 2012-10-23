package facebook;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: shenchen
 * Date: 12-10-23
 * Time: PM5:16
 * To change this template use File | Settings | File Templates.
 */
public class Permuatation {
    public static void all(char[] arr) {
        Arrays.sort(arr);
        all(arr, 0);
    }

    private static void all(char[] arr, int idx) {
        if(idx == arr.length - 1)
            System.out.println(new String(arr));

        char pre = '\0';
        for(int i = idx; i < arr.length; i ++) {  // from idx! thats means not permute any thing
            if(arr[i] == pre)
                continue;
            else
                pre = arr[i];
            swap(arr, idx, i);
            all(arr, idx + 1);
            swap(arr, idx, i);
        }
    }

    private static void swap(char[] arr, int idx1, int idx2) {
        char tmp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = tmp;
    }

    public static void main(String args[]) {
        all("Hll".toCharArray());
    }
}