package day07.offer27_mirroTree;

import java.util.Stack;

public class Solution2 {
    /**
     * 使用栈来实现树的镜像反转
     * @param root
     * @return
     */
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) return null;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node != null) {
                TreeNode leftNode = node.left;
                TreeNode rightNode = node.right;
                node.left = rightNode;
                node.right = leftNode;
                stack.push(leftNode);
                stack.push(rightNode);
            }
        }
        return root;

    }
}
