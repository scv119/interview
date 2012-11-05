package leetcode;

/**
 * Created with IntelliJ IDEA.
 * User: shenchen
 * Date: 12-11-5
 * Time: PM11:01
 * To change this template use File | Settings | File Templates.
 */
public class RegularExpressionMatch {
    public boolean isMatch(String s, String p) {
        return isMatch(s.toCharArray(), 0, p.toCharArray(), 0);
    }

    private boolean isMatch(char[] s, int sIdx, char[] p, int pIdx) {
        int sLen = s.length;
        int pLen = p.length;
        if (pIdx == pLen)
            return sIdx == sLen;

        if (pIdx == pLen - 1 || p[pIdx+1] != '*')
            return (sIdx != sLen && (s[sIdx] == p[pIdx] || p[pIdx] == '.')) && isMatch(s, sIdx + 1, p, pIdx + 1);

        if (isMatch(s, sIdx, p, pIdx + 2))
            return true;

        return sIdx < sLen && (s[sIdx] == p[pIdx] || p[pIdx] == '.') && isMatch(s, sIdx +1, p, pIdx);
    }
}
