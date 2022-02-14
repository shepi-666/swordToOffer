package day28.offer44_findNthDigit;

import org.junit.Test;

/**
 * 这个解法超时了
 */
public class Solution {
    public int findNthDigit(int n) {
        int i = 0;
        String s = String.valueOf(i);
        while (n >= s.length()) {
            n = n - s.length();
            i ++;
            s = String.valueOf(i);
        }
        return s.charAt(n) - 48;
    }

    @Test
    public void test() {
        System.out.println(findNthDigit(19));
    }
}
