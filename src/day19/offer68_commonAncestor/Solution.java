package day19.offer68_commonAncestor;

import day15.offer34_pathSum.TreeNode;

/**
 * 使用循环的做法
 */
public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p == null || q == null) return p == null ? q : p;
        while (root != null) {
            if (root.val < p.val && root.val < q.val) {
                root = root.right;
            } else if (root.val > p.val && root.val > q.val) {
                root = root.left;
            } else {
                break;
            }
        }
        return root;
    }
}
