public class KMP {
    public String match(String s, String p) {
        if (p == null || s == null)
            return null;
        if (p.equals(""))
            return s;
        int []next = buildNext(p);
        int ret = -1;
        int j  = 0;
        for (int i = 0; i < s.length(); i ++) {
            if (j == p.length()) {
                ret = i - p.length();
                break;
            }
            if (s.charAt(i) == p.charAt(j))
                j ++;
            else {
                int pre = j - 1;
                while (true) {
                    if (pre == -1 || next[pre] == 0) {
                        j = 0;
                        i --;
                        break;
                    }
                    if (p.charAt(next[pre]) == s.charAt(i)) {
                        j = next[pre] + 1;            
                        break;
                    } else {
                        pre = next[pre] - 1;
                    }
                }
            }
        }

        if (ret == -1)
            return null;
        return s.substring(ret);
    }

    int[] buildNext(String p) {
        int len = p.length();
        int[] next = new int[len];
        for (int i = 0; i < len; i ++) {
            if (i == 0)
                next[i] = 0;
            else {
                int pre = i - 1;
                while (next[pre] != 0) {
                    if (p.charAt(next[pre]) == p.charAt(i))
                        break;
                    pre = next[pre] - 1;
                }
                if (next[pre] == 0)
                    next[i] = 0;
                else
                    next[i] = next[pre] + 1; 
            }
        }
        return next;
    }

    public static void main(String args[]) {
        KMP kmp = new KMP();
        System.out.println(kmp.match("cbcbccbcbaa", "cbccbcb"));
    }
}
