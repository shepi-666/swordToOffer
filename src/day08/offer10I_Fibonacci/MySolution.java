package day08.offer10I_Fibonacci;

public class MySolution {
    /**
     * 计算斐波那契数列的第N项，这里采用递归的方式
     * [超出时间]
     * @param n
     * @return
     */
    public int fib(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        return fib(n-1) + fib(n-2);
    }

}
