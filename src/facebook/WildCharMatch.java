package facebook;

/**
 * Created with IntelliJ IDEA.
 * User: shenchen
 * Date: 12-10-23
 * Time: PM11:37
 * To change this template use File | Settings | File Templates.
 */
public class WildCharMatch {
    public static boolean match(char[] s, char[] p) {
        return match(s, 0, p, 0);
    }

    private static boolean match(char[] s, int sidx, char[] p, int pidx) {
        int slen = s.length;
        int plen = p.length;
        while(true) {
            if(sidx == slen && pidx == plen)
                return true;
            else if(sidx == slen || pidx == plen)
                return false;
            else if(s[sidx] == p[pidx]) {
                sidx ++;
                pidx ++;
            }

            else if(p[pidx] == '?')
                return match(s, sidx + 1, p, pidx + 1);
            else if(p[pidx] == '*') {
                for(int start = sidx; start < slen; start ++)
                    if(match(s, start, p, pidx + 1))
                        return true;
                return false;
            } else {
                return false;
            }
        }
    }

    public static void main(String args[]) {
        System.out.println(match("".toCharArray(), "".toCharArray()));
        System.out.println(match("abc".toCharArray(), "a?c".toCharArray()));
        System.out.println(match("abba".toCharArray(), "a*a".toCharArray()));
    }
}