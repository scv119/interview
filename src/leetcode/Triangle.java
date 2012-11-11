package leetcode;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: shenchen
 * Date: 12-11-11
 * Time: PM3:42
 * To change this template use File | Settings | File Templates.
 */
public class Triangle {
    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        int len = triangle.size();

        if (len == 0)
            return 0;

        int [][]dp = new int[2][len];
        dp[0][0]   = triangle.get(0).get(0);
        int idx = 0;

        for (int i = 1; i < triangle.size(); i ++) {
            ArrayList<Integer> list = triangle.get(i);
            dp[idx^1][0] = dp[idx][0] + list.get(0);
            dp[idx^1][list.size() - 1] = dp[idx][list.size() - 2] + list.get(list.size() - 1);

            for (int j = 1; j < list.size() - 1; j ++) {
                dp[idx^1][j] = list.get(j) + Math.min(dp[idx][j-1], dp[idx][j]);
            }

            idx = idx ^ 1;
        }

        int min = Integer.MAX_VALUE;

        for (int i = 0; i < len ; i ++) {
            min = Math.min(min, dp[idx][i]);
        }

        return min;

    }
}
