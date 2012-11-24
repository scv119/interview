package leetcode2;

import java.util.TreeMap;

/**
 * Created with IntelliJ IDEA.
 * User: shenchen
 * Date: 12-11-14
 * Time: PM11:05
 * To change this template use File | Settings | File Templates.
 */
public class StrStr_hard {
    public String strStr(String s, String p) {
        if (s == null || p == null)
            return null;

        if (p.equals(""))
            return s;

        for (int i = 0; i < s.length() - (p.length() - 1); i ++) {
            for (int j = 0; j <= p.length(); j ++) {
                if (j == p.length())
                    return s.substring(i);
                if (s.charAt(i + j) != p.charAt(j))
                    break;
            }
        }

        return null;
    }
}
