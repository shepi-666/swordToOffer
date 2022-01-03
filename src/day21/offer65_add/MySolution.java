package day21.offer65_add;

import org.junit.Test;

public class MySolution {
    public int add(int a, int b) {
        while(b != 0) { // 当进位为 0 时跳出
            int c = (a & b) << 1;  // c = 进位
            a ^= b; // a = 非进位和
            b = c; // b = 进位
        }
        return a;

    }

    @Test
    public void testAdd() {
        System.out.println(add(5, -1));
    }

}
