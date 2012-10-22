package facebook;
//find Longest Increase Sequence

import java.util.Arrays;

public class LIS {
    public static int LIS (int[] arr) {
        if(arr == null || arr.length == 0 )
            return 0;

        //using dp time complexity O(n^2)

        int len = arr.length;

        int dp[] = new int[len];

        Arrays.fill(dp, 1);

        for(int i = 1; i < len; i ++ ) {
            int chooseMaxLen = 1;
            int nChooseMaxLen = 1;


            for(int j = 0; j < i ;j ++ ) {
                if(arr[j] < arr[i] && (dp[j] + 1) > chooseMaxLen) {
                    chooseMaxLen = dp[j] + 1;
                }

                if(dp[j]> nChooseMaxLen)
                    nChooseMaxLen = dp[j];
            }

            dp[i] = Math.max(chooseMaxLen, nChooseMaxLen);
        }

        return dp[len -1];
    }

    public static void main(String args[]) {
        System.out.println(LIS(new int[]{1,2,3,4,9,5}));

        System.out.println(LIS(new int[]{1}));

        System.out.println(LIS(new int[]{}));

    }
}