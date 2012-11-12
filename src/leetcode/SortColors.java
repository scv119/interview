package leetcode;

/**
 * Created with IntelliJ IDEA.
 * User: shenchen
 * Date: 12-11-8
 * Time: AM7:49
 * To change this template use File | Settings | File Templates.
 */
public class SortColors {
    public void sortColors(int[] A) {
        int p0 = 0;
        int p1 = A.length - 1;
        int p2 = A.length - 1;

        if (A.length <= 1)
            return ;

        while (p0 <= p1) {
            int v = A[p0];
            if (v == 0)
                p0 ++;
            else if (v == 1) {
                swap(A, p0, p1--);
            } else {
                if (p0 == p1) {
                    swap(A, p0, p2--);
                    p1 --;
                } else {
                    swap(A, p1--, p2);
                    swap(A, p0, p2--);
                }
            }
        }
    }

    void swap (int[] A, int a, int b) {
        int tmp = A[a];
        A[a] = A[b];
        A[b] = tmp;
    }
}
