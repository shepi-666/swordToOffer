package day26.offer14_cuttingRope;

/**
 * 这个例子用来讲述如何使用快速幂取模算法
 */
public class Solution {
    /**
     *
     * @param a 底数
     * @param b 幂
     * @param c 模值
     * @return
     */
    public int quick(int a, int b, int c) {
        int A = 1;
        int T = a % c; // 实际上就是剪绳子中的3

        while (b != 0) {
            if ((b & 1) == 1) {
                A = (A * T) % c;
            }
            // b向右进行移位
            b >>= 1;
            T = (T * T) % c;
        }
        return A;
    }
}
