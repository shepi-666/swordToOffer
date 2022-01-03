package day08.offer63_maxProfit;

public class Solution3 {
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int max = 0;
        for (int i = 0; i < prices.length; i++) {
            // 当前价格小于最小价格，我们就对min进行更新
            if (prices[i] < min) {
                min = prices[i];
            } else {
                // 否则计算利润
                max = Math.max(max, prices[i] - min);
            }
        }
        return max;

    }
}
