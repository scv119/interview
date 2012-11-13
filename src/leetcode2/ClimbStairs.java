package leetcode2;

/**
 * Created with IntelliJ IDEA.
 * User: shenchen
 * Date: 11/13/12
 * Time: 9:08 PM
 * To change this template use File | Settings | File Templates.
 */
public class ClimbStairs {
    public int climbStairs(int n) {
        if (n <= 1)
            return 1;
        int []dp = new int[] {1, 1, 0};
        int idx = 2;
        int ret = 0;
        for (int i = 1; i < n; i ++) {
            ret = dp[idx] = dp[(idx + 1)%3] + dp[(idx + 2)%3];
            idx = (idx + 1)%3;
        }
        return ret;
    }
}
