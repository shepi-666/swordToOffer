package day04.offer54_findNum1;

import org.junit.Test;

/**
 * 统计一个数字在排序数组中出现的次数
 */
public class MySolution {
    /**
     * 经典做法：对数组中的元素进行遍历，遇到目标值就加1
     * 遍历结束后返回
     * 时间复杂度：o(N)
     * 空间复杂度：o(1)
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                count ++;
            }
        }
        return count;
    }

    @Test
    public void test() {
        int[] nums = {5, 7, 7, 8, 8, 10};
        System.out.println(search(nums, 6));
    }
}
