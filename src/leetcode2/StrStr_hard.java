package leetcode2;

/**
 * Created with IntelliJ IDEA.
 * User: shenchen
 * Date: 12-11-14
 * Time: PM11:05
 * To change this template use File | Settings | File Templates.
 */
public class StrStr_hard {
    public String strStr(String s, String p) {
        if (s == null || p == null || s.length() < p.length())
            return null;

        if (p.equals(""))
            return s;

        int ret = -1;

        for (int i = 0; i < s.length() - (p.length() - 1); i ++) {
            for (int j = 0; j <= p.length() && i + j <= s.length(); j ++) {
                if (j == p.length()) {
                    ret = i;
                    break;
                }

                if (i + j == s.length())
                    break;

                if (s.charAt(i + j) != p.charAt(j))
                    break;
            }

            if (ret != -1)
                break;
        }

        if (ret == -1)
            return null;
        return s.substring(ret);
    }
}
