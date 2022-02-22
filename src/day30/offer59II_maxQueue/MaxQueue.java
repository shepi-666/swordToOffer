package day30.offer59II_maxQueue;

import org.junit.Test;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 请定义一个队列并实现函数 max_value 得到队列里的最大值，
 * 要求函数max_value、push_back 和 pop_front 的均摊时间复杂度都是O(1)。
 *
 */
public class MaxQueue {
    // 用来存放最大值的大顶堆
    PriorityQueue<Integer> heap;

    Queue<Integer> queue;


    public MaxQueue() {
        this.heap = new PriorityQueue<>((o1, o2) -> o2 - o1);
        this.queue = new LinkedList<>();
    }

    public int max_value() {
        return queue.size() == 0 ? -1 : heap.peek();
    }

    public void push_back(int value) {
        queue.add(value);
        heap.add(value);
    }

    public int pop_front() {
        if (queue.size() == 0) return -1;
        Integer i = queue.poll();
        heap.remove(i);
        return i;
    }

    @Test
    public void testSolution() {
        MaxQueue queue = new MaxQueue();
        queue.push_back(1);
        queue.push_back(2);
        System.out.println(queue.max_value());
        System.out.println(queue.pop_front());
        System.out.println(queue.max_value());
    }
}


