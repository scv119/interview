package leetcode;

/**
 * Created with IntelliJ IDEA.
 * User: shenchen
 * Date: 12-11-5
 * Time: AM9:19
 * To change this template use File | Settings | File Templates.
 */
public class PermutationSequence {
    public String getPermutation(int n, int k) {
        int[] arr = new int[n];
        for (int i = 1; i <= n; i++) {
            arr[i-1] = i;
        }

        for (int j = 1; j < k; j++) {
            next(arr);
        }

        StringBuilder sb = new StringBuilder();

        for (int x : arr) {
            sb.append(x);
        }

        return sb.toString();
    }

    private void swap(int[] arr, int x, int y) {
        int tmp = arr[x];
        arr[x] = arr[y];
        arr[y] = tmp;
    }

    private void next(int[] arr) {
        int first = -1;
        int second = -1;

        for (int j = arr.length - 2; j >= 0; j --) {
            if (arr[j] < arr[j+1]) {
                first = j;
                break;
            }
        }

        if (first == -1)
            return;

        for (int j = arr.length - 1; j > first; j --) {
            if (arr[j] > arr[first]) {
                second = j;
                break;
            }
        }

        swap(arr, first, second);

        first = first + 1;
        second = arr.length - 1;

        while (first < second) {
            swap(arr, first ++, second --);
        }
    }
}
