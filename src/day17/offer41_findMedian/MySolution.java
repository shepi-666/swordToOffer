package day17.offer41_findMedian;

import org.junit.Test;

/**
 * 设计一个支持以下两种操作的数据结构
 *      void addNum(int num) - 从数据流中添加一个整数到数据结构中
 *      double findMedian() - 返回目前所有元素的中位数
 * 我的设计思路：底层是一个链表，一个指针指向头结点，另一个指针指向中位数的节点
 */
public class MySolution {
    private ListNode head;
    private ListNode p;
    private ListNode med;
    // 设定一个boolean值，来判断med指针是否应该向后移动
    private int count;

    public MySolution() {
        head = new ListNode();
        p = head;
        med = head;
        count = 0;
    }

    public void addNum(int num) {
        p = head;
        med = head;

        count ++;
        int i = 0;
        // 创建节点
        ListNode node = new ListNode(num);
        while (p.next != null && p.next.val <= num) {
            if (i < count / 2) {
                med = med.next;
                i++;
            }
            p = p.next;
        }

        ListNode temp = p.next;
        p.next = node;
        node.next = temp;

        while (i < count / 2) {
            med = med.next;
            i++;
        }



    }

    public double findMedian() {
        if (count == 0) return 0.0;
        return count % 2 == 1 ? med.next.val : (med.val + med.next.val) / 2.0;
    }

    @Test
    public void test() {
        MySolution ms = new MySolution();
        ms.addNum(1);
        System.out.println(ms.findMedian());
        ms.addNum(-2);
        System.out.println(ms.findMedian());
        ms.addNum(-3);
        System.out.println(ms.findMedian());
        ms.addNum(-4);
        System.out.println(ms.findMedian());
        ms.addNum(-5);
        System.out.println(ms.findMedian());

    }
}

/**
 * 链表节点类
 */
class ListNode {
    public int val;
    public ListNode next;
    public ListNode() { }
    public ListNode(int val) {
        this.val = val;
    }
}
