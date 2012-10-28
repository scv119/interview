package leetcode;

/**
 * Created with IntelliJ IDEA.
 * User: shenchen
 * Date: 12-10-28
 * Time: PM6:11
 * To change this template use File | Settings | File Templates.
 */
public class MaxSubArray {
    public int maxSubArray(int[] A) {
        int max   = Integer.MIN_VALUE;
        int now   = 0;
        int len   = A.length;

        for(int i = 0; i < len; i ++) {
            now = now + A[i];
            max = Math.max(max, now);
            if(now < 0) {
                now = 0;
            }
        }
        return max;

    }
}
