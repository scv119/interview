package leetcode;

/**
 * Created with IntelliJ IDEA.
 * User: shenchen
 * Date: 12-10-29
 * Time: PM4:04
 * To change this template use File | Settings | File Templates.
 */
public class MergeSortedArray {
    public void merge(int A[], int m, int B[], int n) {
        int a1 = m - 1;
        int b1 = n - 1;
        if(n == 0)
            return;
        for(int i = n + m - 1; i >= 0 ; i --) {
            if(a1 >= 0 && b1 >= 0) {
                if(A[a1] >= B[b1]) {
                    A[i] = A[a1];
                    a1 --;
                } else {
                    A[i] = B[b1];
                    b1 --;
                }
            } else if(a1 >= 0) {
                A[i] = A[a1];
                a1 --;
            } else {
                A[i] = B[b1];
                b1 --;
            }
        }
        return;
    }
}
