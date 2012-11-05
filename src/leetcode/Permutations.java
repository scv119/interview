package leetcode;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: shenchen
 * Date: 12-11-5
 * Time: AM9:29
 * To change this template use File | Settings | File Templates.
 */
public class Permutations {
    public ArrayList<ArrayList<Integer>> permute(int[] num) {
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
        Arrays.sort(num);
        while (true) {
            ArrayList<Integer> list = new ArrayList<Integer>();
            for (int x : num)
                list.add(x);
            ret.add(list);

            if (!next(num))
                break;
        }

        return ret;
    }

    private void swap(int[] arr, int x, int y) {
        int tmp = arr[x];
        arr[x] = arr[y];
        arr[y] = tmp;
    }

    private boolean next(int[] arr) {
        int first = -1;
        int second = -1;

        for (int j = arr.length - 2; j >= 0; j --) {
            if (arr[j] < arr[j+1]) {
                first= j;
                break;
            }
        }

        if (first == -1)
            return false;

        for (int i = arr.length - 1; i > first; i --) {
            if (arr[i] > arr[first]) {
                second = i;
                break;
            }
        }

        swap(arr, first, second);

        first = first + 1;
        second = arr.length - 1;

        while (first < second) {
            swap(arr, first ++, second --);
        }

        return true;
    }
}
