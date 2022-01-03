package day08.offer63_maxProfit;

public class Solution2 {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int profit, preProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            profit = Math.max(0, preProfit + prices[i] - prices[i-1]);
            maxProfit = Math.max(maxProfit, profit);
            preProfit = profit;
        }
        return maxProfit;

    }

}
