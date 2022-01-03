package day01.offer30_minStack;


import org.junit.Test;

/**
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数
 * 在该栈中，调用 min、push 及 pop 的时间复杂度都是 O(1)
 *
 * 分析：
 * 这道题想使用栈来做几乎不可能，如果将变量中的最小值弹出了，就没有办法得出最小值了
 * 因此，可以使用链表数据结构来实现这个功能
 */
public class MinStack1 {
    /** initialize your data structure here. */
    ListNode head;
    ListNode p;



    public MinStack1() {
        head = new ListNode(Integer.MAX_VALUE, Integer.MAX_VALUE);
        p = head;
    }

    public void push(int x) {
        int min = p.getMin() > x ? x : p.getMin();
        ListNode node  = new ListNode(x, min);
        p.next = node;
        node.pre = p;
        p = p.next;
    }

    public void pop() {
        if (p.pre == null) {
            return;
        } else {
            p = p.pre;
            p.next = null;
        }
    }

    public int top() {
        return p.getValue();
    }

    public int min() {
        return p.getMin();
    }

    @Test
    public void test() {
        MinStack1 minStack1 = new MinStack1();
        minStack1.push(-2);
        minStack1.push(0);
        minStack1.push(-3);

        System.out.println(minStack1.min());
        minStack1.pop();
        System.out.println(minStack1.top());
        System.out.println(minStack1.min());
    }
}

class ListNode {
    public ListNode next;
    public ListNode pre;
    private Integer value;

    // 这个属性用来保存当前变量中的最小值
    private Integer min;

    public ListNode(Integer value, Integer min) {
        this.value = value;
        this.min = min;
    }

    public Integer getValue() {
        return value;
    }

    public Integer getMin() {
        return min;
    }

    public ListNode() {
    }
}
