package day08.offer63_maxProfit;

import org.junit.Test;

public class Solution {
    /**
     * 股票的最大利润
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        if (prices.length <= 1) return 0;
        // 初始化买入的花销
        int buy = -prices[0];
        // 初始化卖出的利润
        int sell = 0;
        for (int i = 1; i < prices.length; i++) {
            // 要么不卖出，要么就是卖出的价格+买入的利润
            sell = Math.max(sell, prices[i] + buy);
            // 要么不买入，买入的时候肯定是在最低点买入
            buy = Math.max(buy, -prices[i]);
        }
        return sell;
    }

    @Test
    public void test() {
        int[] nums = {7,6,5,4,3,2};
        System.out.println(maxProfit(nums));
    }
}
