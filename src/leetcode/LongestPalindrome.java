package leetcode;

/**
 * Created with IntelliJ IDEA.
 * User: shenchen
 * Date: 12-10-28
 * Time: PM3:29
 * To change this template use File | Settings | File Templates.
 */
public class LongestPalindrome {
    public String longestPalindrome(String s) {
        String maxStr = "";
        int    maxLen = 0;

        for(int i = 0; i < s.length(); i++) {
            int start = i;
            int end   = i;
            while(start >= 0 && end < s.length()) {
                if(s.charAt(start) == s.charAt(end)) {
                    if(end - start + 1 > maxLen) {
                        maxLen = end - start + 1;
                        maxStr = s.substring(start, end + 1);
                    }

                    start --;
                    end   ++;
                } else
                    break;
            }

            start = i;
            end   = i + 1;
            while(start >= 0 && end < s.length()) {
                if(s.charAt(start) == s.charAt(end)) {
                    if(end - start + 1 > maxLen) {
                        maxLen = end - start + 1;
                        maxStr = s.substring(start, end + 1);
                    }

                    start --;
                    end   ++;
                } else
                    break;
            }
        }
        return maxStr;

    }
}
