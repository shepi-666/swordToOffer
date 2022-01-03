package day09.offer42_maxSubArray;

import org.junit.Test;

/**
 * 输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。
 * 求所有子数组的和的最大值。
 */
public class Solution {
    /**
     * 状态转移方程为：dp[i] = dp[i-1] + nums[i] - nums[i-1]
     *              retVal = Math.max(dp[i], ret)
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int dp = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp = Math.max(dp + nums[i], nums[i]);
            max = Math.max(max, dp);
        }
        return max;
    }


    @Test
    public void test() {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(nums));
    }

}
