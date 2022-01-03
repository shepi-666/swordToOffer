package day17.offer41_findMedian;

import java.util.PriorityQueue;
import java.util.Queue;

public class MedianFinder {
    Queue<Integer> A, B;
    public MedianFinder() {
        A = new PriorityQueue<>(); // 小顶堆，保存较大的一半
        B = new PriorityQueue<>((x, y) -> (y - x)); // 大顶堆，保存较小的一半
    }
    public void addNum(int num) {
        // 元素总数为奇数：向A中添加元素，将A顶中的元素弹入B
        if(A.size() != B.size()) {
            A.add(num);
            B.add(A.poll());
        } else {
            // 元素总数为偶数个：向B中添加元素，弹出的添加到A中
            B.add(num);
            A.add(B.poll());
        }
    }
    public double findMedian() {
        return A.size() != B.size() ? A.peek() : (A.peek() + B.peek()) / 2.0;
    }
    
}
