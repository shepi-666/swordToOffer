package day21.offer15_hammingWeight;

import org.junit.Test;

/**
 * 无符号整数的汉明重量
 */
public class MySolution {
    /**
     * 这种方法超时
     * @param n
     * @return
     */
    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            count = (n & 1) == 1 ? count + 1 : count;
            /*
            * >> : 算术右移：算术是带有符号的数据，我们不能直接移动所有的位数。
            * 对于一个正数，他的三码相同，因此无论是算术左移还是右移，都是补零
            * 负数在左移的时候需要在右端补零，右移的时候需要在最高位补1
            *
            * >>> ：逻辑移位：移位的结果只是对数据位有效，根据移位操作的目的，
            * 左移的时候，高位补零，右移的时候，低位补零
            * */
            n = n >> 1;
        }
        return count;
    }

    @Test
    public void test() {
        System.out.println(hammingWeight(11));
    }
}
