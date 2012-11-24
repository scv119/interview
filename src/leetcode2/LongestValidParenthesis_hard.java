package leetcode2;

import java.util.Arrays;
import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * User: shenchen
 * Date: 12-11-20
 * Time: PM11:28
 * To change this template use File | Settings | File Templates.
 */
public class LongestValidParenthesis_hard {
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<Integer>();
        int next[] = new int[s.length()];
        Arrays.fill(next, -1);
        for (int i = 0; i < s.length(); i ++) {
            if (s.charAt(i) == '(')
                stack.push(i);
            else if (stack.size() == 0)
                continue;
            else
                next[stack.pop()] = i;
        }

        int max = 0;
        int start = -1;
        int idx = 0;

        while (idx < s.length()) {
            if (next[idx] == -1) {
                idx ++;
                start = -1;
            } else {
                if (start == -1)
                    start = idx;
                max = Math.max(max, next[idx] - start + 1);
                idx = next[idx] + 1;
            }
        }

        return max;
    }
}
