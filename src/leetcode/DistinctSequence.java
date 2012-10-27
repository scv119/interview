package leetcode;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: shenchen
 * Date: 12-10-27
 * Time: PM9:32
 * To change this template use File | Settings | File Templates.
 */
public class DistinctSequence {
    public int numDistinct(String S, String T) {
        if(T == null || T.length() == 0 || S == null || S.length() == 0)
            return 0;

        int dp[][] = new int[2][T.length()];
        int idx = 0;

        for(int i = 0; i < S.length(); i ++) {
            Arrays.fill(dp[idx ^ 1], 0);
            char cs = S.charAt(i);
            for(int j = 0; j < T.length(); j ++) {
                char ct = T.charAt(j);
                dp[idx^1][j] = dp[idx][j];
                if(cs == ct) {
                    if(j == 0)
                        dp[idx^1][j] ++;
                    else
                        dp[idx^1][j] += dp[idx][j-1];
                }
            }
            idx = idx ^ 1;
        }
        return dp[idx][T.length()-1];
    }
}
