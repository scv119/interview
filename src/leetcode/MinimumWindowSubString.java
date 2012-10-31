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
        int[] dest    = new int[256];
        int[] count   = new int[256];
        int   num     = 0;
        for(int i = 0; i < T.length(); i ++) {
            int value = T.charAt(i);
            dest[value] ++;
            if(dest[value] == 1)
                num ++;
        }

        Stack stack = new Stack();

        int minLen = Integer.MAX_VALUE; int minS = 0; int minE = 0;
        int start = -1;
        int end   = 0;
        int curNum = 0;

        while(end < S.length()) {
            int v = S.charAt(end);
            if(dest[v] > 0) {
                if(start == -1)
                    start = end;
                count[v] ++;
                if(count[v] == dest[v])
                    curNum ++;
                while(curNum == num) {
                    if(end - start + 1 < minLen) {
                        minLen = end - start + 1;
                        minS = start;
                        minE = end;
                    }
                    int next = start;
                    for(int i = start + 1; i <= end; i ++) {
                        v = S.charAt(i);
                        if(dest[v] > 0) {
                            next = i;
                            break;
                        }
                    }

                    if(next == start)
                        break;
                    v = S.charAt(start);
                    count[v] --;
                    if(count[v] == dest[v] - 1)
                        curNum --;
                    start = next;
                }
            }
            end ++;
        }
        if(minLen == Integer.MAX_VALUE)
            return "";
        return S.substring(minS, minE + 1);
    }
}
