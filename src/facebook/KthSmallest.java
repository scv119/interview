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

    public double findMedianSortedArrays(int A[], int B[]) {
        int lenA = A.length;
        int lenB = B.length;
        int len  = (lenA + lenB);
        double ret = 0;
        ret = findK(A, 0, lenA, B, 0, lenB, (len + 1) / 2);
        if (len%2 == 0)
            ret = (ret + findK(A, 0, lenA, B, 0, lenB, (len + 1) / 2 + 1)) / 2;
        return ret;
    }

    int findK(int A[], int startA, int lenA, int B[], int startB, int lenB, int k) {
        int p1 = (int)(1.0f * lenA / (lenA + lenB) * (k - 1));
        int p2 = k - 1 - p1;

        int a1 = p1 == 0 ? Integer.MIN_VALUE : A[startA + p1 - 1];
        int a2 = p1 == lenA ? Integer.MAX_VALUE : A[startA + p1];

        int b1 = p2 == 0 ? Integer.MIN_VALUE : B[startB + p2 - 1];
        int b2 = p2 == lenB ? Integer.MAX_VALUE : B[startB + p2];

        if (a1 <= b2 && b2 <= a2)
            return b2;
        if (b1 <= a2 && a2 <= b2)
            return a2;

        if (a2 < b2)
            return findK(A, startA + p1 + 1, lenA - p1 - 1, B, startB, p2, k - p1 - 1);
        else
            return findK(A, startA, p1, B, startB + p2 + 1, lenB - p2 - 1, k - p2 - 1);
    }

}
