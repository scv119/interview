package leetcode2;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: shenchen
 * Date: 12-11-14
 * Time: PM9:58
 * To change this template use File | Settings | File Templates.
 */
public class GenerateParenthesis {
    public ArrayList<String> generateParenthesis(int n) {
        ArrayList<String> ret = new ArrayList<String>();
        char[] arr = new char[n * 2];
        solve(arr, 0, n, n, ret);
        return ret;
    }

    private void solve(char[] arr, int idx, int left, int right, ArrayList<String> ret) {
        if (idx == arr.length) {
            ret.add(new String(arr));
            return;
        }

        if (left > 0) {
            arr[idx] = '(';
            solve(arr, idx + 1, left - 1, right, ret);
        }

        if (right > left) {
            arr[idx] = ')';
            solve(arr, idx + 1, left, right - 1, ret);
        }

        return;
    }
}
