package facebook;

/**
 * Created with IntelliJ IDEA.
 * User: shenchen
 * Date: 12-10-23
 * Time: PM3:07
 * To change this template use File | Settings | File Templates.
 */
public class KMP {
    public static int strstr(char s[], char p[]) {
        if(p == null || p.length == 0 || s == null || s.length == 0)
            return -1;
        int ret = -1;
        int j = 0;
        int next[] = next(p);
        for(int i = 0 ; i < s.length ; i ++) {
            if(s[i] == p[j])
                j ++;
            else
                while(j != 0) {
                    j = next[j-1];

                }
        }
        return ret;
    }

    private static int[] next(char[] arr ) {
        int[] next = new int[arr.length];
        next[0] = -1;
        for(int i = 1; i < next.length; i++) {
            char c = arr[i];
            int idx = i - 1;
            while(c != arr[next[idx]] && idx != -1)
                idx = next[idx];
            if(idx == 0 && arr[0] == c)
                next[i] = 1;
            else if(idx != 0)
                next[i] = next[idx] + 1;
        }
        return next;
    }

    private static void showArray(int[] arr) {
        for(int i : arr)
            System.out.print(i + " ");
        System.out.println();

    }

    public static void main(String args[]) {
        int[] next = next("abcabcdabcadabcabcdabc".toCharArray());
        showArray(next);
    }
}