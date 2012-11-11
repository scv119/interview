package leetcode;

/**
 * Created with IntelliJ IDEA.
 * User: shenchen
 * Date: 12-11-11
 * Time: PM4:25
 * To change this template use File | Settings | File Templates.
 */
public class UniqueBST {
    public int numTrees(int n) {
        int dp[] = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i ++) {
            int rem = i - 1;
            for (int left = 0; left <= rem; left ++) {
                dp[i] += dp[left] * dp[rem - left];
            }
        }
        return dp[n];
    }
}
