package day30.offer67_strToInt;

import org.junit.Test;

/**
 * 写一个函数 StrToInt，实现把字符串转换成整数这个功能
 */
public class MySolution {
    public int strToInt(String str) {
        // 该函数会根据需要丢弃无用的开头空格字符
        String s = str.trim();

        // str只有空格或者 第一个字符非数值型符号的时候无法转换
        if (s.length() == 0 ||
                (s.charAt(0) != '+' && s.charAt(0) != '-' && (s.charAt(0) > '9' || s.charAt(0) < '0') )
        ) return 0;

        char[] chars = s.toCharArray();
        if (chars[0] == '-' || chars[0] == '+') {
            // 有符号的数
            return charToNum(chars, 1);
        } else {
            return charToNum(chars, 0);
        }

    }

    private int charToNum(char[] chars, int i) {
        long res = 0; int j = i; long digit = 1; boolean flag = true;
        // 去零操作
        for (int k = i; k < chars.length; k++) {
            if (chars[k] == '0') i++;
            else break;
        }
        // 得到有效位的末尾
        while (j < chars.length) {
            if (chars[j] >= '0' && chars[j] <= '9' ) {
                j++;
            }
            else break;
        }

        // 判断这个数是否为正数
        if (chars[0] == '-') flag = false;

        // 判断是否过长
        if ((j - i) > 11) {
            return flag ? 2147483647 : -2147483648;
        }


        // 计算出来有效的位数
        for (int k = j - 1; k >= i; k--) {
            res = (long) (chars[k] - '0') * digit + res;
            digit = digit * 10;
            if (flag) {
                if (res > 2147483647) return 2147483647;
            }
            if (!flag) {
                if (-res < -2147483648) return -2147483648;
            }
        }
        return flag ? (int) res :  (int) (-res);
    }


    @Test
    public void testSolution() {
        System.out.println(strToInt("100000000000000000000000000000000000000000000001123"));
    }
}
