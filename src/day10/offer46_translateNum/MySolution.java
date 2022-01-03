package day10.offer46_translateNum;

import org.junit.Test;

public class MySolution {
    public int translateNum(int num) {
        String numStr = num + "a";
        int[] dp = new int[numStr.length()];
        dp[0] = 1;
        if (numStr.length() == 2) return dp[0];
        String subStr = numStr.substring(0, 2);
        if (Integer.parseInt(subStr) < 26) {
            dp[1] = 2;
        } else {
            dp[1] = 1;
        }

        for (int i = 2; i < numStr.length() - 1; i++) {
            dp[i] = dp[i-1];
            subStr = numStr.substring(i-1, i+1);
            if (Integer.parseInt(subStr) < 26 && Integer.parseInt(subStr) > 9) {
                dp[i] = dp[i] + dp[i - 2];
            }
        }

        return dp[dp.length-2];

    }

    @Test
    public void test() {
        int nums = translateNum(605);
        System.out.println(nums);
    }

}
