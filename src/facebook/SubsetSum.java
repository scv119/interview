package facebook;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: shenchen
 * Date: 12-10-23
 * Time: PM3:49
 * To change this template use File | Settings | File Templates.
 */

//is size == can solve using 2 sum

public class SubsetSum{
    public static void solve(int[] set, int sum, int size) {
        //if value can be negative, no need to sort
        Arrays.sort(set);
        int arr[] = new int[size];
        for(int i = set.length - 1; i >= size - 1; i --) {
            arr[size - 1] = set[i];
            dfs(set, sum - set[i], size - 1, arr, i);
        }
    }

    private static void dfs(int[] set, int sum, int size, int arr[], int upper) {
        if(sum == 0 && size == 0) {
            showResult(arr);
            return;
        }

        if(sum < 0 || size == 0)
            return;

        for(int i = upper - 1; i >= size -1; i --) {
            arr[size - 1] = set[i];
            dfs(set, sum - set[i], size -1, arr, i);
        }
    }

    static void showResult(int arr[]) {
        for(int i : arr)
            System.out.print(i + " ");
        System.out.println();
    }

    public static void main(String args[]) {
        solve(new int[]{1,2,3,4,5,6}, 8, 3);
    }
}