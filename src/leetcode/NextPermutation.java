package leetcode;

/**
 * Created with IntelliJ IDEA.
 * User: shenchen
 * Date: 12-11-4
 * Time: PM5:39
 * To change this template use File | Settings | File Templates.
 */
public class NextPermutation {
    public void nextPermutation(int[] num) {
        int first = -1;
        int second = -1;

        for (int i = num.length - 2; i >= 0 ; i --) {
            if (num[i] < num[i+1]) {
                first = i;
                break;
            }
        }

        if (first != -1)  {
            for (int i = num.length - 1; i > first; i --) {
                if (num[i] > num[first]) {
                    second = i;
                    break;
                }
            }

            swap(num, first, second);
        }

        first = first + 1;
        second = num.length - 1;

        while(first <= second) {
            swap(num, first++, second--);
        }

    }

    void swap(int []num, int x, int y) {
        int tmp = num[x];
        num[x] = num[y];
        num[y] = tmp;
    }
}