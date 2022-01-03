package day02.offer35_copyComplexLinkedList;

/**
 * 这个解法就是将新拷贝的节点放在原来链表的后面，然后这样随机节点的指向就很好判断了
 */
public class Solution2 {
    public Node copyRandomList(Node head) {
        // 如果头结点的值为空
        if (head == null) return null;
        // 第一遍对链表的遍历，将复制的节点穿插到当前链表中
        Node p = head;
        Node temp = null;
        while (p != null) {
            temp = p.next;
            p.next = new Node(p.val);
            p.next.next = temp;
            p = temp;
        }

        // 第二遍遍历，对随机节点赋值
        p = head;
        while (p != null) {
            p.next.random = (p.random == null ? null : p.random.next);
            p = p.next.next;
        }

        // 第三遍遍历，将复制的节点连接在一起
        Node newHead = head.next;
        Node pre = head;
        p = head.next;
        while(p.next != null) {
            pre.next = pre.next.next;
            p.next = p.next.next;
            pre = pre.next;
            p = p.next;
        }
        // 处理原链表的尾巴节点
        pre.next = null;
        return newHead;
    }
}
