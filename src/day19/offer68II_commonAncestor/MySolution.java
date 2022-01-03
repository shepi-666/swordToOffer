package day19.offer68II_commonAncestor;

import day15.offer34_pathSum.TreeNode;

public class MySolution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        /*
        * 首先注意这个返回条件：
        * root == null：就说明递归到叶子节点的子节点，返回为null
        * p == root：说明找到了p节点
        * q == root：说明找到了q节点
        *
        * 因此，这个递归停止的条件就是如果找到了q节点或者p节点就返回
        * 否则就返回空
        *
        * ！！！错误理解：
        * 这个方法是找p和q的公共节点
        *
        * */
        if (root == null || p == root || q == root) {
            return root;
        }

        // 在左子节点中寻找q或者p节点
        TreeNode l = lowestCommonAncestor(root.left, p, q);
        // 在右子节点中寻找q或者p节点
        TreeNode r = lowestCommonAncestor(root.right, p, q);

        // 如果左子树中都没有找到p或者q，说明在右子树中,说明这两个节点一定在右子树中，或者找不到
        if (l == null) return r;
        // 说明此时两个节点都在左子树中
        if (r == null) return l;
        // 两个子树都没有找到，就返回root
        return root;


    }
}
