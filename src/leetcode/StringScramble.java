package leetcode;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: shenchen
 * Date: 12-11-7
 * Time: PM11:51
 * To change this template use File | Settings | File Templates.
 */
public class StringScramble {
    int sLen;
    int dp[][][];
    String s1;
    String s2;

    public boolean isScramble(String s1, String s2) {
        this.sLen = s1.length();
        this.s1 = s1;
        this.s2 = s2;
        dp = new int[sLen][sLen][sLen + 1];
        for (int i = 0; i < sLen; i ++)
            for (int j = 0; j < sLen; j ++)
                Arrays.fill(dp[i][j], -1);
        return isScramble(0, 0, sLen);
    }

    boolean isScramble(int start1, int start2, int len) {
        if (dp[start1][start2][len] != -1)
            return dp[start1][start2][len] == 1;
        boolean ret = false;

        if (len == 1)
            ret = (s1.charAt(start1) == s2.charAt(start2));
        else {
            for (int len1 = 1; len1 < len; len1 ++) {
                ret |= isScramble(start1, start2, len1)
                        && isScramble(start1 + len1, start2 + len1, len - len1);
                if (ret)
                    break;
                ret |= isScramble(start1, start2 + (len - len1) , len1)
                        && isScramble(start1 + len1, start2, len - len1);
                if (ret)
                    break;
            }
        }

        dp[start1][start2][len] = ret ? 1 : 0;
        return ret;
    }
}
