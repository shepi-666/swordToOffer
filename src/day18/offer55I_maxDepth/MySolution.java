package day18.offer55I_maxDepth;

import day15.offer34_pathSum.TreeNode;

/**
 * 求二叉树的最大深度
 */
public class MySolution {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return dfs(root);
    }

    public int dfs(TreeNode root) {
        if (root == null) return 0;
        int depth1 = dfs(root.left) + 1;
        int depth2 = dfs(root.right) + 1;
        return Math.max(depth1, depth2);
    }
}
