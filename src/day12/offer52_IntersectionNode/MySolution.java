package day12.offer52_IntersectionNode;

import day11.offer18_deleteNode.ListNode;

/**
 * 输入两个链表，找出它们的第一个公共节点。
 */
public class MySolution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p1 = headA;
        ListNode p2 = headB;

        int length1 = 0;
        int length2 = 0;
        while (p1 != null) {
            length1++;
            p1 = p1.next;
        }

        while (p2 != null) {
            length2++;
            p2 = p2.next;
        }

        p1 = headA;
        p2 = headB;
        if (length1 > length2) {
            for (int i = 0; i < length1 - length2; i++) {
                p1 = p1.next;
            }
        } else {
            for (int i = 0; i < length2 - length1; i++) {
                p2 = p2.next;
            }
        }

        while (p1 != null && p2 != null) {
            if (p1 == p2) return p1;
            p1 = p1.next;
            p2 = p2.next;
        }
        return null;
    }
}
