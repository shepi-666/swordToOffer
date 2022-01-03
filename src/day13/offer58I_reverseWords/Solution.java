package day13.offer58I_reverseWords;

import org.junit.Test;

public class Solution {
    /**
     * 使用双指针的方法,从字符串的尾部开始
     * @param s
     * @return
     */
    public String reverseWords(String s) {
        // 首先对s的首尾去除空格
        if (s.trim().length() <= 2) return s.trim();

        StringBuilder builder = new StringBuilder();

        int i = s.length() - 1;
        int j;

        // 增加长度防止溢出
        s = s + " ";
        while (i >= 0) {
            while (i >= 0 && s.charAt(i) == ' ') i--;
            j = i;
            while (i >= 0 && s.charAt(i) != ' ') i--;
            builder.append(s.substring(i + 1, j + 1));
            builder.append(" ");
        }
        return builder.toString().trim();

    }


    @Test
    public void test() {
    }
}
