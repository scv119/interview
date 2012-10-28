package leetcode;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: shenchen
 * Date: 12-10-28
 * Time: PM3:15
 * To change this template use File | Settings | File Templates.
 */
public class LetterCombinations {
    private static final String[] map = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public ArrayList<String> letterCombinations(String digits) {
        ArrayList<String> ret = new ArrayList<String>();
        int len = digits.length();
        char[] save = new char[len];
        solve(ret, save, digits, 0, len);
        return ret;

    }

    private void solve(ArrayList<String> ret, char[] save, String s, int idx, int len) {
        if(idx == len) {
            ret.add(new String(save));
            return;
        }

        String ss = map[s.charAt(idx) - '0'];

        for(int i = 0 ; i < ss.length(); i ++) {
            save[idx] = ss.charAt(i);
            solve(ret, save, s, idx + 1, len);
        }
    }
}
