package day09.offer47_maxGiftVal;

public class MySolution {
    /**
     * 状态转移方方程：dp[i][j] = max(dp[i-1][j], dp[i][j-1]) + dp[i][j]
     * 这道题的难点在于处理边界条件
     * @param grid
     * @return
     */
    public int maxValue(int[][] grid) {

        int[][] dp = new int[grid.length][grid[0].length];
        // 首先应当与边界进行赋值
        dp[0][0] = grid[0][0];
        for (int i = 1; i < grid.length; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }

        for (int i = 1; i < grid[0].length; i++) {
            dp[0][i] = dp[0][i - 1] + grid[0][i];
        }



        for (int i = 1; i < grid.length; i++) {
            for (int j = 1; j < grid[0].length; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }

        return dp[grid.length - 1][grid[0].length - 1];
    }
}
