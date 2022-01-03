package day16.offer61_isStraight;

import java.util.Arrays;

/**
 * 判断扑克牌中是否有顺子
 */
public class Solution {
    public boolean isStraight(int[] nums) {
        Arrays.sort(nums);
        // 剔除出现非0重复数字的可能
        int count = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == 0) count++;
            if (nums[i] == nums[i+1] && nums[i] != 0) {
                return false;
            }
        }
        // 如果差距大于4的话，返回false
        int gap = nums[4] - nums[count];
        return gap >= 4 - count && gap <= 4;


    }
}
