package day05.offer50_findUniqueChar;

import java.util.HashMap;

public class Solution {
    /**
     * 使用hashMap存储
     * @param s
     * @return
     */
    public char firstUniqChar(String s) {
        HashMap<Character, Boolean> map = new HashMap<>();
        char[] chars = s.toCharArray();
        for (char c : chars) {
            map.put(c, !map.containsKey(c));
        }
        for (char c : chars) {
            if (map.get(c)) return c;
        }
        return ' ';
    }
}
