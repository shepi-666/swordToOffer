package day01.offer09_stack2queue;

import org.junit.Test;

import java.util.Stack;

/**
 * 使用两个栈实现一个队列的功能
 */
public class CQueue2 {
    // 栈1只负责插入操作
    private Stack<Integer> stack1;
    // 栈2只负责出队列的操作
    private Stack<Integer> stack2;

    public CQueue2() {
        stack1 = new Stack<Integer>();
        stack2 = new Stack<Integer>();
    }

    public void appendTail(int value) {
        stack1.push(value);
    }

    public int deleteHead() {
        if (stack2.size() == 0) {
            if (stack1.size() == 0) {
                return -1;
            } else {
                while (stack1.size() > 0) {
                    stack2.push(stack1.pop());
                }
            }
        }
        return stack2.pop();
    }

    @Test
    public void test() {
        CQueue2 cQueue = new CQueue2();
        cQueue.appendTail(1);
        cQueue.appendTail(45);
        cQueue.appendTail(3);
        cQueue.appendTail(4);
        System.out.println(cQueue.deleteHead());
        System.out.println(cQueue.deleteHead());
        System.out.println(cQueue.deleteHead());
        System.out.println(cQueue.deleteHead());
    }
}
