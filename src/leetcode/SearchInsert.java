package leetcode;

/**
 * Created with IntelliJ IDEA.
 * User: shenchen
 * Date: 12-11-7
 * Time: PM9:55
 * To change this template use File | Settings | File Templates.
 */
public class SearchInsert {
    public int searchInsert(int[] A, int target) {
        if (A.length == 0)
            return 0;
        int start = 0;
        int end   = A.length - 1;

        if (A[start] >= target)
            return 0;

        if (A[end] == target)
            return end;

        if (A[end] < target)
            return end + 1;

        while (start < end - 1) {
            int mid = start + (end - start) / 2;
            if (A[mid] == target)
                return mid;
            if (A[mid] > target)
                end = mid;
            else
                start = mid;
        }

        return end;
    }
}
