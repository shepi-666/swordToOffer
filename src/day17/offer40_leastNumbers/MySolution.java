package day17.offer40_leastNumbers;

import java.util.Arrays;

/**
 * 调用系统的api
 */
public class MySolution {
    public int[] getLeastNumbers(int[] arr, int k) {
        Arrays.sort(arr);
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = arr[i];
        }
        return res;
    }
}
