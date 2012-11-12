package leetcode;

/**
 * Created with IntelliJ IDEA.
 * User: shenchen
 * Date: 11/12/12
 * Time: 9:48 PM
 * To change this template use File | Settings | File Templates.
 */
public class WildcardMatching {
    Boolean dp[][]; //-1 not match, 1 match, 0 not initialized
    char []s;
    char []p;
    int sLen;
    int pLen;

    public boolean isMatch(String s, String p) {
        dp = new Boolean[s.length() + 1][p.length() + 1];
        this.s = s.toCharArray();
        this.p = p.toCharArray();
        this.sLen = this.s.length;
        this.pLen = this.p.length;

        return isMatch(0, 0);
    }

    private boolean isMatch(int x, int y) {
        if (dp[x][y] != null)
            return dp[x][y];

        boolean ret = false;

        if (x == sLen && y == pLen)
            ret = true;
        else if (y == pLen)
            ret = false;
        else if (p[y] != '*' && p[y] != '?')
            ret = x < sLen && p[y] == s[x] && isMatch(x + 1, y + 1);
        else if (p[y] == '?')
            ret = x < sLen && isMatch(x + 1, y + 1);
        else {
            for (int i = x; i <= sLen; i ++)
                if (isMatch(i, y + 1)) {
                    ret = true;
                    break;
                }
        }

        dp[x][y] = ret;
        return ret;
    }
}
