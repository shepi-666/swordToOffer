package day30.offer60_dicesProbability;

import java.util.Arrays;

public class MySolution {
    public double[] dicesProbability(int n) {
        // 一颗色子的时候，概率分布
        double[] dp = new double[6];
        Arrays.fill(dp, 1.0/6.0); // 概率分布初始化

        // 从第2颗骰子开始，循环计算出后续的骰子点数
        for (int i = 2; i <= n; i++) {
            // i颗骰子最多可以有 i * 6 - i + 1 中点数情况
            double[] tmp = new double[i * 6 - i + 1];
            for (int j = 0; j < dp.length; j++) {
                // i - 1 时刻骰子的概率分布
                for (int k = 0; k < 5; k++) {
                    // 因为骰子的点数为 1 ~ 6， 所以造成的偏移量为 0 ~ 5
                    tmp[j + k] = tmp[j + k] + dp[j] / 6.0; // 上一个时刻点数 j 对本时刻的影响
                }
            }
            dp = tmp;
        }
        return dp;
    }

}
