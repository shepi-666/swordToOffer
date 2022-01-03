package day08.offer10I_Fibonacci;

import org.junit.Test;

public class Solution2 {
    public int fib(int n) {
        int[] dp = new int[2];
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i % 2] = (dp [0] + dp[1]) % 1000000007;
        }

        return dp[n % 2];

    }

    @Test
    public void test() {
        System.out.println(fib(2));
    }


}
