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

    //nlgn solution
    public static int solve1(int[] arr) {
        if(arr == null || arr.length == 0)
            return 0;
        if(arr.length == 1)
            return 1;

        int len = arr.length;
        int stack[] = new int[len];
        int stackLen = 0;

        Arrays.fill(stack, Integer.MAX_VALUE);
        stack[stackLen ++ ] = arr[0];
        for(int i = 1; i < len; i ++) {
            if(arr[i] > stack[stackLen - 1])
                stack[stackLen ++] = arr[i];
            else if(stack[0] >= arr[i]) {
                stack[0] = arr[i];
            } else {
                int start = 0; int end = stackLen -1;
                while(start < end - 1) {
                    int mid = start + (end - start)/2;
                    if(stack[mid] >= arr[i])
                        end = mid;
                    else
                        start = mid;
                }
                stack[end] = arr[i];
            }
        }
        return stackLen;
    }



    public static void main(String args[]) {
        System.out.println(solve1(new int[]{1,2,3,3,4,9,5}));

        System.out.println(solve1(new int[]{1}));

        System.out.println(solve1(new int[]{}));

    }
}