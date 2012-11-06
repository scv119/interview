package leetcode;

/**
 * Created with IntelliJ IDEA.
 * User: shenchen
 * Date: 12-11-6
 * Time: AM9:53
 * To change this template use File | Settings | File Templates.
 */
public class RemoveElement {
    public int removeElement(int[] A, int elem) {
        int idx = 0;
        for (int x : A) {
            if (x != elem)
                A[idx++] = x;
        }
        return idx;
    }
}
