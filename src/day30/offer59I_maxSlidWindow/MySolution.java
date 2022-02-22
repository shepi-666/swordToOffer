package day30.offer59I_maxSlidWindow;

import org.junit.Test;

import java.util.Arrays;
/**
 * 给定一个数组nums和滑动窗口的大小k，找出所有滑动窗口的最大值。
 */
public class MySolution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        ListNode header = new ListNode(0);
        int[] res = new int[nums.length + 1 - k];
        int i = 0; int j = k - 1;
        for (int m = i; m <= j; m++) {
            insertNode(header, nums[m]);
        }
        res[0] = header.next.val;
        j++;
        while (j < nums.length) {
            insertNode(header, nums[j]);
            deleteNode(header, nums[i]);
            res[++i] = header.next.val;
            j++;
        }
        return res;


    }

    /**
     * 往链表中有序插入数据
     * @param node
     * @param val
     */
    public void insertNode(ListNode node, int val) {
        ListNode temp = new ListNode(val);
        ListNode p = node;
        while(p.next != null) {
            if (p.next.val >= val ) p = p.next;
            else {
                temp.next = p.next;
                p.next = temp;
                return;
            }
        }
        // 到达链表的结尾
        p.next = temp;
    }

    /**
     * 往链表中删除
     * @param root
     * @param val
     */
    public void deleteNode(ListNode root, int val) {
        ListNode p =  root;
        while(p.next != null) {
            if (p.next.val != val ) p = p.next;
            else {
                p.next = p.next.next;
                return;
            }
        }
    }

    @Test
    public void testSolution() {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        System.out.println(Arrays.toString(maxSlidingWindow(nums, k)));
    }
}


class ListNode {
    public int val;
    public ListNode next;
    public ListNode(int val) {
        this.val = val;
    }

    public ListNode() { }
}