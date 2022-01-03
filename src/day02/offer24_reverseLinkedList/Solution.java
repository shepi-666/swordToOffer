package day02.offer24_reverseLinkedList;

/**
 * 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
 *
 * 翻转链表：使用头插法[100%]
 */
public class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode temp;
        ListNode p = head;
        ListNode root = new ListNode(0);
        while (p != null) {
            temp = p.next;
            p.next = root.next;
            root.next = p;
            p = temp;
        }
        return root.next;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
