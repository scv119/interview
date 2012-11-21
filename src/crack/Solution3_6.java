package crack;

import java.util.Stack;
import java.util.TreeMap;

public class Solution3_6 {
    public Stack<Integer> sort (Stack<Integer> stack) {
        Stack<Integer> ret = new Stack<Integer>();
        while (stack.size() > 0) {
            int value = stack.pop();
            while (ret.size() > 0 && ret.peek() < value) {
                stack.push(ret.pop());
            }
            ret.push(value);
        }
        return ret;
    }

}
