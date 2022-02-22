package day30.offer59I_maxSlidWindow;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 维护一个大小为窗口大小的大顶堆，顶堆元素则为当前窗口的最大值。
 * 假设窗口的大小为 M，数组的长度为 N。在窗口向右移动时，需要先在堆中删除离开窗口的元素，
 * 并将新到达的元素添加到堆中
 */
public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) return new int[0];
        int[] res = new int[nums.length + 1 - k];
        // 大顶堆
        PriorityQueue<Integer> heap = new PriorityQueue<>((new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        }));

        for (int i = 0; i < k; i++) {
            heap.add(nums[i]);
        }
        res[0] = heap.peek();
        for (int i = 0, j = k + i; j < nums.length;j++) {
            heap.remove(nums[i]);
            heap.add(nums[j]);
            res[++i] = heap.peek();
        }
        return res;


    }
}
