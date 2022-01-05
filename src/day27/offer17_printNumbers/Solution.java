package day27.offer17_printNumbers;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 本题考察的是在大数越界的情况下打印
 */
public class Solution {
    List<String> res = new ArrayList<>();
    int n;
    char[] num; // 用来表示某一个数字
    // 用来表示数字的字符集
    char[] charset = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
    public List<String> printNumbers(int n) {
        this.n = n;
        num = new char[n]; // 表示num是一个n位数
        dfs(0);
        return res;
    }

    private void dfs(int i) {
        // 三位数的每一个数都递归完了
        if (i == n) {
            // 当所有的位数递归完成之后，我们判断每一位数的0
            int j = 0;
            for (int k = 0; k < n; k++) {
                if (num[k] == '0') j++;
            }
            if (j == n) return; // 说明此时这个数字所有位都是0，直接返回

            // 将这个n位数添加到结果集
            // char数组， 起始位，子数组的长度
            res.add(String.valueOf(num, j, n - j));
            // 返回
            return;
        }
        /**
         * 下面这样处理会出现前导0和00，如何去除前导0呢
         */
        for (char c : charset) {
            num[i] = c; // 先固定首位为c
            dfs(i + 1);
        }
    }

    @Test
    public void testPrint() {
        List<String> list = printNumbers(2);
        list.forEach(System.out::println);
    }
}
