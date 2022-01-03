package day02.offer24_reverseLinkedList;

import java.util.Stack;

/**
 * 使用栈的数据结构帮助链表的翻转[8.13%]
 */
public class Solution2 {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        // 创建一个栈，用来存储节点
        Stack<ListNode> stack = new Stack<>();
        // 对整个链表进行遍历将节点存储到栈中
        ListNode p = head;
        while (p != null) {
            stack.push(p);
            p = p.next;
        }
        // 创建新的头结点
        ListNode newHead = new ListNode(0);
        p = newHead;
        while (!stack.isEmpty()) {
            p.next = stack.pop();
            p = p.next;
        }
        p.next = null;
        return newHead.next;
    }
}
