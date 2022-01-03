package day23.offer39_majorityElement;

import java.util.HashMap;
import java.util.Map;

/**
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字
 */
public class MySolution {
    public int majorityElement(int[] nums) {
        if (nums.length == 1) return nums[0];
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (!map.containsKey(num)) {
                map.put(num, 1);
            } else {
                if (map.get(num) + 1 > nums.length / 2) {
                    return num;
                }
                map.put(num, map.get(num) + 1);
            }
        }
        return -1;
    }
}
