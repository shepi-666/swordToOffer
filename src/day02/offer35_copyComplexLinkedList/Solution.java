package day02.offer35_copyComplexLinkedList;

import java.util.HashMap;
import java.util.Map;

/**
 * 复杂链表的拷贝
 *
 * 思路：使用回溯的方式，让每一个节点的拷贝工作相互独立，就像是一棵树一样
 * 对于当前节点，我们首先进行拷贝，然后进行当前节点的后继节点和当前节点的随机指针只想的节点进行拷贝
 * 拷贝完成之后将创建新的几点的指针返回
 */
public class Solution {
    // 创建HashMap来存储已经完成拷贝的节点
    Map<Node, Node> map = new HashMap<>();
    public Node copyRandomList(Node head) {
        if (head == null) return null;
        if (!map.containsKey(head)) {
            // 首先对当前节点进行拷贝
            Node newHead = new Node(head.val);
            // 对已经拷贝过的节点做记录
            map.put(head, newHead);

            // 拷贝下一个节点
            newHead.next = copyRandomList(head.next);

            // 拷贝随机的节点
            newHead.random = copyRandomList(head.random);
        }
        return map.get(head);
    }
}

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
