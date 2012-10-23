package facebook;

/**
 * Created with IntelliJ IDEA.
 * User: shenchen
 * Date: 12-10-24
 * Time: AM12:21
 * To change this template use File | Settings | File Templates.
 */
public class SortStringByWord {
        public static void solve(char[] arr) {
            int wordCount = 1;
            for(int i = 0 ; i < arr.length; i ++) {
                if(arr[i] == ' ')
                    wordCount ++;
            }

            if(wordCount == 1)
                return;

            for(int i = wordCount - 1; i >= 1; i --) {
                int start = 0;
                for(int j = 0; j < i; j ++) {
                    int end = wordEnd(arr, start);
                    int nextStart = end + 2;
                    int nextEnd  = wordEnd(arr, nextStart);

                    if(compare(arr, start, end, nextStart, nextEnd) > 0)
                        swapWord(arr, start, nextEnd);

                    start = wordEnd(arr, start) + 2;
                }
            }

        }

        public static int wordEnd(char[] arr, int start) {
            int idx = start + 1;
            for(; idx < arr.length; idx ++)
                if(arr[idx] == ' ')
                    break;
            if(idx < arr.length)
                return idx - 1;
            return arr.length - 1;
        }

        public static void swapWord(char[] arr, int start, int end) {
            reverse(arr, start, end);
            int idx = start + 1;
            while(arr[idx] != ' ')
                idx ++;
            reverse(arr, start, idx - 1);
            reverse(arr, idx +1, end);
        }

        public static int compare(char[] arr, int s1, int e1, int s2, int e2) {
            int ret = 0;
            while(s1 <= e1 && s2 <= e2) {
                if(arr[s1] == arr[s2]) {
                    s1 ++;
                    s2 ++;
                } else {
                    ret = arr[s1] - arr[s2];
                    break;
                }
            }
            if(ret == 0 && s1 <= e1)
                ret = 1;
            else if(ret == 0 && s2 <= e2) {
                ret = -1;
            }

            return ret;
        }

        private static void reverse(char[] arr, int i, int j) {
            while(i < j) {
                char tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
                i ++;
                j --;
            }

        }

    public static void main(String args[]) {
        char[] arr = "i practice algorithm every day".toCharArray();
        solve(arr);
        System.out.println(new String(arr));
    }
}
