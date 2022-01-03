package day20.offer16_myPow;

/**
 * pow(x, n)  即计算 x 的 n 次幂函数
 */
public class MySolution {
    public double myPow(double x, int n) {
        double res = 1;
        // 这个整数n在计算机的底层是二进制存储的
        long b = n;
        // 为了避免除0操作，先判断底数的值
        if (x == 0) return 0;
        // 幂为负数的情况，将底数改为分数
        if (b < 0) {
            x = 1 / x;
            b = -b;
        }

        while (b != 0) {
            if ((b & 1) == 1) res = res * x;
            // x 变为自己的平方
            x = x * x;
            // b变为自己的一半
            b = b >> 1;
        }
        return res;
    }
}
