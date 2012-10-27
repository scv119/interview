package leetcode;

/**
 * Created with IntelliJ IDEA.
 * User: shenchen
 * Date: 12-10-27
 * Time: PM9:58
 * To change this template use File | Settings | File Templates.
 */
public class EditDistance {
    public int minDistance(String word1, String word2) {

        int dp[][] = new int[word1.length() + 1][word2.length() + 1];

        for(int i = 0; i <= word1.length(); i ++)
            for(int j = 0; j <= word2.length(); j ++) {
                if(i == 0)
                    dp[i][j] = j;
                else if(j == 0)
                    dp[i][j] = i;
                else {

                    char c1 = word1.charAt(i-1);
                    char c2 = word2.charAt(j-1);

                    if(c1 == c2) {
                        int value = Integer.MAX_VALUE;
                        value = Math.min(dp[i-1][j-1], dp[i-1][j] + 1);
                        value = Math.min(value, dp[i][j-1] + 1);
                        dp[i][j] = value;
                    } else {
                        int value = Math.min(dp[i-1][j-1] + 1, dp[i-1][j] + 1);
                        value = Math.min(value, dp[i][j-1] + 1);
                        dp[i][j] = value;
                    }
                }
            }
        return dp[word1.length()][word2.length()];
    }
}
