package leetcode;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: shenchen
 * Date: 12-11-11
 * Time: PM4:20
 * To change this template use File | Settings | File Templates.
 */
public class TextJustification {
    public ArrayList<String> fullJustify(String[] words, int L) {
        ArrayList<String> ret = new ArrayList<String>();
        int idx = 0;
        while (idx < words.length) {
            int len = 0;
            int wLen = 0;
            int next = idx;
            for (int j = idx; j < words.length; j ++) {
                if (len == 0 || len + 1 + words[j].length() <= L) {
                    len = len == 0 ? words[next].length() : len + 1 + words[next].length();
                    wLen += words[next].length();
                    next ++;
                } else
                    break;
            }
            StringBuilder sb = new StringBuilder();
            if (next - idx == 1) {
                sb.append(words[idx]);
            } else {
                int space = L - wLen;
                int count = next - idx - 1;
                int slen  = space/count;
                int rem   = space%count;
                int k      = 0;
                sb.append(words[idx++]);

                while (idx < next) {
                    int tmp = slen;
                    if (++k <= rem)
                        tmp = slen + 1;
                    if (next >= words.length )
                        tmp = 1;
                    for (int i = 0; i < tmp; i ++)
                        sb.append(" ");
                    sb.append(words[idx++]);
                }
            }
            while (sb.length() < L)
                sb.append(" ");
            ret.add(sb.toString());
            idx = next;
        }

        return ret;
    }
}
