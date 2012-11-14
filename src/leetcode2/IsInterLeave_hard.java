package leetcode2;

/**
 * Created with IntelliJ IDEA.
 * User: shenchen
 * Date: 12-11-15
 * Time: AM12:03
 * To change this template use File | Settings | File Templates.
 */
public class IsInterLeave_hard {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length())
            return false;
        int dp[][] = new int[s1.length() + 1][s2.length() + 1];
        dp[0][0] = 1;

        for (int i = 0; i < s3.length(); i ++) {
            for (int j = 0; j <= i + 1; j ++) {
                int k = i + 1 - j;
                if (j > s1.length() || k > s2.length())
                    continue;
                if (j != 0 && dp[j - 1][k] == 1 && s1.charAt(j - 1) == s3.charAt(i))
                    dp[j][k] = 1;
                if (k != 0 && dp[j][k - 1] == 1 && s2.charAt(k - 1) == s3.charAt(i))
                    dp[j][k] = 1;
            }
        }

        return dp[s1.length()][s2.length()] == 1;
    }
}
