package leetcode;

/**
 * Created with IntelliJ IDEA.
 * User: shenchen
 * Date: 12-11-7
 * Time: AM9:20
 * To change this template use File | Settings | File Templates.
 */
public class SearchMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = m > 0 ? matrix[0].length : 0;

        int size = m * n;

        int start = 0;
        int end   = size - 1;

        if (start > end)
            return false;

        int vStart = matrix[start/n][start%n];
        int vEnd   = matrix[end/n][end%n];

        if (vStart == target || vEnd == target)
            return true;

        if (target > vEnd || target < vStart)
            return false;

        while (start < end - 1) {
            int mid = start + (end - start)/2;
            int vMid = matrix[mid/n][mid%n];
            if (vMid == target)
                return true;
            if (vMid < target)
                start = mid;
            else
                end   = mid;
        }

        return false;
    }
}
