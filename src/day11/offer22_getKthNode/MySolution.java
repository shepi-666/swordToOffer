package day11.offer22_getKthNode;

import day11.offer18_deleteNode.ListNode;

/**
 * 输入一个链表，输出该链表中倒数第k个节点
 */
public class MySolution {
    public ListNode getKthFromEnd(ListNode head, int k) {
        if (head == null) return null;
        ListNode pre = head;
        ListNode cur = head;

        for (int i = 1; i < k; i++) {
            cur = cur.next;
        }

        while (cur.next != null) {
            cur = cur.next;
            pre = pre.next;
        }

        return pre;
    }
}
