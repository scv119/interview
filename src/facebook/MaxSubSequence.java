package facebook;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: shenchen
 * Date: 12-10-26
 * Time: AM7:13
 * To change this template use File | Settings | File Templates.
 */
public class MaxSubSequence {
    public int solve(char[] s, char[] p) {
        int plen = p.length;
        int dp[][] = new int[2][plen + 1];
        int idx = 0;

        for(int i = 0 ; i < s.length; i ++) {
            Arrays.fill(dp[idx ^ 1], 0);
            char c = s[i];
            for(int j = 0 ; j < plen; j ++) {
                if(c == p[j]) {
                    if(j == 0)
                        dp[idx^1][j] = dp[idx][j] + 1;
                    else
                        dp[idx^1][j] = dp[idx][j] + dp[idx][j- 1];
                } else
                    dp[idx^1][j] = dp[idx][j];

            }
            idx = idx ^ 1;
        }

        return dp[idx][plen - 1];
    }
}