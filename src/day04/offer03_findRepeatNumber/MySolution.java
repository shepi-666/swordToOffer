package day04.offer03_findRepeatNumber;

import java.util.HashMap;
import java.util.Map;

/**
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。
 * 数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。
 * 请找出数组中任意一个重复的数字。
 */
public class MySolution {
    /**
     * 基本思路就是将这些值存储到哈希表中
     * @param nums
     * @return
     */
    public int findRepeatNumber(int[] nums) {
        Map<Integer, String> numsMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!numsMap.containsKey(nums[i])) {
                numsMap.put(nums[i], "");
            } else {
                return nums[i];
            }
        }
        return 0;
    }
}
