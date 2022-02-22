package day30.offer59II_maxQueue;

import com.sun.scenario.effect.impl.state.LinearConvolveKernel;

import java.util.LinkedList;
import java.util.Queue;

public class MyQueue {
    // 使用两个队列来实现功能
    Queue<Integer> queue1;
    Queue<Integer> queue2; // 这个队列存放的数据是单调递减的

    public MyQueue() {
        this.queue1 = new LinkedList<>();
        this.queue2 = new LinkedList<>();
    }
    public int max_value() {
        return queue2.size() == 0 ? -1 : queue2.peek();
    }
    public void push_back(int value) {
        queue1.add(value);
        while (queue2.size() != 0 && queue2.peek() < value) {
            queue2.poll();
        }
        queue2.add(value);
    }
    public int pop_front() {
        if (queue1.size() == 0) {
            return -1;
        }
        if (queue1.peek().equals(queue2.peek())) {
            queue2.poll();
        }
        return queue1.poll();
    }
}
