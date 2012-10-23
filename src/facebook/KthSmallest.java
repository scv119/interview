package facebook;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: shenchen
 * Date: 12-10-23
 * Time: PM1:57
 * To change this template use File | Settings | File Templates.
 */
/*
find median/kth smallest from 2 sorted array
*/

public class KthSmallest {

    public static class SolveException extends RuntimeException {
        SolveException(String message) {
            super(message);
        }
    }

    public static int solve(int arr1[], int arr2[], int k) {
        if (arr1 == null || arr2 == null || k > arr1.length + arr2.length)
            throw new SolveException("bad argument");
        return solve(arr1, 0, arr1.length, arr2, 0, arr2.length, k);
    }

    private static int solve(int arr1[], int start1, int len1, int arr2[], int start2, int len2, int k) {
        if (len1 == 0)
            return arr2[start2 + k - 1];
        else if (len2 == 0)
            return arr1[start1 + k - 1];

        if (k == 1)
            return Math.min(arr1[start1], arr2[start2]);
        else if (len1 + len2 < 5) {
            int len = len1 + len2;
            int tmp[] = new int[len];
            int j = 0;
            for(int i = 0; i < len1; i ++)
                tmp[j++] = arr1[start1 + i];
            for(int i = 0; i < len2; i ++)
                tmp[j++] = arr2[start2 + i];
            Arrays.sort(tmp);
            return tmp[k-1];
        }
        else if(len1 == 1) {
            return solve(arr2, start2, len2, arr1[start1], k);
        } else if(len2 == 1) {
            return solve(arr1, start1, len1, arr2[start2], k);
        }


        int pivot1 = 0;
        int pivot2 = 0;

        int mid = (k - 2)/2;
        if(len1 < len2) {
            if(mid < len1)
                pivot1 = mid;
            else
                pivot1 = len1 - 1;
            pivot2 = k - 2 - pivot1;
        } else {
            if(mid < len2)
                pivot2 = mid;
            else
                pivot2 = len2 - 1;
            pivot1 = k - 2 - pivot2;
        }

        int value1 = arr1[start1 + pivot1];
        int value2 = arr2[start2 + pivot2];
        if(value1 == value2)
            return Math.max(value1, value2);
        else if(value1 < value2)
            return solve(arr1, start1 + pivot1, len1 - pivot1 ,arr2, start2, pivot2 + 1 ,k - pivot1 );
        else
            return solve(arr2, start2 + pivot2, len2 - pivot2 ,arr1, start1, pivot1 + 1 ,k - pivot2 );

    }

    private static int solve(int arr1[], int start1, int len1, int value, int k) {
        int value1 = arr1[start1 + k - 2];
        if(value1 >= value)
            return value1;
        else if(start1 + k - 1 >= start1 + len1)
            return value;
        else return Math.min(value, arr1[start1 + k -1]);
    }

    public static void main(String args[]) {

        int[] arr1 = new int[50];
        int[] arr2 = new int[50];
        for(int i = 0; i < 50 ;i ++) {
            arr1[i] = i;
            arr2[i] = 50 + i;
        }
        for(int i = 1; i <= 100; i ++) {
            assert(solve(arr1, arr2, i) == i - 1);
        }

        for(int i = 0; i < 50 ;i ++) {
            arr1[i] = 2*i;
            arr2[i] = 2*i + 1;
        }
        for(int i = 1; i <= 100; i ++) {
            assert(solve(arr1, arr2, i) == i - 1);
        }
    }

}
