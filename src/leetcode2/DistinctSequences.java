package leetcode2;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: shenchen
 * Date: 12-11-14
 * Time: AM10:08
 * To change this template use File | Settings | File Templates.
 */
public class DistinctSequences {
    public int numDistinct(String S, String T) {
        if (S.length() == 0)
            return 0;
        int dp[][] = new int[2][T.length()];
        int idx = 0;

        for (int i = 0; i < S.length(); i ++) {
            Arrays.fill(dp[idx ^ 1], 0);
            char c = S.charAt(i);
            for (int j = 0; j < T.length(); j ++) {
                dp[idx^1][j] = dp[idx][j];
                if (c == T.charAt(j)) {
                    if (j == 0) {
                        dp[idx^1][j] += 1;
                    } else {
                        dp[idx^1][j] += dp[idx][j - 1];
                    }
                }
            }
            idx = idx ^ 1;
        }
        return dp[idx][T.length() - 1];
    }
}
