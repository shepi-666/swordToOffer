package day26.offer14_cuttingRope;

import org.junit.Test;

/**
 * 这里主要考察大数取余问题：
 * 在仅仅使用int类型存储的前提下，正确计算指数对p的取余
 *
 * 有两种解决方案：
 *      * 循环取余
 *      * 快速幂取余
 */
public class MySolution {
    /**
     * 使用循环取余法，这样的时间复杂度就是o(n)
     * @param n
     * @return
     */
    public int cuttingRope(int n) {
        if (n <= 3) {
            return n - 1;
        }
        long res = 1;
        int a = n / 3;
        int b = n % 3;
        for (int i = 1; i <= a - 1; i++) {
            res = (res * 3) % 1000000007;
        }

        if (b == 0) return (int)(res * 3) % 1000000007;
        if (b == 1) return (int)(res * 4) % 1000000007;
        return (int) ((res * 6) % 1000000007);
    }

    @Test
    public void testSolution() {
        System.out.println(cuttingRope(100));
    }
}
