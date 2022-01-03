package day10.offer48_LongestSubstring;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s== null || s.length() == 0) return 0;
        char[] chars = s.toCharArray();
        int j = -1;
        int res = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < chars.length; i++) {
            // 包含字符，我们就更新指针
            if (map.containsKey(chars[i])) {
                j = Math.max(j, map.get(chars[i]));
            }
            map.put(chars[i], i);
            res = Math.max(res, i - j);
        }
        return res;
    }
}
