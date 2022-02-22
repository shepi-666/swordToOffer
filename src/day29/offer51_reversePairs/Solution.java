package day29.offer51_reversePairs;

import org.junit.Test;

/**
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
 * 输入一个数组，求出这个数组中的逆序对的总数。
 */
public class Solution {
    // 暴力破解法, 很显然会超时
    public int reversePairs(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] > nums[j]) count ++;
            }
        }
        return count;
    }


    @Test
    public void testSolution() {
        int[] nums = {7,5,6,4};
        System.out.println(reversePairs(nums));
    }
}
