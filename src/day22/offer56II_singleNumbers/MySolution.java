package day22.offer56II_singleNumbers;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

/**
 * 在一个数组 nums 中除一个数字只出现一次之外，其他数字都出现了三次。
 * 请找出那个只出现一次的数字。
 */
public class MySolution {
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (!map.containsKey(num)) {
                map.put(num, 1);
            } else {
                Integer integer = map.get(num) + 1 == 3 ? map.remove(num) : map.put(num, map.get(num) + 1);

            }
        }
        int res = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            res = entry.getKey();
        }
        return res;
    }
}
