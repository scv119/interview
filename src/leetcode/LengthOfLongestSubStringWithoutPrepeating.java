package leetcode;

/**
 * Created with IntelliJ IDEA.
 * User: shenchen
 * Date: 12-10-28
 * Time: PM4:20
 * To change this template use File | Settings | File Templates.
 */
public class LengthOfLongestSubStringWithoutPrepeating {
    public int lengthOfLongestSubstring(String s) {
        int start = 0;
        int end   = 1;
        int[] map = new int[26];
        int max = 1;
        int len = s.length();
        if(s == null || s.length() == 0)
            return 0;
        map[s.charAt(0) - 'a'] = 1;


        while(end < len) {
            int k = s.charAt(end) - 'a';
            map[k]++;
            while(map[k] > 1) {
                map[s.charAt(start) - 'a'] --;
                start ++;
            }
            int v = end - start + 1;
            max = Math.max(max, v);
            end ++;
        }
        return max;

    }
}
