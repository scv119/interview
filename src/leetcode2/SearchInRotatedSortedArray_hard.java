package leetcode2;

/**
 * Created with IntelliJ IDEA.
 * User: shenchen
 * Date: 11/21/12
 * Time: 6:01 PM
 * To change this template use File | Settings | File Templates.
 */
public class SearchInRotatedSortedArray_hard {
    public boolean search(int[] A, int target) {
        int idx = findMax(A, 0, A.length - 1);

        for (int i = 0; i <= A.length; i ++) {
            int next = (idx + 1)%A.length;
            if (A[next] != A[idx])
                break;
            idx = next;
        }

        return binarySearch(A, target, idx + 1);
    }

    int findMax(int[] A, int start, int end) {
        if (start >= end - 1)
            return A[start] > A[end] ? start : end;
        if (A[start] < A[end])
            return end;
        int mid = (start + end)/2;
        if (A[mid] > A[start])
            return findMax(A, mid, end);
        if (A[mid] < A[end])
            return findMax(A, start, mid - 1);
        int idx0 = findMax(A, start, mid);
        int idx1 = findMax(A, mid + 1, end);

        return A[idx0] > A[idx1] ? idx0 : idx1;
    }

    boolean binarySearch(int A[], int target, int offset) {
        int len   = A.length;
        int start = 0;
        int end   = A.length - 1;
        int vs    = A[(start + offset)%len];
        int ve    = A[(end   + offset)%len];

        if (vs == target || ve == target)
            return true;
        if (target < vs || target > ve)
            return false;

        while (start < end - 1) {
            int mid = (start + end)/2;
            int vm  = A[(mid + offset)%len];
            if (vm == target)
                return true;
            if (vm > target)
                end = mid;
            else
                start = mid;
        }

        return false;
    }
}
