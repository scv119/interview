package leetcode;

/**
 * Created with IntelliJ IDEA.
 * User: shenchen
 * Date: 12-11-7
 * Time: AM10:20
 * To change this template use File | Settings | File Templates.
 */
public class SearchInRotateList2 {
    public boolean search(int[] A, int target) {
        if (A.length == 0)
            return false;

        int max = findMax(A, 0, A.length - 1);

        int maxValue = A[max];

        for (int i = 0; i < A.length; i ++) {
            if (A[(max + 1) % A.length] == maxValue)
                max ++;
            else
                break;
        }

        return binarySearch(A, max + 1, target);

    }

    int findMax(int []A, int start, int end) {

        if (A[start] < A[end])
            return end;

        if (start == end || start == end - 1)
            return start;
        int mid = start + (end - start)/2;
        if (A[mid] > A[end])
            return findMax(A, mid, end - 1);
        else if (A[mid] < A[start])
            return findMax(A, start, mid - 1);
        int ret1 = findMax(A, start, mid - 1);
        int ret2 = findMax(A, mid,  end);

        return A[ret1] > A[ret2] ? ret1 : ret2;
    }

    boolean binarySearch(int[] A, int offset, int target) {
        int start = 0;
        int end   = A.length - 1;
        int len   = A.length;

        int vStart = A[(start + offset)%len];
        int vEnd   = A[(end   + offset)%len];

        if (vStart == target || vEnd == target)
            return true;

        if (vStart > target || vEnd < target)
            return false;

        while (start < end - 1) {
            int mid = start + (end - start) / 2;
            int vMid = A[(mid + offset) % len];

            if (vMid == target)
                return true;

            if (vMid < target)
                start = mid;
            else
                end = mid;
        }

        return false;
    }

    public static void main(String args[]) {
        SearchInRotateList2 sir = new SearchInRotateList2();
        System.out.println(sir.search(new int[]{1,2,3,3,3,3,1}, 1));
    }
}
