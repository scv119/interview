package leetcode;

/**
 * Created with IntelliJ IDEA.
 * User: shenchen
 * Date: 12-10-28
 * Time: PM2:07
 * To change this template use File | Settings | File Templates.
 */
public class IsInterLeave {
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length() == 0)
            return s2.equals(s3);
        if(s2.length() == 0)
            return s3.equals(s1);
        if(s1.length() + s2.length() != s3.length())
            return false;

        int len1 = s1.length();
        int len2 = s2.length();
        int len3 = s3.length();

        int dp[][] = new int[len1+1][len2+1];

        dp[0][0] = 1;

        for(int i = 1; i <= len3; i ++) {
            char c = s3.charAt(i-1);
            for(int j = 0; j <= i; j ++) {
                int k = i - j;
                if(j > len1 || k > len2)
                    continue;
                if(j != 0 && dp[j-1][k] == 1 && s1.charAt(j-1) == c)
                    dp[j][k] = 1;
                if(k != 0 && dp[j][k-1] == 1 && s2.charAt(k-1) == c)
                    dp[j][k] = 1;
            }
        }

        return dp[len1][len2] == 1;
    }
}
