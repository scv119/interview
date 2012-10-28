package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: shenchen
 * Date: 12-10-28
 * Time: PM5:33
 * To change this template use File | Settings | File Templates.
 */
public class LongestValidParentheses {
    public int longestValidParentheses(String s) {
        int curLeft = 0;
        int now     = 0;
        int arr[] = new int[s.length()];
        List<Integer> stack = new ArrayList<Integer>();
        Arrays.fill(arr, -1);
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == '(') {
                stack.add(i);
            } else {
                if(stack.size() > 0) {
                    int pre = stack.remove(stack.size() - 1);
                    arr[pre] = i;
                } else {
                    now = 0;
                    stack.clear();
                }
            }
        }

        int max = 0;
        int start = 0;
        while(start < arr.length) {
            if(arr[start] < 0) {
                start ++; continue;
            }
            int end = arr[start];
            while(end + 1 < arr.length && arr[end + 1] >= 0) {
                end = arr[end + 1];
            }
            int len = end - start + 1;
            max = Math.max(max, len);
            start = end + 1;
        }

        return max;
    }
}
