package day06.offer32II_levelOrder;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。
 */
public class MySolution {
    /**
     * 思路：使用两个队列，每一层节点使用一个队列
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> retList = new ArrayList<>();
        if (root == null) {
            return retList;
        }
        Queue<TreeNode> queue1 = new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();
        queue1.add(root);
        retList = levelOrder(queue1, queue2, retList);

        return retList;
    }

    public List<List<Integer>> levelOrder(Queue<TreeNode> queue1, Queue<TreeNode> queue2,
                                          List<List<Integer>> retList) {
        if (queue1 == null || queue1.isEmpty()) return retList;
        List<Integer> list = new ArrayList<>();
        while (!queue1.isEmpty()) {
            TreeNode node = queue1.poll();
            list.add(node.val);
            if (node.left != null) {
                queue2.add(node.left);
            }
            if (node.right != null)
                queue2.add(node.right);
        }
        retList.add(list);
        levelOrder(queue2, queue1, retList);
        return retList;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    public TreeNode (int x) {
        val = x;
    }
}
