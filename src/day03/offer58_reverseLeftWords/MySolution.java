package day03.offer58_reverseLeftWords;

import org.junit.Test;

/**
 * 字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。
 * 请定义一个函数实现字符串左旋转操作的功能
 */
public class MySolution {
    public String reverseLeftWords(String s, int n) {
        String s1 = s.substring(0, n);
        String s2 = s.substring(n);
        return s2 + s1;
    }

    @Test
    public void test() {
        String s = "abcdefg";
        System.out.println(reverseLeftWords(s, 2));
    }
}
