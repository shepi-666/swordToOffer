package day23.offer39_majorityElement;

import org.junit.Test;

import java.util.Arrays;

/**
 * 使用快速排序法，将数组中的数进行排序，然后返回中间的数
 */
public class Solution {
    public int majorityElement(int[] nums) {
        quickSort(0, nums.length-1, nums);
        return nums[nums.length / 2];

    }

    public void quickSort(int begin, int end, int[] nums) {
        if (begin >= end) return;
        int l = begin;
        int r = end;
        int p = nums[l];

        while (l < r) {
            // 首先移动有指针
            while (nums[r] > p && r > l) r--;

            if (r > l) nums[l++] = nums[r];
            // 移动左指针
            while (nums[l] < p && r > l) l++;

            if (l < r) nums[r--] = nums[l];
        }
        nums[l] = p;
        quickSort(begin, r - 1, nums);
        quickSort(r + 1, end, nums);
    }

    @Test
    public void testQuickSort() {
        int[] nums = {1, 2, 3, 2, 2, 2, 5, 4, 2};
        quickSort(0, nums.length - 1, nums);
        System.out.println(Arrays.toString(nums));

    }
}
