package leetcode2;

/**
 * Created with IntelliJ IDEA.
 * User: shenchen
 * Date: 12-11-14
 * Time: AM9:40
 * To change this template use File | Settings | File Templates.
 */
public class FirstMissingPositive {
    public int firstMissingPositive(int[] A) {
        if (A.length == 0)
            return 1;

        int start = 0;
        int end   = A.length - 1;

        while (start <= end) {
            if (A[start] > 0)
                start ++;
            else {
                swap(A, start, end);
                end --;
            }
        }

        int len = start;

        if (len == 0)
            return 1;

        for (int i = 0; i < len ; i ++) {
            if (Math.abs(A[i]) <= len)  {
                int idx = Math.abs(A[i]) - 1;
                A[idx] = -1 * Math.abs(A[idx]);
            }
        }
        int ret = -1;
        for (int i = 0; i < len; i ++) {
            if (A[i] > 0) {
                ret = i + 1;
                break;
            }
        }
        if (ret == -1)
            ret = len + 1;
        return ret;
    }

    void swap (int[] A, int x, int y) {
        int tmp = A[x];
        A[x] = A[y];
        A[y] = tmp;
    }
}
