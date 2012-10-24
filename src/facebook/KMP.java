package facebook;

/**
 * Created with IntelliJ IDEA.
 * User: shenchen
 * Date: 12-10-23
 * Time: PM3:07
 * To change this template use File | Settings | File Templates.
 */
public class KMP {
    public static int match(char[] s, char p[]) {
        int[] next = build(p);
        int j = 0;
        for(int i = 0; i < s.length; i ++) {
            while(s[i] != p[j]){
                if(j > 0 && next[j-1] > 0)
                    j = next[j-1];
                else
                    break;
            }
            if(s[i] == p[j])
                j ++;
            else
                j = 0;
            if(j == p.length)
                return i - p.length + 1;
        }
        return -1;
    }

    private static int[] build(char p[]) {
        int[] next = new int[p.length];
        next[0] = 0;
        for(int i = 1; i < p.length; i ++) {
            int k = next[i - 1];
            while(k != 0) {
                if(p[k] == p[i])
                    break;
                k = next[k - 1];
            }

            if(k == 0) {
                if(p[0] == p[i])
                    next[i] = 1;
                else
                    next[i] = 0;
            } else {
                next[i] = k + 1;
            }
        }
        return next;
    }

    private static void showArray(int[] arr) {
        for(int i : arr)
            System.out.print(i + " ");
        System.out.println();

    }

    public static void main(String args[]) {
        System.out.println(match("aacaacaaa".toCharArray(), "aaa".toCharArray()));
    }
}