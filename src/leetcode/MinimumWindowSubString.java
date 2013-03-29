package leetcode;

import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * User: shenchen
 * Date: 12-10-30
 * Time: PM4:59
 * To change this template use File | Settings | File Templates.
 */
public class MinimumWindowSubString {
    public String minWindow(String S, String T) {
        int count[] = new int[256];
        int dest[] = new int[256];
        int dsize  = 0;
        for (int i = 0; i < T.length(); i++) {
            char c = T.charAt(i);
            dest[c] = 1;
            dsize ++;
        }

        if (S.equals("") || T.equals(""))
            return "";

        int min = Integer.MAX_VALUE;
        int mStart = 0;
        int mEnd   = 0;

        int start = -1;
        int end   = 0;
        int size  = 0;

        while (end < S.length()) {
            int c = S.charAt(end);
            if (dest[c] == 1) {
                if (start == -1)
                    start = end;
                count[c]++;
                if (count[c] == 1)
                    size ++;

                if (size == dsize) {
                    while (true) {
                        if (size == dsize && end - start + 1 < min) {
                            min = end - start + 1;
                            mStart = start;
                            mEnd   = end;
                        }

                        if (start == end)
                            break;
                        if (dest[S.charAt(start)] == 1 && size < dsize)
                            break;
                        if (dest[S.charAt(start)] == 1) {
                            count[S.charAt(start)] --;
                            if (count[S.charAt(start)] == 0)
                                size --;
                        }
                        start ++;
                    }
                }
            }
            end ++;
        }

        if (min == Integer.MAX_VALUE)
            return "";
        return S.substring(mStart, mEnd + 1);

    }

    public static void main(String args[]) {
        MinimumWindowSubString ms = new MinimumWindowSubString();
        System.out.println(ms.minWindow("aa", "aa"));
    }
}
