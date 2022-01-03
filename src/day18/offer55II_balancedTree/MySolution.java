package day18.offer55II_balancedTree;

import day15.offer34_pathSum.TreeNode;

/**
 * 判断一颗树是否为平衡二叉树
 */
public class MySolution {
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        if (Math.abs(maxDepth(root.left) - maxDepth(root.right)) > 1)
            return false;
        else
            return isBalanced(root.left) && isBalanced(root.right);
    }

    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(maxDepth(root.left) + 1, maxDepth(root.right) + 1);
    }

}
