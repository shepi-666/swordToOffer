package day07.offer27_mirroTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Solution {
    /**
     * 使用一个栈，一个队列
     * @param root
     * @return
     */
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) return null;
        Queue<TreeNode> queue = new LinkedList<>();
        Stack<Integer> stack = new Stack<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            for (int i = queue.size(); i > 0; i--) {
                TreeNode node = queue.poll();
                stack.push(node.val);
                queue.add(node);
            }
            for (int i = queue.size(); i > 0; i--) {
                TreeNode node = queue.poll();
                node.val = stack.pop();
                queue.add(node);
            }

            for (int i = queue.size(); i > 0; i--) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
        return root;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode (int x) { val = x; }
}

