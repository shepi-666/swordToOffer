package day19.offer68_commonAncestor;

import day15.offer34_pathSum.TreeNode;

/**
 * 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
 * “对于有根树 T 的两个结点 p、q，
 * 最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大
 */
public class MySolution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if (p == null || q == null) return p == null ? q : p;
        // 题目中一个关键点就是，这是一颗排序二叉树，
        // 因此我们可以根据根节点的值来判断他们位于哪一个子树

        // 1.根节点的值小于二者的值，那么公共节点肯定位于右孩子
        if (root.val < p.val && root.val < q.val) return lowestCommonAncestor(root.right, p, q);
        // 2.根节点的值大于二者的值，公共节点位于左孩子
        if (root.val > p.val && root.val > q.val) return lowestCommonAncestor(root.left, p, q);
        return root;

    }
}
