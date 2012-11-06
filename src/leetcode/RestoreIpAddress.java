package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: shenchen
 * Date: 12-11-6
 * Time: AM10:17
 * To change this template use File | Settings | File Templates.
 */
public class RestoreIpAddress {
    public ArrayList<String> restoreIpAddresses(String s) {
        int ip[] = new int[4];
        ArrayList<String> ret = new ArrayList<String>();
        solve(ip, 0, s, 0, ret);
        return ret;
    }

    private void solve(int[] ip, int ipIdx, String s, int sIdx, List<String> ret) {
        if (ipIdx == 4 && sIdx == s.length()) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 4; i ++) {
                if (i != 0)
                    sb.append(".");
                sb.append(ip[i]);
            }
            ret.add(sb.toString());
            return;
        }

        if (s.length() - sIdx > (4 - ipIdx) * 3)
            return;

        if (4 - ipIdx > s.length() - sIdx)
            return;

        int limit = 3;
        if (s.charAt(sIdx) == '0')
            limit = 1;

        for (int len = 1; len <= limit && len + sIdx <= s.length(); len ++) {
            int value = Integer.parseInt( s.substring(sIdx, len + sIdx));
            if (value > 255)
                break;
            ip[ipIdx] =value;
            solve(ip, ipIdx + 1, s, sIdx + len, ret);
        }

        return;
    }
}
