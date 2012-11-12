package leetcode;

/**
 * Created with IntelliJ IDEA.
 * User: shenchen
 * Date: 11/9/12
 * Time: 4:50 PM
 * To change this template use File | Settings | File Templates.
 */
public class BestTimeToSellStock {
    public int maxProfit(int[] prices) {
        if (prices.length < 2)
            return 0;

        int front[] = new int[prices.length];
        int end  [] = new int[prices.length];
        int min = Integer.MAX_VALUE;
        int val = 0;
        for (int i = 0; i < prices.length; i ++) {
            val = Math.max(val, prices[i] - min);
            min = Math.min(min, prices[i]);
            front[i] = val;
        }

        val = 0;
        int max = 0;
        for (int i = prices.length - 1; i >= 0; i --) {
            val = Math.max(max - prices[i], val);
            max = Math.max(max, prices[i]);
            end[i] = val;
        }

        int ret = 0;

        ret = Math.max(ret, end[0]);
        for (int i = 0; i < prices.length - 1; i ++) {
            ret = Math.max(ret, front[i] + end[i + 1]);
        }
        ret = Math.max(ret, front[prices.length -1]);

        return ret;
    }
}
