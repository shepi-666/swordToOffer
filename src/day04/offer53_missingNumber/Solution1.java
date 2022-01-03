package day04.offer53_missingNumber;

import org.junit.Test;

public class Solution1 {
    /**
     * 注意到这是一个有序数组，有序数组一定要向二分法靠
     * 左子数组的索引为[0, mid], 右子数组的索引为[mid+1, length-1]
     * 左子数组的索引值等于其元素值，右子数组值不等于其元素的值
     * 返回结果就是右子数组的开始索引
     *
     * 跳出循环的时候begin的值为右子数组的开始索引
     * end为左子数组的结束索引
     * @param nums
     * @return
     */
    public int missingNumber(int[] nums) {
        int begin = 0;
        int end = nums.length - 1;
        int mid;
        while (begin <= end) {
            mid = (begin + end) / 2;
            if (nums[mid] != mid) {
                end = mid - 1;
            } else {
                begin = mid + 1;
            }
        }
        return begin;
    }

    @Test
    public void test() {
        int[] nums = {0, 1, 2};
        System.out.println(missingNumber(nums));
    }
}
