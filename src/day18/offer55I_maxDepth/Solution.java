package day18.offer55I_maxDepth;

import day15.offer34_pathSum.TreeNode;

public class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(maxDepth(root.left) + 1, maxDepth(root.right) + 1);
    }
}
