package facebook;

/*
Given an array A of positive integers. Convert it to a sorted array with

minimum cost. The only valid operation are:

1) Decrement with cost = 1

2) Delete an element completely from the array with cost = value of element


using dp to solve this problem
*/


import java.util.Arrays;

public class WeightedSort {
    public static int solve(int arr[]) {
        int[] sorted = arr.clone();
        int len = arr.length;

        Arrays.sort(sorted);

        int dp[][] = new int[2][len + 1];
        int idx = 0;

        for(int i = 0 ; i < len + 1; i ++ ) {
            if(i < len && sorted[i] <= arr[len - 1])
                dp[idx][i] = 0;
            else
                dp[idx][i] = arr[len - 1];
        }

        for(int j = len - 2; j >= 0 ; j -- ) {
            for(int i = 0 ; i < len + 1; i ++ ) {
                if(i < len && sorted[i] <= arr[j])
                    dp[idx^1][i] = arr[j] - sorted[i] + dp[idx][i];
                else
                    dp[idx^1][i] = arr[j] + dp[idx][i];
            }
            idx = idx ^ 1;
        }

        int ret = Integer.MAX_VALUE;

        for(int i = 0; i < len + 1; i ++)
            ret = Math.min(ret, dp[idx][i]);

        return ret;

    }

    public static void main(String args[]) {
        System.out.println(solve(new int[]{1, 2, 3, 4, 5}));
        System.out.println(solve(new int[]{1, 2, 3, 5, 4}));
    }
}