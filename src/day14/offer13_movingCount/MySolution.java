package day14.offer13_movingCount;

import org.junit.Test;

/**
 * 这样的解答是错误的，这样答案中有些点数可能是一座孤岛，机器人没法过去
 */
public class MySolution {
    public int movingCount(int m, int n, int k) {
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (handle(i) + handle(j) <= k) {
                    count++;
                }
            }
        }
        return count;
    }

    public int handle(int i) {
        int sum = 0;
        while (i > 0) {
            sum = sum + i % 10;
            i = i / 10;
        }
        return sum;
    }

    @Test
    public void test() {
        System.out.println(handle(11));
    }
}
