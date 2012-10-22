package facebook;

/**
 * Created with IntelliJ IDEA.
 * User: shenchen
 * Date: 12-10-22
 * Time: AM2:52
 * To change this template use File | Settings | File Templates.
 */
    /*

2. 3个string a, b, c.判断c是否是a和b的interleave，也就是c中应该有a,b中所有字
符，并且c中字符顺序和a,b中一样。

a = "ef"  b = "gh"  c = "egfh"  return true

a = "ef"  b = "gh"  c = "ehgf"  return false

*/

    public class Interleave {


        public static boolean solve(String a, String b, String c) {
            if(LCS(a,c) == a.length() && LCS(b,c) == b.length())
                return true;
            return false;
        }

        //using dp
        static int LCS(String s1, String s2) {
            if(s1 == null || s2 == null || s1.length() == 0 || s2.length() == 0)
                return 0;

            int dp[][] = new int[s1.length()][s2.length()];

            for(int idx1 = 0; idx1 < s1.length(); idx1 ++)
                for(int idx2 = 0; idx2 < s2.length(); idx2 ++) {
                    char c1 = s1.charAt(idx1);
                    char c2 = s2.charAt(idx2);

                    if (c1 == c2) {
                        if(idx1 == 0 || idx2 == 0) {
                            dp[idx1][idx2] = 1;
                        } else {
                            dp[idx1][idx2] = dp[idx1 - 1][idx2 - 1] + 1;
                        }
                    } else {
                        if (idx1 == 0 && idx2 == 0) {
                            dp[0][0] = 0;
                        } else if (idx1 == 0 ) {
                            dp[idx1][idx2] = dp[idx1][idx2-1];
                        } else if (idx2 == 0 ) {
                            dp[idx1][idx2] = dp[idx1-1][idx2];
                        } else {
                            dp[idx1][idx2] = Math.max(dp[idx1-1][idx2], dp[idx1][idx2-1]);
                        }
                    }
                }
            return dp[s1.length() -1][s2.length()-1];

        }

        public static void main(String args[]) {
            System.out.println(LCS("abcdefg", "abcedfadfefgabcdefabcdefg"));
        }
    }
