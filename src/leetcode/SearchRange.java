package leetcode;

/**
 * Created with IntelliJ IDEA.
 * User: shenchen
 * Date: 12-11-7
 * Time: AM9:35
 * To change this template use File | Settings | File Templates.
 */
public class SearchRange {
    public int[] searchRange(int[] A, int target) {
        int ret[] = new int[]{-1, -1};
        int start = 0;
        int end   = A.length - 1;
        if (A.length == 0)
            return ret;
        int idx = -1;
        if (A[start] == target || A[end] == target)
            idx = A[start] == target ? start : end;
        else {
            if (A[start] > target || A[end] < target)
                return  ret;
            while (start < end - 1) {
                int mid = start + (end - start)/2;
                if (A[mid] == target) {
                    idx = mid;
                    break;
                }

                if (A[mid] < target)
                    start = mid;
                else
                    end = mid;
            }

            if (idx == -1)
                return ret;
        }

        start = 0;
        end   = idx;
        if (A[start] == target)
            ret[0] = start;
        else {
            while (start < end - 1) {
                int mid = start + (end - start)/2;
                if (A[mid] == target)
                    end = mid;
                else
                    start = mid;
            }
            ret[0] = end;
        }

        start = idx;
        end   = A.length - 1;
        if (A[end] == target)
            ret[1] = end;
        else {
            while (start < end - 1) {
                int mid = start + (end - start)/2;
                if (A[mid] == target)
                    start = mid;
                else
                    end = mid;
            }
            ret[1] = start;
        }

        return ret;
    }
}
