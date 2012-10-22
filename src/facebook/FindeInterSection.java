package facebook;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: shenchen
 * Date: 12-10-22
 * Time: AM1:50
 * To change this template use File | Settings | File Templates.
 */
//find intersection of two array

public class FindeInterSection {
    //if have duplicate, compress it

    public static int[] findIntersection(int[] arr1, int[] arr2) {
        if(arr1 == null || arr2 == null || arr1.length == 0 || arr2.length == 0)
            return new int[]{};

        int tmpRet[] = new int[Math.min(arr1.length, arr2.length)];

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        int idx1 = 0;
        int idx2 = 0;
        int idx  = 0;

        while(idx1 < arr1.length && idx2 < arr2.length) {
            if(arr1[idx1] == arr2[idx2]) {
                tmpRet[idx++] = arr1[idx1];
                idx1 ++;
                idx2 ++;
            } else if (arr1[idx1] < arr2[idx2] ) {
                idx1 ++;
            } else {
                idx2 ++;
            }
        }

        int ret[] = new int[idx];
        for(int i = 0; i < idx; i ++ ) {
            ret[i] = tmpRet[i];
        }

        return ret;
    }
    static void printArray(int[] arr) {
        for(int x : arr) {
            System.out.print(x + " ");
        }
        System.out.println();
    }

    public static void main(String args[]) {
        int ret[] = null;
        ret = findIntersection(new int[]{1, 3, 5, 2, -1}, new int[]{-2, -7, -9, -4, -10, -5});
        printArray(ret);
    }
}