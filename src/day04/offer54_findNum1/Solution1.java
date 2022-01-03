package day04.offer54_findNum1;

import org.junit.Test;

public class Solution1 {
    /**
     * 注意到这是一个有序数组，我们可以先使用二分法来定位该元素出现的位置
     * 然后从中间向两边扩散
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        int beginIndex = 0;
        int endIndex = nums.length - 1;
        int midIndex;
        int targetIndex = -1;
        while (beginIndex <= endIndex) {
            midIndex = (beginIndex + endIndex) / 2;
            if (nums[midIndex] < target) {
                beginIndex = midIndex + 1;
            } else if (nums[midIndex] > target){
                endIndex = midIndex - 1;
            } else {
                targetIndex = midIndex;
                break;
            }
        }
        if (targetIndex == -1) return 0;
        int count = 1;
        beginIndex = targetIndex - 1;
        endIndex = targetIndex + 1;
        while (beginIndex >= 0 && nums[beginIndex] == target) {
            beginIndex--; count++;
        }
        while (endIndex < nums.length && nums[endIndex] == target) {
            endIndex++; count++;
        }
        return count;
    }

    @Test
    public void test() {
        int[] nums = {5, 7, 7, 8, 8, 8, 8, 10};
        System.out.println(search(nums, 8));
    }
}
