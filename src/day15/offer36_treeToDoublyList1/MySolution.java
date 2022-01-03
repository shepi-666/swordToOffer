package day15.offer36_treeToDoublyList1;

import java.util.ArrayList;
import java.util.List;

public class MySolution {
    /**
     * 先使用中序遍历的方式，将二叉树存储到List集合中，然后将这些串联起来
     * @param root
     * @return
     */
    public Node treeToDoublyList(Node root) {
        if (root == null) return null;
        List<Node> temp = new ArrayList<>();
        dfs(root, temp);
        int size = temp.size();
        // 将temp中存储的点串联起来
        for (int i = 0; i < temp.size(); i++) {
            Node node = temp.get(i);
            node.left = temp.get((i - 1 + size) % size);
            node.right = temp.get((i + 1) % size);
        }
        return temp.get(0);

    }

    public void dfs(Node node, List<Node> temp) {
        if (node == null) {
            return;
        }

        dfs(node.left, temp);
        temp.add(node);
        dfs(node.right, temp);
    }
}

class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
}
