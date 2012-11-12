package leetcode;

import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * User: shenchen
 * Date: 11/12/12
 * Time: 9:32 PM
 * To change this template use File | Settings | File Templates.
 */
public class IsMatch {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();

        for (int i = 0; i < s.length(); i ++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{')
                stack.push(c);
            else {
                char match = '(';
                if (c == ']')
                    match = '[';
                else if (c == '}')
                    match = '{';
                if (stack.size() == 0 || match != stack.pop())
                    return false;
            }
        }

        return stack.size() == 0;
    }
}
