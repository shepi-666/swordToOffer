package day01.offer09_stack2queue;

import org.junit.Test;

import java.util.Stack;

/**
 * 使用两个栈实现一个队列的功能
 */
public class CQueue {
    private Stack<Integer> stack1 = new Stack<>();
    private Stack<Integer> stack2 = new Stack<>();
    private int size = 0;

    public CQueue() {
    }

    public void appendTail(int value) {
        size ++;
        stack1.push(value);
    }

    public int deleteHead() {
        if (size == 0) {
            return -1;
        }
        for (int i = 1; i < size; i++) {
            stack2.push(stack1.pop());
        }
        size--;
        int retVal = stack1.pop();
        for (int i = 0; i < size; i++) {
            stack1.push(stack2.pop());
        }
        return retVal;
    }

    @Test
    public void test() {
        CQueue cQueue = new CQueue();
        cQueue.appendTail(1);
        cQueue.appendTail(3);
        cQueue.appendTail(4);
        System.out.println(cQueue.deleteHead());
        System.out.println(cQueue.deleteHead());
        System.out.println(cQueue.deleteHead());
        System.out.println(cQueue.deleteHead());
    }
}
