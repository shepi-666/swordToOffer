package day29.offer51_reversePairs;

import org.junit.Test;

public class Solution2 {
    int count = 0; // 成员变量用来存储逆序对的数量
    /**
     * 使用归并排序
     * @param nums
     * @return
     */
    public int reversePairs(int[] nums) {
        int l = 0; int r = nums.length - 1;
        int[] temp = new int[r + 1];
        // 调用归并排序的方法
        divide(nums, l, r, temp);
        return count;
    }

    private void divide(int[] nums, int l, int r, int[] temp) {
        if (l < r) { // 起始坐标小于结束坐标，说明还可以划分
            int mid = (l + r) / 2;
            divide(nums, l, mid, temp);
            divide(nums, mid + 1, r, temp);
            // 合并
            merge(nums, l, mid, r, temp);
        }
    }

    private void merge(int[] nums, int l, int mid, int r, int[] temp) {
        int i = l; int j = mid + 1;
        int t = 0;

        // 将两个有序数组合并
        while (i <= mid && j <= r) {
            if (nums[i] <= nums[j]) temp[t++] = nums[i++];
            else {
                count += mid - i + 1; // 这里判断逆序对的数量，也就是左指针到左子数组结束的长度
                temp[t++] = nums[j++];
            }
        }

        while (i <= mid) temp[t++] = nums[i++];
        while (j <= r) temp[t++] = nums[j++];

        // 使用这个临时数组覆盖原来的数组
        t = 0;
        while (l <= r) {
            nums[l++] = temp[t++];
        }
    }

    @Test
    public void testSolution() {
        int[] nums = {7,5,6,4};
        System.out.println(reversePairs(nums));
    }
}
