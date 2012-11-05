package leetcode;

/**
 * Created with IntelliJ IDEA.
 * User: shenchen
 * Date: 12-11-5
 * Time: PM11:17
 * To change this template use File | Settings | File Templates.
 */
public class RemoveDuplicate {
    public int removeDuplicates(int[] A) {
        int idx = -1;

        for (int i = 0; i < A.length; i ++) {
            int x = A[i];
            if (idx == -1 || A[idx] != x)
                A[++idx] = x;
        }

        return idx + 1;
    }

    public int removeDuplicates2(int[] A) {
        int idx = -1;
        int count = 0;
        for (int x : A) {
            if (idx == -1 || A[idx] != x || count == 1) {
                if (idx == -1 || A[idx] != x)
                    count = 1;
                else
                    count = 2;
                A[++idx] = x;
            }
        }

        return idx + 1;
    }
}
