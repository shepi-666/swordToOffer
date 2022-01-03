package day17.offer40_leastNumbers;

import org.junit.Test;

import java.util.Arrays;

/**
 * 自己写一个快排序
 */
public class Solution {
    public int[] getLeastNumbers(int[] arr, int k) {
        quickSort(arr, 0, arr.length-1);
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    public void quickSort(int[] arr, int begin, int end) {
        if (begin >= end) return;
        int l = begin;
        int r = end;
        // 每次将最左边的数值作为中心值
        int temp = arr[l];
        while (l < r) {
            // 先移动右指针
            while (l < r && arr[r] >= temp) {
                r--;
            }
            // 结束循环之后我们将右指针所指的数赋给左指针
            if (r > l) {
                arr[l++] = arr[r];
            }

            while (l < r && arr[l] <= temp) {
                l++;
            }
            if (l < r) {
                arr[r--] = arr[l];
            }

        }
        // 跳出循环之后，我们的左右指针处于相等的位置
        arr[l] = temp;
        quickSort(arr, begin, r - 1);
        quickSort(arr, r + 1 , end);
    }

    @Test
    public void test() {
        int[] array = {3, 5, 2, 3, 1, 4};
        quickSort(array, 0, array.length-1);
        System.out.println(Arrays.toString(array));
    }
}
