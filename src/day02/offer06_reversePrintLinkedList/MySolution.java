package day02.offer06_reversePrintLinkedList;

import org.junit.Test;

import java.util.Arrays;

/**
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 * 方法1：倒叙遍历链表:使用头插法
 * 方法2：当然也可以正序打印填充数组，然后倒叙打印数组
 */
public class MySolution {

    public int[] reversePrint(ListNode head) {
        if (head == null) { return new int[0]; }
        if (head.next == null) { return new int[]{head.val}; }
        ListNode p = head;
        ListNode temp = null;
        ListNode root = new ListNode(0);
        int length = 0;
        while (p != null) {
            length ++;
            temp = p.next;
            p.next = root.next;
            root.next = p;
            p = temp;
        }
        int[] retVal = new int[length];
        p = root.next;
        int i = 0;
        while (p != null) {
            retVal[i++] = p.val;
            p = p.next;
        }
        return retVal;
    }

    @Test
    public void test() {
        ListNode node3 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node1 = new ListNode(1);

        node2.next = node3;
        node1.next = node2;

        int[] arrays = reversePrint(node1);
        System.out.println(Arrays.toString(arrays));

    }


}

class ListNode {
    int val;
    ListNode next;
    ListNode (int val) { this.val = val; }
}
