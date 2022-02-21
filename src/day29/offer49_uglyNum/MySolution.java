package day29.offer49_uglyNum;

import org.junit.Test;

import java.util.Arrays;

/**
 * 丑数：只包含质因子2, 3, 5的数称为丑数，求第n个丑数
 */
public class MySolution {
    /**
     * 一个丑数只能通过另外一个丑数和质因子(2, 3, 5)相乘得到，因此我们可以将原始的从丑数分别和
     * 质因子相乘，在进行排序，得到丑数的序列
     * @param n
     */
    public void nthUglyNumber(int n) {
        int[] res = new int[n];
        int i = 0, j = 0, k = 0; // 三个丑数数组[虚拟]的索引, 通过丑数和质因子相乘得到
        res[0] = 1;
        for (int m = 1; m < n; m++) {
            // 找出最小的丑数，排到结果中去
            int temp = Math.min(res[i] * 2, Math.min(res[j] * 3, res[k] * 5));
            if (temp == res[i] * 2) i++;
            if (temp == res[j] * 3) j++;
            if (temp == res[k] * 5) k++;
            res[m] = temp;
        }
        System.out.println(Arrays.toString(res));
    }

    @Test
    public void testSolution() {
        nthUglyNumber(10);
    }
}
