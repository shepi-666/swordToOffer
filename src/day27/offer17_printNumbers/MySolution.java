package day27.offer17_printNumbers;

/**
 * 输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数
 */
public class MySolution {
    public int[] printNumbers(int n) {
        int end = (int) (Math.pow(10, n) - 1);
        int[] res = new int[end];
        for (int i = 1; i <= end; i++) {
            res[i] = i;
        }
        return res;
    }
}
