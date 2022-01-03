package day05.offer50_findUniqueChar;

import java.util.LinkedHashMap;
import java.util.Map;

public class Solution2 {
    /**
     * 使用有序的哈希表LinkedHashMap来存储数据
     * LinkedHashMap会根据插入元素的先后顺序来进行排序
     * @param s
     * @return
     */
    public char firstUniqChar(String s) {
        LinkedHashMap<Character, Boolean> map = new LinkedHashMap<>();
        char[] chars = s.toCharArray();
        for (char c : chars) {
            map.put(c, !(map.containsKey(c)));
        }

        // 遍历map集合
        for (Map.Entry<Character, Boolean> entry : map.entrySet()) {
            if (entry.getValue()) {
                return entry.getKey();
            }
        }
        return ' ';
    }
}
