package day29.offer43_countDigit1;

/**
 * 输入一个整数 n ，求1～n这n个整数的十进制表示中1出现的次数。
 */
public class MySolution {
    /**
     * 假设有数字：3126 , 当前位数指向十位，那么可以将0 ~ 3126分为两半
     * 固定十位为1，可以得出以下结果
     *      0000 ~ 3099: [00 ~ 30] 1 [0 ~ 9]
     *      3100 ~ 3126: 31 1 [0 ~ 9]
     * 那么十位上为 1 的个数为 31 *10 + 10
     * @param n
     * @return
     */
    public int countDigitOne(int n) {
        int res = 0;
        int digit = 1; // 表示位数
        int cur = n % 10;
        int high = n / 10; // 表示高位
        int low = 0; // 表示低位
        while (high != 0 || cur != 0) { // 当前为和高位同时等于0，说明已经越过了最高位
            if (cur == 0) { // 当前位为 0 的情况
                res = res + high * digit;
            } else if (cur != 1) { // 当前位不为 1 的情况
                res = res + (high + 1) * digit;
            } else { // 当前位为 1 的情况
                res = res + high * digit + low + 1;
            }

            // 数据的更新
            low = low + cur * digit; // 低位
            cur = high % 10; // 当前位的更新
            high = high / 10; // 高位
            digit = digit * 10; // 数位
        }
        return res;
    }
}
