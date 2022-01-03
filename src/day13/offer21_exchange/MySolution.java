package day13.offer21_exchange;

import org.junit.Test;

import java.util.Arrays;

/**
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
 * 使得所有奇数在数组的前半部分，所有偶数在数组的后半部分。
 */
public class MySolution {
    public int[] exchange(int[] nums) {
        if (nums == null) return null;
        if (nums.length <= 1) return nums;
        int j = nums.length - 1;
        int temp;
        for (int i = 0; i < j; i++) {
            while (nums[i] % 2 == 0) {
                if (j < i) {
                    return nums;
                }
                temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                j--;
            }
        }
        return nums;
    }

    @Test
    public void test() {
        int[] nums = {2, 4, 6};
        System.out.println(Arrays.toString(exchange(nums)));
    }
}
