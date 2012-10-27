package leetcode;

/**
 * Created with IntelliJ IDEA.
 * User: shenchen
 * Date: 12-10-27
 * Time: PM9:18
 * To change this template use File | Settings | File Templates.
 */
public class DecodeWays {
    public int numDecodings(String s) {
        if(s.length() == 0)
            return 0;

        int dp[] = new int[s.length()];
        if(s.charAt(0) == '0')
            return 0;

        dp[0] = 1;

        for(int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            char pre = s.charAt(i-1);
            if(c != '0') {
                dp[i] = dp[i-1];
                int value = (pre - '0') * 10 + c - '0';
                if(value <= 26 && value >= 10) {
                    if(i == 1)
                        dp[i] = dp[i] + 1;
                    else
                        dp[i] = dp[i] + dp[i-2];
                }
            } else if(pre == '2' || pre == '1')  {
                if(i == 1)
                    dp[i] = 1;
                else
                    dp[i] = dp[i - 2];
            } else return 0;

        }

        return dp[s.length() - 1];
    }
}
