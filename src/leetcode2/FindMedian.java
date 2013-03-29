package leetcode2;

/**
 * Created with IntelliJ IDEA.
 * User: shenchen
 * Date: 12-11-29
 * Time: PM12:02
 * To change this template use File | Settings | File Templates.
 */
public class FindMedian {
    public double findMedianSortedArrays(int A[], int B[]) {
        double ret = 0;
        int len = A.length + B.length;
        ret = find(A, 0, A.length, B, 0, B.length, (len + 1) / 2);
        if (ret % 2 == 0)
            ret = (ret + find(A, 0, A.length, B, 0, B.length, (len + 1) / 2 + 1))/2;
        return ret;
    }

    int find(int A[],  int aStart, int aLen, int B[], int bStart, int bLen, int k) {
        int pA = (int)(1.0d * aLen / (aLen + bLen) * (k - 1));
        int pB = k - 1 - pA;

        int a0 = pA == 0 ? Integer.MIN_VALUE : A[aStart + pA - 1];
        int a1 = pA == aLen ? Integer.MAX_VALUE : A[aStart + pA];
        int b0 = pB == 0 ? Integer.MIN_VALUE : B[bStart + pB - 1];
        int b1 = pB == bLen ? Integer.MAX_VALUE : B[bStart + pB];

        if (a0 <= b1 && b1 <= a1)
            return b1;
        if (b0 <= a1 && a1 <= b1)
            return a1;

        if (a1 < b1)
            return find(A, aStart + pA + 1, aLen - pA - 1, B, bStart, pB, k - pA - 1);
        else
            return find(A, aStart, pA, B, bStart + pB + 1, bLen - pB - 1, k - pB - 1);
    }

    public static void main(String args[]) {
        FindMedian fm = new FindMedian();
        fm.findMedianSortedArrays(new int[]{2}, new int[]{});
    }
}
