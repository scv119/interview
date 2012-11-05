package leetcode;

/**
 * Created with IntelliJ IDEA.
 * User: shenchen
 * Date: 12-11-5
 * Time: PM11:29
 * To change this template use File | Settings | File Templates.
 */
public class MaxProfit {
    public int maxProfit(int[] prices) {
        int max = 0;
        int min = Integer.MAX_VALUE;

        for (int x : prices) {
            max = Math.max(max, x - min);
            min = Math.min(x, min);
        }

        return max;
    }
}
