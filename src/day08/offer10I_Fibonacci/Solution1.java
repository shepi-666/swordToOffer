package day08.offer10I_Fibonacci;

public class Solution1 {
    /**
     * 这个算法的空间复杂度太高
     * @param n
     * @return
     */
    public int fib(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        int[] dp = new int[n];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < n; i++) {
            dp[i] = (dp[i-1] +dp[i-2]) % 1000000007;
        }
        return dp[n-1];
    }


}
