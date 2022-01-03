package day03.offer05_replaceSpace;

import org.junit.Test;

/**
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 *
 *  方法2：使用API：s.replace(" ", "%20");
 *
 */
public class MySolution {
    public String replaceSpace(String s) {
        if (s == null || s.length() == 0) return s;
        char[] chars = s.toCharArray();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != 32) {
                builder.append(chars[i]);
            } else {
                builder.append("%20");
            }
        }
        return builder.toString();
    }

    @Test
    public void test() {
        String s = replaceSpace("we are happy");
        System.out.println(s);
    }
}
