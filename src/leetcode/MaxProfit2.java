package leetcode;

/**
 * Created with IntelliJ IDEA.
 * User: shenchen
 * Date: 12-11-5
 * Time: PM11:49
 * To change this template use File | Settings | File Templates.
 */
public class MaxProfit2 {
    public int maxProfit(int[] prices) {
        int ret = 0;
        int buy = -1;

        for (int i = 0; i < prices.length; i ++) {
            if (buy == -1) {
                if (i < prices.length - 1 && prices[i] < prices[i+1])
                    buy = prices[i];
            } else {
                if (i == prices.length - 1 || prices[i] > prices[i+1]) {
                    ret += prices[i] - buy;
                    buy = -1;
                }
            }
        }

        return ret;
    }
}
