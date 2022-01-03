package day05.offer50_findUniqueChar;

import org.junit.Test;

public class MySolution {
    public char firstUniqChar(String s) {
        if (s == null || s.length() == 0) {
            return ' ';
        }
        char[] chars = s.toCharArray();
        int[] temp = new int[26];
        for (int i = 0; i < chars.length; i++) {
            temp[chars[i]-97]++;
        }
        for (int i = 0; i < chars.length; i++) {
            if (temp[chars[i]-97] == 1) {
                return chars[i];
            }
        }
        return ' ';
    }

    @Test
    public void test() {
        String s = "abaccdeff";
        System.out.println(firstUniqChar(s));
    }
}
