package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: shenchen
 * Date: 12-10-27
 * Time: PM10:51
 * To change this template use File | Settings | File Templates.
 */
public class GenerateParentheses {
    public class Solution {
        public ArrayList<String> generateParenthesis(int n) {
            char[] arr = new char[n *2];
            ArrayList<String> result = new ArrayList<String>();
            if(n == 0)
                return result;
            solve(result, arr, 0, n, n);
            return result;
        }

        private void solve(List<String> result, char[] arr, int idx, int lleft, int rleft) {
            if(lleft == 0 && rleft == 0) {
                result.add(new String(arr));
                return;
            }

            if(lleft > 0) {
                arr[idx] = '(';
                solve(result, arr, idx + 1, lleft -1, rleft);
            }

            if(rleft > 0 && rleft > lleft) {
                arr[idx] = ')';
                solve(result, arr, idx + 1, lleft, rleft -1);
            }

        }
    }
}
