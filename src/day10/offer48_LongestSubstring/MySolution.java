package day10.offer48_LongestSubstring;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 *请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。
 */
public class MySolution {
    /**
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        if (s== null || s.length() == 0) return 0;
        char[] chars = s.toCharArray();
        int length = 0;
        int coordinate = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < chars.length; i++) {
            if (i == chars.length-1) {
                length = Math.max(length, i - coordinate + 1);
            }
            if (map.containsKey(chars[i])) {
                int l1 = i - coordinate;
                coordinate = map.get(chars[i]) + 1;
                length = Math.max(length, l1);
            }
            map.put(chars[i], i);
        }
        return length;
    }

    @Test
    public void test() {
        System.out.println(lengthOfLongestSubstring("tmmzuxt"));
    }
}
