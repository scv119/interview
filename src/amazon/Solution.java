package amazon;

/**
 * Created with IntelliJ IDEA.
 * User: shenchen
 * Date: 12-11-30
 * Time: AM7:26
 * To change this template use File | Settings | File Templates.
 */
public class Solution {
    public String reverse(String s) {
        if (s == null || s.equals(""))
            return s;

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i ++) {
            sb.append(s.charAt(s.length() - 1 - i));
        }

        return sb.toString();
    }

    public static void main(String args[]) {
        Solution solution = new Solution();
        System.out.println(solution.reverse(null));
        System.out.println(solution.reverse(""));
        System.out.println(solution.reverse("abc"));
        System.out.println(solution.reverse("世界你好"));
    }
}
