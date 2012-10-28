package leetcode;

/**
 * Created with IntelliJ IDEA.
 * User: shenchen
 * Date: 12-10-28
 * Time: PM3:22
 * To change this template use File | Settings | File Templates.
 */
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        StringBuffer sb = new StringBuffer();

        if(strs.length == 0)
            return "";

        int max = Integer.MAX_VALUE;
        for(String s : strs)
            max = Math.min(s.length(), max);

        for(int i = 0; i < max; i ++) {
            char c = strs[0].charAt(i);
            boolean valid = true;
            for(int j = 1; j < strs.length; j ++) {
                char tmp = strs[j].charAt(i);
                if(tmp != c) {
                    valid = false;
                    break;
                }
            }

            if(valid)
                sb.append(c);
            else
                break;
        }
        return sb.toString();
    }
}
