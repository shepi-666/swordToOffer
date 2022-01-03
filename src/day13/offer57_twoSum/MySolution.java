package day13.offer57_twoSum;


import java.util.HashMap;
import java.util.Map;

/**
 * 输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。
 * 如果有多对数字的和等于s，则输出任意一对即可。
 * 两数之和，使用哈希表
 * 空间复杂度：o(N)
 * 时间复杂度：o(N)
 *
 * 双5%
 */
public class MySolution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] res = new int[2];
        for (Integer i : nums) {
            if (i < target) {
                map.put(i, target - i);
            }
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (map.containsKey(entry.getValue())) {
                res[0] = entry.getKey();
                res[1] = entry.getValue();
                return res;
            }
        }
        return res;
    }
}
