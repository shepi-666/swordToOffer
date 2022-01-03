package day04.offer53_missingNumber;

import org.junit.Test;

/**
 * 一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。
 * 在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。
 */
public class MySolution {
    /**
     * 循环遍历
     * 时间复杂度：o(N)
     * @param nums
     * @return
     */
    public int missingNumber(int[] nums) {
        int i;
        for (i = 0; i < nums.length; i++) {
            if (nums[i] != i) {
                return i;
            }
        }
        return i;
    }

    @Test
    public void test() {
        int[] nums = {0, 1, 2};
        System.out.println(missingNumber(nums));
    }
}
