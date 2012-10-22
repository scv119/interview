package facebook;

/*
Given an array A of positive integers. Convert it to a sorted array with

minimum cost. The only valid operation are:

1) Decrement with cost = 1

2) Delete an element completely from the array with cost = value of element


using dp to solve this problem
*/

//TODO
import java.util.Arrays;

public class WeightSort {
    public static int solve(int arr[]) {
        if(arr == null || arr.length == 1)
            return 0;

        int[] sorted = arr.clone();
        Arrays.sort(sorted);

        int len = arr.length;
        int dp[][] = new int[2][len + 1];
        int idx = 0;

        for(int i = 0 ; i <= len ; i ++) {
            if(i < len && sorted[i] <= arr[len - 1])
                dp[idx][i] = arr[len - 1] - sorted[i];
            else
                dp[idx][i] = arr[len - 1];
        }

        for(int j = len - 2; j >= 0; j --) {
            int min = Integer.MAX_VALUE;
            for(int i = len; i >= 0; i --) {
                min = Math.min(min, dp[idx][i]);
                if( i == len || sorted[i] > arr[j])
                    dp[idx^1][i] = min + arr[j];
                else
                    dp[idx^1][i] = min + arr[j] - sorted[i];
            }
            idx = idx ^ 1;
        }

        int ret = Integer.MAX_VALUE;

        for(int i = 0; i <= len; i ++) {
            ret = Math.min(ret, dp[idx][i]);
        }

        return ret;
    }

    public static void main(String args[]) {
        System.out.println(solve(new int[]{6, 5, 6, 2}));
        System.out.println(solve(new int[]{1, 2, 3, 5, 4}));
    }
}