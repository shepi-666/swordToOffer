package day24.offer14I_cuttingRope;


/**
 * 将绳子问题，如何将一个绳子分割成若干根，然后这几根绳子的乘积最大
 */
public class MySolution {
    /**
     * 使用数学方法求解
     * @param n
     * @return
     */
    public int cuttingRope(int n) {
        if (n <= 3) return n - 1;
        int a = n / 3;
        if (n % 3 == 0) {
            return (int) Math.pow(3, a);
        } else if (n % 3 == 1) {
            return (int) (Math.pow(3, a - 1) * 4);
        } else {
            return (int) (Math.pow(3, a) * 2);
        }
    }
}
