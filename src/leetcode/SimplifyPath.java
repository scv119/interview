package leetcode;

import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * User: shenchen
 * Date: 12-11-7
 * Time: PM11:26
 * To change this template use File | Settings | File Templates.
 */
public class SimplifyPath {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<String>();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i <= path.length(); i ++) {
            char c = '/';
            if (i < path.length())
                c = path.charAt(i);
            if (c != '/')
                sb.append(c);
            else if (sb.length() == 0)
                continue;
            else {
                String s = sb.toString();
                sb = new StringBuffer();
                if (s.equals(".")){

                } else if (s.equals("..")) {
                    if (stack.size() > 0)
                        stack.pop();
                } else
                    stack.push(s);

            }
        }

        if (stack.size() == 0)
            return "/";

        sb = new StringBuffer();
        for (int i = 0; i < stack.size(); i ++) {
            sb.append("/").append(stack.get(i));
        }

        return sb.toString();

    }
}
