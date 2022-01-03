package day19.offer64_sumNums;

/**
 * 求一个等差数列
 *
 * 要求不能使用乘除法、
 * for、while、if、else、switch、case等关键字及
 * 条件判断语句A?B:C）
 */
public class MySolution {
    /**
     * 没有看题，这种做法直接排除
     * @param n
     * @return
     */
    public int sumNums(int n) {
        return (1 + n) * n / 2;
    }
}
