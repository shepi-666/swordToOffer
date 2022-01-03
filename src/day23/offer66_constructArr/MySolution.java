package day23.offer66_constructArr;

/**
 * 构建乘积数组
 */
public class MySolution {
    public int[] constructArr(int[] a) {
        int[] res = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            res[i] = 1;
            for (int j = 0; j < a.length; j++) {
                res[i] *= j == i ? 1 : a[j];
            }
        }
        return res;
    }
}
