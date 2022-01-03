package day12.offer52_IntersectionNode;

import day11.offer18_deleteNode.ListNode;

/**
 * 两个结点不断的去对方的轨迹中寻找对方的身影，只要二人有交集，就终会相遇
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        ListNode l1 = headA;
        ListNode l2 = headB;

        while (l1 != l2) {
            l1 = l1 == null ? headB : l1.next;
            l2 = l2 == null ? headA : l2.next;
        }
        return l1;
    }
}
