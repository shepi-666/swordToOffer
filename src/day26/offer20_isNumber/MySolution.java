package day26.offer20_isNumber;

import java.util.HashMap;
import java.util.Map;

/**
 * 实现一个函数来判断字符串是否为一个数值（整数和小数）
 */
public class MySolution {
    public boolean isNumber(String s) {
        // 首先剪去首尾的空格
        String s1 = s.trim();
        char[] chars = s1.toCharArray();

        // 判断是否有点的标志
        boolean dotFlag = false;
        // 判断是否有数字的标志
        boolean numFlag = false;
        // 判断是否有e或者E的标志
        boolean EFlag = false;

        /*
        * 满足是一个数值型字符串的必要条件
        * 1 只含有一个e，E，前一位是数字
        * 2 只含有一个符号：- +，在开头出现或者e后面出现
        * 3 只含有一个 . ，在e之前出现
        *
        * */

        // 遍历数组
        for (int i = 0; i < chars.length; i++) {
            // 数字位判定
            if (chars[i] >= '0' && chars[i] <= '9') numFlag = true;
            // 判断 . 是否出现在正确的位置:没有出现过.也没出现过e
            else if (chars[i] == '.' && !dotFlag && !EFlag) dotFlag = true;
            // 判断e是否出现在正确的位置
            else if ((chars[i] == 'e' || chars[i] == 'E')
                        && !EFlag && numFlag) {
                EFlag = true;
                numFlag = false; // 为了避免e出现在末位，我们将数字标志置位0

                // + - 只能出现在首位末位或者e的后面
            } else if ((chars[i] == '+' || chars[i] == '-')
                    && (i == 0 || chars[i - 1] == 'e' || chars[i - 1] == 'E')) {

            } else {
                // 其他情况都是不合法的，返回false即可
                return false;
            }
        }

        return numFlag;




    }
}
