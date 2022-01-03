package day24.offer14I_cuttingRope;

public class Solution {
    /**
     * 使用动态规划的方式求解
     * @param n
     * @return
     */
    public int cuttingRope(int n) {
        if (n <= 3) return n - 1;
        int[] dp = new int[n + 1];
        dp[2] = 1;
        dp[3] = 2;
        // i 代表原始绳子的长度
        for (int i = 4; i <= n; i++) {
            // j 代表第一次剪下绳子的长度，因为剪下长度为1的绳子毫无意义，所以就j从2开始
            for (int j = 2; j < i - 1; j++) {
                dp[i] = Math.max(dp[i], Math.max(j * (i - j), j * dp[i - j]));
            }
        }
        return dp[n];
    }
}
