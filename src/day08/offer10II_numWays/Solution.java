package day08.offer10II_numWays;

import org.junit.Test;

public class Solution {
    public int numWays(int n) {
        if (n == 0) return 0;
        int[] dp = new int[2];
        dp[0] = 1;
        dp[1] = 2;
        for (int i = 3; i <= n; i++) {
            dp[(i - 1) % 2] = (dp[0] + dp[1]) % 1000000007;
        }
        return dp[(n - 1) % 2];
    }

    @Test
    public void test() {
        System.out.println(numWays(7));
    }
}
