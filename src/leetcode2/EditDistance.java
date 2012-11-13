package leetcode2;

/**
 * Created with IntelliJ IDEA.
 * User: shenchen
 * Date: 12-11-14
 * Time: AM12:53
 * To change this template use File | Settings | File Templates.
 */
public class EditDistance {
    public int minDistance(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        int dp[][] = new int[len1 + 1][len2 + 1];

        dp[0][0] = 0;

        for (int i = 1; i <= len1; i ++)
            dp[i][0] = i;

        for (int i = 1; i <= len2; i ++)
            dp[0][i] = i;

        for (int i = 1; i <= len1; i ++)
            for (int j = 1; j <= len2; j ++) {
                char c1 = word1.charAt(i - 1);
                char c2 = word2.charAt(j - 1);
                if (c1 == c2)
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i][j - 1], dp[i - 1][j]) + 1);
                else
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i][j - 1], dp[i - 1][j])) + 1;
            }

        return dp[len1][len2];
    }
}
