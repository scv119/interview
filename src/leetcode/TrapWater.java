package leetcode;

/**
 * Created with IntelliJ IDEA.
 * User: shenchen
 * Date: 12-11-11
 * Time: PM3:32
 * To change this template use File | Settings | File Templates.
 */
public class TrapWater {
    public int trap(int[] A) {
        int start = 0;
        int end   = A.length - 1;

        int h = 0;
        int ret = 0;
        while (start <= end) {
            int cur;
            if (A[start] < A[end]) {
                cur = A[start];
                start ++;
            } else {
                cur = A[end];
                end   --;
            }

            if (cur < h) {
                ret += h - cur;
            }

            h = Math.max(h, cur);
        }

        return ret;

    }
}
