import java.util.*;

public class KMP {
    public String match(String s, String p) {
        if (s == null || p == null)
            return null;

        if (p.equals(""))
            return s;

        char[] sArr = s.toCharArray();
        char[] pArr = p.toCharArray();
        int[] next = build(pArr);
        System.out.println(Arrays.toString(next));
        int sLen = sArr.length;
        int pLen = pArr.length;
        int sIdx = 0;
        int pIdx = 0;
        int ret = -1;
        
        while (true) {
            if (pIdx == pLen) {
                ret = sIdx - pLen;
                break;
            }
            else if (sIdx == sLen){
                ret = -1;
                break;
            }
            else if (sArr[sIdx] == pArr[pIdx]) {
                sIdx ++;
                pIdx ++;
            } else if (pIdx == 0) {
                sIdx ++;
            } else {
                pIdx = next[pIdx - 1];
            }
        }
        if (ret == -1)
            return null;
        System.out.println(s.substring(ret));
        return s.substring(ret);
    }

    private int[] build(char[] arr) {
        int len = arr.length;
        int dfa[] = new int[len];

        for (int i = 1; i < len; i ++) {
            if (dfa[i - 1] == 0)
                dfa[i] = arr[i] == arr[0] ? 1 : 0;
            else {
                int pre = i - 1;
                while (true) {
                    if (pre == 0 || dfa[pre] == 0) {
                        dfa[i] = arr[i] == arr[0] ? 1 : 0;
                        break;
                    } else if (arr[dfa[pre]] == arr[i]) {
                        dfa[i] = dfa[pre] + 1;
                        break;
                    } else {
                        pre = dfa[pre] - 1;
                    }
                }
                }
            }
        return dfa;
    }

    public static void main(String args[]) {
        KMP kmp = new KMP();
        kmp.match("abcabc", "abc");
        kmp.match("cccacacb", "cacacb");
        kmp.match("aaaddaaaaaaad", "aaaaaa");
    }
}
