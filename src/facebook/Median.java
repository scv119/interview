package facebook;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: shenchen
 * Date: 12-10-23
 * Time: PM12:55
 * To change this template use File | Settings | File Templates.
 */
/*
find median/kth smallest from 2 sorted array
*/

public class Median {
    public static int getMedian(int arr1[], int arr2[]) {
        return getMedian(arr1, 0, arr2, 0, arr1.length);
    }

    private static int getMedian(int arr1[], int start1, int arr2[], int start2, int len) {
        if(len <= 2) {
            int tmp[] = new int[len * 2];
            for(int i = 0 ; i < len; i ++) {
                tmp[i] = arr1[i + start1];
                tmp[len + i] = arr2[i + start2];
            }
            Arrays.sort(tmp);
            return (tmp[len-1] + tmp[len])/2;
        }

        int mid1 = 0;
        int mid2 = 0;
        int ret = 0;

        if(len%2 == 1) {
            mid1 = arr1[start1 + len/2];
            mid2 = arr2[start2 + len/2];
        } else {
            mid1 = (arr1[start1 + len/2 - 1] + arr1[start1 + len/2])/2;
            mid2 = (arr2[start2 + len/2 - 1] + arr2[start2 + len/2])/2;
        }

        if(mid1 == mid2) {
            if(len%2 == 1)
                ret = (arr1[start1 + len/2] + arr2[start2 + len/2])/2;
            else
                ret = getMedian(arr1, start1 + len/2 -1, arr2, start2 + len/2 - 1, 2);
        } else if(mid1 < mid2) {
            if(len%2 == 1)
                ret = getMedian(arr1, start1 + len/2, arr2, start2, len/2 + 1);
            else
                ret = getMedian(arr1, start1 + len/2 - 1, arr2, start2, len/2 + 1);
        } else {
            if(len%2 == 1)
                ret = getMedian(arr2, start2 + len/2, arr1, start1, len/2 + 1);
            else
                ret = getMedian(arr2, start2 + len/2 - 1, arr1, start1, len/2 + 1);
        }
        return ret;
    }

    public static void main(String args[]) {
        System.out.println(getMedian(new int[]{1,2,7,8,9}, new int[]{3,4,5,10,11}));
        System.out.println(getMedian(new int[]{1}, new int[]{3}));
        System.out.println(getMedian(new int[]{1,2,4,5,6,7,8,9}, new int[]{5,6,7,8,9,10,11,12}));
    }

}