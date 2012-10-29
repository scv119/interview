package leetcode;

/**
 * Created with IntelliJ IDEA.
 * User: shenchen
 * Date: 12-10-29
 * Time: PM4:24
 * To change this template use File | Settings | File Templates.
 */
public class MinimumPathSum {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = 0;
        if(m > 0)
            n = grid[0].length;

        if(m == 0 || n == 0)
            return 0;
        if(m == 1 && n == 1)
            return grid[0][0];

        int dp[][] = new int[m][n];
        for(int i = 0; i < m; i ++) {
            dp[i][0] = grid[i][0];
            if(i != 0)
                dp[i][0] += dp[i-1][0];
        }

        for(int j = 0; j< n; j++) {
            dp[0][j] = grid[0][j];
            if(j != 0)
                dp[0][j] += dp[0][j-1];
        }

        for(int i = 1; i < m; i ++)
            for(int j = 1; j < n; j++)
                dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + grid[i][j];

        return dp[m-1][n-1];

    }
}
