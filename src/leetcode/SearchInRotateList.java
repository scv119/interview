package leetcode;

/**
 * Created with IntelliJ IDEA.
 * User: shenchen
 * Date: 12-11-7
 * Time: AM10:20
 * To change this template use File | Settings | File Templates.
 */
public class SearchInRotateList {
        public int search(int[] A, int target) {
            int max = findMaxIdx(A);
            if (max == -1)
                return -1;
            return binarySearch(A, max + 1, target);
        }

        int findMaxIdx(int[] A) {
            int len = A.length;
            if (len == 0)
                return -1;
            int start = 0;
            int end   = len - 1;
            if (A[start] <= A[end])
                return end;
            while (start < end - 1) {
                int mid = start + (end - start) / 2;
                if (A[mid] > A[start])
                    start = mid;
                else
                    end   = mid;
            }
            return start;
        }

        int binarySearch(int[] A, int offset, int target) {
            int len = A.length;

            if (len == 0)
                return -1;

            int start = 0;
            int end   = len - 1;

            int vStart = A[(start + offset) % len];
            int vEnd   = A[(end   + offset) % len];

            if (vStart == target)
                return (start + offset) % len;

            if (vEnd   == target)
                return (end + offset) % len;

            if (vStart > target || vEnd < target)
                return -1;

            while (start < end - 1) {
                int mid = start + (end - start) / 2;
                int vMid = A[(mid + offset) % len];
                if (vMid == target)
                    return (mid + offset) % len;
                if (vMid < target)
                    start = mid;
                else
                    end = mid;
            }

            return -1;
        }

    public static void main(String args[]) {
        SearchInRotateList sir = new SearchInRotateList();
        System.out.println(sir.search(new int[]{5, 1, 3}, 5));
    }
}
